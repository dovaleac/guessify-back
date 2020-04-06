package com.dovaleac.guessing.game.model.dto;

import com.dovaleac.guessing.game.jooq.generated.games.tables.records.PlayerRecord;
import com.dovaleac.guessing.game.model.enums.PlayerRole;
import com.dovaleac.guessing.game.model.enums.PlayerStatus;

public class Player {
  private int id;
  private String name;
  private PlayerRole playerRole;
  private PlayerStatus playerStatus;
  private int roomId;
  private Integer gameId;

  public Player() {}

  public Player(
      int id,
      String name,
      PlayerRole playerRole,
      PlayerStatus playerStatus,
      int roomId,
      Integer gameId) {
    this.id = id;
    this.name = name;
    this.playerRole = playerRole;
    this.playerStatus = playerStatus;
    this.roomId = roomId;
    this.gameId = gameId;
  }

  public static Player fromRecord(PlayerRecord record) {
    return new Player(
        record.getId(),
        record.getName(),
        PlayerRole.valueOf(record.getRole()),
        PlayerStatus.valueOf(record.getStatus()),
        record.getRoomId(),
        null);
  }

  public static Player fromRecord(PlayerRecord record, int gameId) {
    return new Player(
        record.getId(),
        record.getName(),
        PlayerRole.valueOf(record.getRole()),
        PlayerStatus.valueOf(record.getStatus()),
        record.getRoomId(),
        gameId);
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getRoomId() {
    return roomId;
  }

  public void setRoomId(int roomId) {
    this.roomId = roomId;
  }

  public Integer getGameId() {
    return gameId;
  }

  public void setGameId(Integer gameId) {
    this.gameId = gameId;
  }

  public PlayerRole getPlayerRole() {
    return playerRole;
  }

  public void setPlayerRole(PlayerRole playerRole) {
    this.playerRole = playerRole;
  }

  public PlayerStatus getPlayerStatus() {
    return playerStatus;
  }

  public void setPlayerStatus(PlayerStatus playerStatus) {
    this.playerStatus = playerStatus;
  }
}
