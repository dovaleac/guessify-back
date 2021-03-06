package com.dovaleac.guessing.game.controller;

import com.dovaleac.guessing.game.model.dto.GameId;
import com.dovaleac.guessing.game.model.dto.Player;
import com.dovaleac.guessing.game.model.dto.RoomDto;
import com.dovaleac.guessing.game.service.RoomService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Patch;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.QueryValue;

import java.util.List;

@Controller("/room")
public class RoomController {

  private final RoomService roomService;

  public RoomController(RoomService roomService) {
    this.roomService = roomService;
  }

  @Get
  public HttpResponse<GameId> getCurrentGame(@QueryValue String number,
      @QueryValue String password) {
    return roomService.getCurrentGame(number, password)
        .map(HttpResponse::ok)
        .orElse(HttpResponse.notFound());
  }

  @Post
  public RoomDto createRoom(@QueryValue String password) {
    return roomService.createRoom(password);
  }


  @Patch("/{roomId}/player")
  public HttpResponse<Player> addPlayerToRoom(@PathVariable Integer roomId,
      @QueryValue String name) {
    return roomService.addPlayerToGame(roomId, name)
        .map(HttpResponse::ok)
        .orElse(HttpResponse.notFound());
  }

  @Get("/{roomId}/players")
  public HttpResponse<List<Player>> getPlayersInRoom(@PathVariable Integer roomId) {
    return HttpResponse.ok(roomService.getPlayersInRoom(roomId));
  }

  @Patch("/{roomId}/master")
  public Player addMasterPlayerToRoom(@PathVariable Integer roomId,
      @QueryValue String name) {
    return roomService.addMasterPlayerToGame(roomId, name);
  }

}
