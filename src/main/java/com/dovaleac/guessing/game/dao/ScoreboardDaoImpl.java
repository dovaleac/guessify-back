package com.dovaleac.guessing.game.dao;

import com.dovaleac.guessing.game.jooq.generated.tables.PlayerInScoreboard;
import com.dovaleac.guessing.game.jooq.generated.tables.records.PlayerInScoreboardRecord;
import com.dovaleac.guessing.game.model.scoreboard.Scoreboard;
import com.dovaleac.guessing.game.utils.jooq.DslContextSupplier;

import java.util.stream.Stream;

public class ScoreboardDaoImpl implements ScoreboardDao {

  private static final PlayerInScoreboard PLAYER_IN_SCOREBOARD =
      PlayerInScoreboard.PLAYER_IN_SCOREBOARD;
  private final DslContextSupplier dslContextSupplier;

  public ScoreboardDaoImpl(DslContextSupplier dslContextSupplier) {
    this.dslContextSupplier = dslContextSupplier;
  }

  @Override
  public Stream<PlayerInScoreboardRecord> getScoreboard(int gameId) {
    return null;
  }

  @Override
  public void updateScoreboard(int gameId, Scoreboard scoreboard) {
    dslContextSupplier.executeConsumer(
        dslContext ->
            scoreboard
                .getPerformances()
                .forEach(
                    playerPerformance ->
                        dslContext
                            .update(PLAYER_IN_SCOREBOARD)
                            .set(PLAYER_IN_SCOREBOARD.POINTS, playerPerformance.getPoints())
                            .set(
                                PLAYER_IN_SCOREBOARD.QUESTIONS_GUESSED,
                                playerPerformance.getQuestionsGuessed())
                            .where(
                                PLAYER_IN_SCOREBOARD.PLAYER_ID.eq(playerPerformance.getPlayerId()))
                            .and(PLAYER_IN_SCOREBOARD.GAME_ID.eq(gameId))
                            .execute()
                ));
  }
}
