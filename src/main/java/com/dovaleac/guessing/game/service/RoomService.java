package com.dovaleac.guessing.game.service;

import com.dovaleac.guessing.game.model.dto.GameId;
import com.dovaleac.guessing.game.model.dto.Player;
import com.dovaleac.guessing.game.model.dto.RoomDto;

import java.util.List;
import java.util.Optional;

public interface RoomService {

  RoomDto createRoom(String password);
  Optional<GameId> getCurrentGame(String number, String password);
  Optional<Player> addPlayerToGame(int roomId, String playerName);
  Player addMasterPlayerToGame(int roomId, String playerName);
  List<Player> getPlayersInRoom(int roomId);

}
