package com.dovaleac.guessing.game.dao;

import com.dovaleac.guessing.game.jooq.generated.games.tables.records.PlayerRecord;
import com.dovaleac.guessing.game.jooq.generated.games.tables.records.RoomRecord;
import com.dovaleac.guessing.game.model.enums.PlayerRole;

import java.util.stream.Stream;

public interface RoomDao {

  RoomRecord createRoomByNumberAndPassword(String number, String password);
  RoomRecord getRoomByNumberAndPassword(String number, String password);
  PlayerRecord addPlayerToRoom(int roomId, String playerId, PlayerRole role);
  Stream<PlayerRecord> getPlayersInRoom(int roomId);

}
