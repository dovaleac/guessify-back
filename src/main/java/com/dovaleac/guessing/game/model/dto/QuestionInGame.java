package com.dovaleac.guessing.game.model.dto;

import com.dovaleac.guessing.game.jooq.generated.games.tables.records.QuestionInGameRecord;
import com.dovaleac.guessing.game.model.enums.QuestionInGameStatus;

public class QuestionInGame {

  private int id;
  private int questionId;
  private int currentClue;
  private int executionOrder;
  private QuestionInGameStatus status;

  public QuestionInGame(
      int id, int questionId, int currentClue, int executionOrder, QuestionInGameStatus status) {
    this.id = id;
    this.questionId = questionId;
    this.currentClue = currentClue;
    this.executionOrder = executionOrder;
    this.status = status;
  }

  public QuestionInGame() {}

  public static QuestionInGame fromRecord(QuestionInGameRecord record) {
    return new QuestionInGame(
        record.getId(),
        record.getQuestionId(),
        record.getCurrentClue(),
        record.getExecutionOrder(),
        QuestionInGameStatus.valueOf(record.getStatus()));
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getQuestionId() {
    return questionId;
  }

  public void setQuestionId(int questionId) {
    this.questionId = questionId;
  }

  public int getCurrentClue() {
    return currentClue;
  }

  public void setCurrentClue(int currentClue) {
    this.currentClue = currentClue;
  }

  public int getExecutionOrder() {
    return executionOrder;
  }

  public void setExecutionOrder(int executionOrder) {
    this.executionOrder = executionOrder;
  }

  public QuestionInGameStatus getStatus() {
    return status;
  }

  public void setStatus(QuestionInGameStatus status) {
    this.status = status;
  }
}
