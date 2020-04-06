package com.dovaleac.guessing.game.dao;

import com.dovaleac.guessing.game.jooq.generated.games.tables.Game;
import com.dovaleac.guessing.game.jooq.generated.games.tables.GameConfig;
import com.dovaleac.guessing.game.jooq.generated.games.tables.records.GameConfigRecord;
import com.dovaleac.guessing.game.model.request.GameConfiguration;
import com.dovaleac.guessing.game.utils.jooq.DslContextSupplier;
import org.jooq.Record3;

import javax.inject.Singleton;

@Singleton
public class GameConfigurationDaoImpl implements GameConfigurationDao {

  public static final Game GAME = Game.GAME;
  public static final GameConfig GAME_CONFIG = GameConfig.GAME_CONFIG;
  private final DslContextSupplier dslContextSupplier;

  public GameConfigurationDaoImpl(DslContextSupplier dslContextSupplier) {
    this.dslContextSupplier = dslContextSupplier;
  }

  @Override
  public GameConfigRecord createGameConfiguration(
      GameConfiguration gameConfiguration, int scoringId) {
    return dslContextSupplier.executeFunction(
        dslContext ->
            dslContext
                .insertInto(GAME_CONFIG)
                .columns(
                    GAME_CONFIG.CLUES_PER_QUESTION,
                    GAME_CONFIG.ERRORS_ALLOWED_PER_QUESTION,
                    GAME_CONFIG.SCORING_ID,
                    GAME_CONFIG.TOTAL_ROUNDS)
                .values(
                    gameConfiguration.getCluesPerQuestion(),
                    gameConfiguration.getErrorsAllowedPerQuestion(),
                    scoringId,
                    gameConfiguration.getTotalRounds())
                .returning(GAME_CONFIG.ID)
                .fetchOne());
  }


  @Override
  public GameConfiguration getGameConfiguration(int gameId) {
    Record3<Integer, Integer, Integer> dbRecord = dslContextSupplier.executeFunction(dslContext -> dslContext
        .select(
            GAME_CONFIG.TOTAL_ROUNDS,
            GAME_CONFIG.CLUES_PER_QUESTION,
            GAME_CONFIG.ERRORS_ALLOWED_PER_QUESTION
        )
        .from(GAME_CONFIG)
        .join(GAME)
        .on(GAME.GAME_CONFIG_ID.eq(GAME_CONFIG.ID))
        .where(GAME.ID.eq(gameId))
        .fetchOne()

    );
    return new GameConfiguration(
        dbRecord.component1(),
        dbRecord.component2(),
        dbRecord.component3(),
        null
    );
  }
}
