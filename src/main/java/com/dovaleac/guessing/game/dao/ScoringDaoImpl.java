package com.dovaleac.guessing.game.dao;

import com.dovaleac.guessing.game.adapter.ScoringAdapter;
import com.dovaleac.guessing.game.jooq.generated.tables.Game;
import com.dovaleac.guessing.game.jooq.generated.tables.GameConfig;
import com.dovaleac.guessing.game.jooq.generated.tables.records.ScoringRecord;
import com.dovaleac.guessing.game.model.request.Scoring;
import com.dovaleac.guessing.game.utils.jooq.DslContextSupplier;

import javax.inject.Singleton;

@Singleton
public class ScoringDaoImpl implements ScoringDao {

  public static final com.dovaleac.guessing.game.jooq.generated.tables.Scoring SCORING =
      com.dovaleac.guessing.game.jooq.generated.tables.Scoring.SCORING;
  public static final GameConfig GAME_CONFIG = GameConfig.GAME_CONFIG;
  public static final Game GAME = Game.GAME;

  private final DslContextSupplier dslContextSupplier;

  public ScoringDaoImpl(DslContextSupplier dslContextSupplier) {
    this.dslContextSupplier = dslContextSupplier;
  }

  @Override
  public ScoringRecord createScoring(Scoring scoring) {
    return dslContextSupplier.executeFunction(
        dslContext -> {
          String scorings =
              ScoringAdapter.serialize(ScoringAdapter.deserialize(scoring.getScorings()));
          return dslContext
              .insertInto(SCORING)
              .columns(SCORING.SCORINGS, SCORING.MALUS_IF_MISSED)
              .values(scorings, scoring.getMalusIfMissed())
              .returning(SCORING.ID)
              .fetchOne();
        });
  }

  @Override
  public ScoringRecord getScoringForGame(int gameId) {
    return dslContextSupplier.executeFunction(
        dslContext ->
            dslContext
                .select(SCORING.fields())
                .from(SCORING)
                .join(GAME_CONFIG)
                .on(SCORING.ID.eq(GAME_CONFIG.SCORING_ID))
                .join(GAME)
                .on(GAME.GAME_CONFIG_ID.eq(GAME_CONFIG.ID))
                .where(GAME.ID.eq(gameId))
                .fetchOne()
                .into(ScoringRecord.class));
  }
}
