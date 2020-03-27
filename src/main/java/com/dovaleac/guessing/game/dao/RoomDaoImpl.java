package com.dovaleac.guessing.game.dao;

import com.dovaleac.guessing.game.jooq.generated.tables.Player;
import com.dovaleac.guessing.game.jooq.generated.tables.Room;
import com.dovaleac.guessing.game.jooq.generated.tables.records.PlayerRecord;
import com.dovaleac.guessing.game.jooq.generated.tables.records.RoomRecord;
import com.dovaleac.guessing.game.model.enums.PlayerRole;
import com.dovaleac.guessing.game.model.enums.PlayerStatus;
import com.dovaleac.guessing.game.utils.jooq.DslContextSupplier;

import javax.inject.Singleton;

@Singleton
public class RoomDaoImpl implements RoomDao {

  private final DslContextSupplier dslContextSupplier;
  private static final Room ROOM = Room.ROOM;
  private static final Player PLAYER = Player.PLAYER;

  public RoomDaoImpl(
      DslContextSupplier dslContextSupplier) {
    this.dslContextSupplier = dslContextSupplier;
  }

  @Override
  public RoomRecord createRoomByNumberAndPassword(String number, String password) {
    return dslContextSupplier.executeFunction(dslContext -> dslContext
        .insertInto(ROOM)
        .columns(ROOM.NUMBER, ROOM.PASSWORD)
        .values(number, password)
        .returning(ROOM.ID).fetchOne()
    );
  }

  @Override
  public RoomRecord getRoomByNumberAndPassword(String number, String password) {
    return dslContextSupplier.executeFunction(dslContext -> dslContext
        .selectFrom(ROOM)
        .where(Room.ROOM.NUMBER.eq(number))
        .and(Room.ROOM.PASSWORD.eq(password))
        .fetchOne()
    );
  }

  @Override
  public PlayerRecord addPlayerToRoom(int roomId, String playerName, PlayerRole contender) {
    return dslContextSupplier.executeFunction(dslContext -> dslContext
        .insertInto(PLAYER)
        .columns(PLAYER.ROOM_ID, PLAYER.NAME, PLAYER.ROLE, PLAYER.STATUS)
        .values(roomId, playerName, contender.name(), PlayerStatus.ACTIVE.name())
        .returning(PLAYER.fields()).fetchOne()
    );
  }
}
