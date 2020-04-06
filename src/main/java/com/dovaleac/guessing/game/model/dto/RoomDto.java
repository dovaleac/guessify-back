package com.dovaleac.guessing.game.model.dto;

public class RoomDto {
  private int roomId;
  private String number;

  public RoomDto(int roomId, String number) {
    this.roomId = roomId;
    this.number = number;
  }

  public int getRoomId() {
    return roomId;
  }

  public void setRoomId(int roomId) {
    this.roomId = roomId;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }
}
