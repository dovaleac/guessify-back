package com.dovaleac.guessing.game.service;

import com.dovaleac.guessing.game.dao.GameDao;
import com.dovaleac.guessing.game.dao.RoomDao;
import com.dovaleac.guessing.game.jooq.generated.games.tables.records.GameRecord;
import com.dovaleac.guessing.game.model.dto.GameId;
import com.dovaleac.guessing.game.model.dto.Player;
import com.dovaleac.guessing.game.model.dto.RoomDto;
import com.dovaleac.guessing.game.model.enums.PlayerRole;

import javax.inject.Singleton;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Singleton
public class RoomServiceImpl implements RoomService {

  private final RoomDao roomDao;
  private final GameDao gameDao;

  public RoomServiceImpl(RoomDao roomDao, GameDao gameDao) {
    this.roomDao = roomDao;
    this.gameDao = gameDao;
  }

  @Override
  public RoomDto createRoom(String password) {
    String number = UUID.randomUUID().toString();
    return new RoomDto(roomDao.createRoomByNumberAndPassword(number, password).getId(), number);
  }

  @Override
  public Optional<GameId> getCurrentGame(String number, String password) {
    Integer roomId = roomDao.getRoomByNumberAndPassword(number, password).getId();
    return gameDao.getCurrentGameForRoom(roomId).map(GameRecord::getId).map(GameId::new);
  }

  @Override
  public Optional<Player> addPlayerToGame(int roomId, String playerName) {
    return gameDao
        .getCurrentGameForRoom(roomId)
        .map(GameRecord::getId)
        .map(
            gameId ->
                Player.fromRecord(
                    roomDao.addPlayerToRoom(roomId, playerName, PlayerRole.CONTENDER), gameId));
  }

  @Override
  public Player addMasterPlayerToGame(int roomId, String playerName) {
    return Player.fromRecord(roomDao.addPlayerToRoom(roomId, playerName, PlayerRole.MASTER));
  }

  @Override
  public List<Player> getPlayersInRoom(int roomId) {
    return roomDao.getPlayersInRoom(roomId).map(Player::fromRecord).collect(Collectors.toList());
  }
}
