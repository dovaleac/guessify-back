package com.dovaleac.guessing.game.model.dto;

import com.dovaleac.guessing.game.jooq.generated.games.tables.records.PlayerRecord;

public class Player {
  private int id;
  private String name;
  private int roomId;
  private Integer gameId;

  public Player() {}

  public Player(int id, String name, int roomId, Integer gameId) {
    this.id = id;
    this.name = name;
    this.roomId = roomId;
    this.gameId = gameId;
  }

  public static Player fromRecord(PlayerRecord record) {
    return new Player(record.getId(), record.getName(), record.getRoomId(), null);
  }

  public static Player fromRecord(PlayerRecord record, int gameId) {
    return new Player(record.getId(), record.getName(), record.getRoomId(), gameId);
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
}
