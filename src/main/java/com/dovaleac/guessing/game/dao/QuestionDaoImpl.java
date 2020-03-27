package com.dovaleac.guessing.game.dao;

import com.dovaleac.guessing.game.jooq.generated.tables.QuestionInGame;
import com.dovaleac.guessing.game.jooq.generated.tables.QuestionSet;
import com.dovaleac.guessing.game.jooq.generated.tables.records.QuestionRecord;
import com.dovaleac.guessing.game.jooq.generated.tables.records.QuestionSetRecord;
import com.dovaleac.guessing.game.model.enums.QuestionInGameStatus;
import com.dovaleac.guessing.game.model.request.Question;
import com.dovaleac.guessing.game.utils.jooq.DslContextSupplier;
import org.jooq.impl.DSL;

import javax.inject.Singleton;

@Singleton
public class QuestionDaoImpl implements QuestionDao {

  private static final QuestionSet QUESTION_SET = QuestionSet.QUESTION_SET;
  private static final QuestionInGame QUESTION_IN_GAME = QuestionInGame.QUESTION_IN_GAME;
  private static final com.dovaleac.guessing.game.jooq.generated.tables.Question QUESTION =
      com.dovaleac.guessing.game.jooq.generated.tables.Question.QUESTION;
  private final DslContextSupplier dslContextSupplier;

  public QuestionDaoImpl(DslContextSupplier dslContextSupplier) {
    this.dslContextSupplier = dslContextSupplier;
  }

  @Override
  public QuestionSetRecord createQuestionSet() {
    return dslContextSupplier.executeFunction(
        dslContext ->
            dslContext
                .insertInto(QUESTION_SET)
                .defaultValues()
                    .returning(QUESTION_SET.ID)
                .fetchOne());
  }

  @Override
  public QuestionRecord createQuestion(Question question, int questionSetId) {
    return dslContextSupplier.executeFunction(
        dslContext ->
            dslContext
                .insertInto(QUESTION)
                .columns(QUESTION.ANSWER, QUESTION.CLUES, QUESTION.QUESTION_SET_ID)
                .values(question.getAnswer(), question.getClues(), questionSetId)
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
                            DSL.rowNumber()
                                .over()
                                .partitionBy(QUESTION.ID)
                                .orderBy(QUESTION.ID.asc()),
                            DSL.val(QuestionInGameStatus.READY.name()))
                        .from(QUESTION)
                        .where(QUESTION.QUESTION_SET_ID.eq(questionSetId)))
        .execute()
    );
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
        .execute()
    );
  }
}
