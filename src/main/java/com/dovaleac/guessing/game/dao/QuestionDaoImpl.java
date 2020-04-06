package com.dovaleac.guessing.game.dao;

import com.dovaleac.guessing.game.jooq.generated.games.tables.QuestionInGame;
import com.dovaleac.guessing.game.jooq.generated.games.tables.records.QuestionInGameRecord;
import com.dovaleac.guessing.game.jooq.generated.independent.tables.QuestionSet;
import com.dovaleac.guessing.game.jooq.generated.independent.tables.records.QuestionRecord;
import com.dovaleac.guessing.game.jooq.generated.independent.tables.records.QuestionSetRecord;
import com.dovaleac.guessing.game.model.enums.QuestionInGameStatus;
import com.dovaleac.guessing.game.model.request.Question;
import com.dovaleac.guessing.game.utils.jooq.DslContextSupplier;
import org.jooq.impl.DSL;

import javax.inject.Singleton;
import java.util.stream.Stream;

@Singleton
public class QuestionDaoImpl implements QuestionDao {

  private static final QuestionSet QUESTION_SET = QuestionSet.QUESTION_SET;
  private static final QuestionInGame QUESTION_IN_GAME = QuestionInGame.QUESTION_IN_GAME;
  private static final com.dovaleac.guessing.game.jooq.generated.independent.tables.Question
      QUESTION = com.dovaleac.guessing.game.jooq.generated.independent.tables.Question.QUESTION;
  private final DslContextSupplier dslContextSupplier;

  public QuestionDaoImpl(DslContextSupplier dslContextSupplier) {
    this.dslContextSupplier = dslContextSupplier;
  }

  public QuestionSetRecord createQuestionSet(int langId) {
    return dslContextSupplier.executeFunction(
        dslContext ->
            dslContext
                .insertInto(QUESTION_SET)
                .columns(QUESTION_SET.LANG_ID)
                .values(langId)
                .returning(QUESTION_SET.ID)
                .fetchOne());
  }

  @Override
  public QuestionRecord createQuestion(Question question, int questionSetId) {
    return dslContextSupplier.executeFunction(
        dslContext ->
            dslContext
                .insertInto(QUESTION)
                .columns(
                    QUESTION.ANSWER,
                    QUESTION.CLUES,
                    QUESTION.QUESTION_SET_ID,
                    QUESTION.DIFFICULTY,
                    QUESTION.FUN_FACTS)
                .values(
                    question.getAnswer(),
                    question.getClues(),
                    questionSetId,
                    question.getDifficulty(),
                    question.getFunFacts())
                .returning(QUESTION.ID)
                .fetchOne());
  }

  @Override
  public void consolidateQuestionsForGame(int gameId, int questionSetId) {
    dslContextSupplier.executeConsumer(
        dslContext ->
            dslContext
                .insertInto(QUESTION_IN_GAME)
                .columns(
                    QUESTION_IN_GAME.QUESTION_ID,
                    QUESTION_IN_GAME.GAME_ID,
                    QUESTION_IN_GAME.CURRENT_CLUE,
                    QUESTION_IN_GAME.EXECUTION_ORDER,
                    QUESTION_IN_GAME.STATUS)
                .select(
                    dslContext
                        .select(
                            QUESTION.ID,
                            DSL.val(gameId),
                            DSL.val(0),
                            DSL.rowNumber().over().orderBy(QUESTION.ID.asc()),
                            DSL.when(
                                    DSL.rowNumber().over().orderBy(QUESTION.ID.asc()).eq(1),
                                    QuestionInGameStatus.ACTIVE.name())
                                .otherwise(QuestionInGameStatus.READY.name()))
                        .from(QUESTION)
                        .where(QUESTION.QUESTION_SET_ID.eq(questionSetId)))
                .execute());
  }

  @Override
  public void moveQuestionFromOldStatusToNewStatus(
      int questionInGameId, QuestionInGameStatus oldStatus, QuestionInGameStatus newStatus) {
    dslContextSupplier.executeConsumer(
        dslContext ->
            dslContext
                .update(QUESTION_IN_GAME)
                .set(QUESTION_IN_GAME.STATUS, newStatus.name())
                .where(QUESTION_IN_GAME.ID.eq(questionInGameId))
                .and(QUESTION_IN_GAME.STATUS.eq(oldStatus.name()))
                .execute());
  }

  @Override
  public Stream<QuestionInGameRecord> getQuestionsInGameForGameId(int gameId) {
    return dslContextSupplier.executeFunction(
        dslContext ->
            dslContext
                .selectFrom(QUESTION_IN_GAME)
                .where(QUESTION_IN_GAME.GAME_ID.eq(gameId))
                .fetchStream());
  }
}
