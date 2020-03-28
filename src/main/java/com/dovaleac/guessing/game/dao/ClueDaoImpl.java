package com.dovaleac.guessing.game.dao;

import com.dovaleac.guessing.game.jooq.generated.games.tables.ClueRequest;
import com.dovaleac.guessing.game.jooq.generated.games.tables.QuestionInGame;
import com.dovaleac.guessing.game.utils.jooq.DslContextSupplier;

import javax.inject.Singleton;
import java.time.OffsetDateTime;

@Singleton
public class ClueDaoImpl implements ClueDao {

  public static final ClueRequest CLUE_REQUEST = ClueRequest.CLUE_REQUEST;
  public static final QuestionInGame QUESTION_IN_GAME = QuestionInGame.QUESTION_IN_GAME;
  private final DslContextSupplier dslContextSupplier;

  public ClueDaoImpl(DslContextSupplier dslContextSupplier) {
    this.dslContextSupplier = dslContextSupplier;
  }

  @Override
  public void askForClue(int questionInGameId, int playerId, int currentClue, OffsetDateTime time) {
    dslContextSupplier.executeConsumer(
        dslContext ->
            dslContext
                .insertInto(CLUE_REQUEST)
                .columns(
                    CLUE_REQUEST.CURRENT_CLUE,
                    CLUE_REQUEST.PLAYER_ID,
                    CLUE_REQUEST.QUESTION_IN_GAME_ID,
                    CLUE_REQUEST.MOMENT)
                .values(currentClue, playerId, questionInGameId, time)
                .execute());
  }

  @Override
  public void giveClue(int questionInGameId, int nextClue) {
    dslContextSupplier.executeConsumer(
        dslContext ->
            dslContext
                .update(QUESTION_IN_GAME)
                .set(QUESTION_IN_GAME.CURRENT_CLUE, nextClue)
                .where(QUESTION_IN_GAME.ID.eq(questionInGameId))
                .execute());
  }
}
