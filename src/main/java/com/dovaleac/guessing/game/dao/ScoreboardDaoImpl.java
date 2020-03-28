package com.dovaleac.guessing.game.dao;

import com.dovaleac.guessing.game.jooq.generated.games.tables.Player;
import com.dovaleac.guessing.game.jooq.generated.games.tables.PlayerInScoreboard;
import com.dovaleac.guessing.game.jooq.generated.games.tables.records.PlayerInScoreboardRecord;
import com.dovaleac.guessing.game.model.enums.PlayerRole;
import com.dovaleac.guessing.game.model.enums.PlayerStatus;
import com.dovaleac.guessing.game.model.scoreboard.Scoreboard;
import com.dovaleac.guessing.game.utils.jooq.DslContextSupplier;
import org.jooq.impl.DSL;

import javax.inject.Singleton;
import java.util.stream.Stream;

@Singleton
public class ScoreboardDaoImpl implements ScoreboardDao {

  private static final PlayerInScoreboard PLAYER_IN_SCOREBOARD =
      PlayerInScoreboard.PLAYER_IN_SCOREBOARD;
  private static final Player PLAYER = Player.PLAYER;

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
                            .execute()));
  }

  @Override
  public void insertAllAvailablePlayersFromRoom(int gameId, int roomId) {
    dslContextSupplier.executeConsumer(
        dslContext ->
            dslContext
                .insertInto(PLAYER_IN_SCOREBOARD)
                .columns(
                    PLAYER_IN_SCOREBOARD.GAME_ID,
                    PLAYER_IN_SCOREBOARD.PLAYER_ID,
                    PLAYER_IN_SCOREBOARD.POINTS,
                    PLAYER_IN_SCOREBOARD.QUESTIONS_GUESSED)
                .select(
                    dslContext
                        .select(DSL.val(gameId), PLAYER.ID, DSL.val(0), DSL.val(0))
                        .from(PLAYER)
                        .where(PLAYER.ROOM_ID.eq(roomId))
                        .and(PLAYER.STATUS.eq(PlayerStatus.ACTIVE.name()))
                        .and(PLAYER.ROLE.eq(PlayerRole.CONTENDER.name())))
                .execute());
  }
}
