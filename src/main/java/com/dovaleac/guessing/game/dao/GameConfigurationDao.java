package com.dovaleac.guessing.game.dao;

import com.dovaleac.guessing.game.jooq.generated.tables.records.GameConfigRecord;
import com.dovaleac.guessing.game.jooq.generated.tables.records.GameRecord;
import com.dovaleac.guessing.game.model.dto.GameDto;
import com.dovaleac.guessing.game.model.request.GameConfiguration;

import java.util.Optional;

public interface GameConfigurationDao {

  GameConfigRecord createGameConfiguration(GameConfiguration gameConfiguration, int scoringId);
}
