package com.dovaleac.guessing.game.model.dto;

import com.dovaleac.guessing.game.jooq.generated.games.tables.records.ClueRequestRecord;

import java.time.OffsetDateTime;

public class ClueRequest {

  private OffsetDateTime moment;
  private int id;
  private int questionInGameId;
  private int playerId;
  private int currentClue;

  public ClueRequest() {
  }

  public ClueRequest(OffsetDateTime moment, int id, int questionInGameId, int playerId,
      int currentClue) {
    this.moment = moment;
    this.id = id;
    this.questionInGameId = questionInGameId;
    this.playerId = playerId;
    this.currentClue = currentClue;
  }

  public static ClueRequest fromRecord(ClueRequestRecord record) {
    return new ClueRequest(
        record.getMoment(),
        record.getId(),
        record.getQuestionInGameId(),
        record.getPlayerId(),
        record.getCurrentClue()
    );
  }

  public OffsetDateTime getMoment() {
    return moment;
  }

  public void setMoment(OffsetDateTime moment) {
    this.moment = moment;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getQuestionInGameId() {
    return questionInGameId;
  }

  public void setQuestionInGameId(int questionInGameId) {
    this.questionInGameId = questionInGameId;
  }

  public int getPlayerId() {
    return playerId;
  }

  public void setPlayerId(int playerId) {
    this.playerId = playerId;
  }

  public int getCurrentClue() {
    return currentClue;
  }

  public void setCurrentClue(int currentClue) {
    this.currentClue = currentClue;
  }
}
