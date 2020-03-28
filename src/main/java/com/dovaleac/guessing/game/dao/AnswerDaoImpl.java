package com.dovaleac.guessing.game.dao;

import com.dovaleac.guessing.game.jooq.generated.games.tables.Answer;
import com.dovaleac.guessing.game.jooq.generated.games.tables.QuestionInGame;
import com.dovaleac.guessing.game.jooq.generated.games.tables.records.AnswerRecord;
import com.dovaleac.guessing.game.model.enums.AnswerStatus;
import com.dovaleac.guessing.game.utils.jooq.DslContextSupplier;

import javax.inject.Singleton;
import java.time.OffsetDateTime;
import java.util.stream.Stream;

@Singleton
public class AnswerDaoImpl implements AnswerDao {

  public static final Answer ANSWER = Answer.ANSWER;
  public static final QuestionInGame QUESTION_IN_GAME = QuestionInGame.QUESTION_IN_GAME;
  private final DslContextSupplier dslContextSupplier;

  public AnswerDaoImpl(DslContextSupplier dslContextSupplier) {
    this.dslContextSupplier = dslContextSupplier;
  }

  @Override
  public void createAnswer(
      int questionInGameId, int playerId, int currentClue, String answer, OffsetDateTime moment) {
    dslContextSupplier.executeConsumer(
        dslContext ->
            dslContext
                .insertInto(ANSWER)
                .columns(
                    ANSWER.ANSWER_,
                    ANSWER.MOMENT,
                    ANSWER.STATUS,
                    ANSWER.QUESTION_IN_GAME_ID,
                    ANSWER.PLAYER_ID,
                    ANSWER.CURRENT_CLUE)
                .values(
                    answer,
                    moment,
                    AnswerStatus.NOT_JUDGED.name(),
                    questionInGameId,
                    playerId,
                    currentClue)
                .execute()
    );
  }

  @Override
  public void resolveAnswer(int answerId, AnswerStatus status) {
    dslContextSupplier.executeConsumer(
        dslContext ->
            dslContext
                .update(ANSWER)
                .set(ANSWER.STATUS, status.name())
                .where(ANSWER.ID.eq(answerId))
        .execute()
    );
  }

  @Override
  public Stream<AnswerRecord> getAllAnswersInGame(int gameId) {
    return dslContextSupplier.executeFunctionWithStream(dslContext ->
        dslContext
            .select(ANSWER.fields())
        .from(ANSWER)
            .join(QUESTION_IN_GAME)
            .on(ANSWER.QUESTION_IN_GAME_ID.eq(QUESTION_IN_GAME.ID))
            .where(QUESTION_IN_GAME.GAME_ID.eq(gameId))
        .fetchStream(), recordStream -> recordStream.map(record -> record.into(ANSWER))
    );
  }
}
