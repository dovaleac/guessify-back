package com.dovaleac.guessing.game.service;

import com.dovaleac.guessing.game.model.dto.GameId;
import com.dovaleac.guessing.game.model.dto.Player;
import com.dovaleac.guessing.game.model.dto.RoomId;
import io.micronaut.http.annotation.QueryValue;

import java.util.Optional;

public interface RoomService {

  RoomId createRoom(@QueryValue String number, @QueryValue String password);
  Optional<GameId> getCurrentGame(@QueryValue String number, @QueryValue String password);
  Optional<Player> addPlayerToGame(int roomId, String playerName);
  Player addMasterPlayerToGame(int roomId, String playerName);

}
