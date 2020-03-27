package com.dovaleac.guessing.game.dao;

import com.dovaleac.guessing.game.jooq.generated.tables.records.PlayerRecord;
import com.dovaleac.guessing.game.jooq.generated.tables.records.RoomRecord;
import com.dovaleac.guessing.game.model.enums.PlayerRole;

public interface RoomDao {

  RoomRecord createRoomByNumberAndPassword(String number, String password);
  RoomRecord getRoomByNumberAndPassword(String number, String password);
  PlayerRecord addPlayerToRoom(int roomId, String playerId, PlayerRole contender);

}
