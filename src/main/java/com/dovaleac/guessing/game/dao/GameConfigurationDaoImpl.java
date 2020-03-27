package com.dovaleac.guessing.game.dao;

import com.dovaleac.guessing.game.jooq.generated.tables.GameConfig;
import com.dovaleac.guessing.game.jooq.generated.tables.records.GameConfigRecord;
import com.dovaleac.guessing.game.model.request.GameConfiguration;
import com.dovaleac.guessing.game.utils.jooq.DslContextSupplier;

import javax.inject.Singleton;

@Singleton
public class GameConfigurationDaoImpl implements GameConfigurationDao {

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
}
