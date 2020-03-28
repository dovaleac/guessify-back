package com.dovaleac.guessing.game.dao;

import com.dovaleac.guessing.game.jooq.generated.games.tables.records.GameRecord;
import com.dovaleac.guessing.game.model.dto.GameDto;

import java.util.Optional;

public interface GameDao {

  Optional<GameRecord> getCurrentGameForRoom(int roomId);

  GameDto getDtoFromRecord(GameRecord gameRecord);

  GameRecord getGameFromId(int id);

  boolean startGame(int gameId);

  boolean finishGame(int gameId);

  GameRecord createGame(
      int gameConfigId, int roomId, int masterPlayerId, int questionSetId, int langId);
}
