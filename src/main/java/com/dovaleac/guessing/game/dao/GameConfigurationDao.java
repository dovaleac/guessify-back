package com.dovaleac.guessing.game.dao;

import com.dovaleac.guessing.game.jooq.generated.games.tables.records.GameConfigRecord;
import com.dovaleac.guessing.game.model.request.GameConfiguration;

public interface GameConfigurationDao {

  GameConfigRecord createGameConfiguration(GameConfiguration gameConfiguration, int scoringId);
  GameConfiguration getGameConfiguration(int gameId);
}
