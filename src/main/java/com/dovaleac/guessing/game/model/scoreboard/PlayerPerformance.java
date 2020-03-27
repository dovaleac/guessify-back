package com.dovaleac.guessing.game.model.scoreboard;

public class PlayerPerformance {
  private int playerId;
  private int points = 0;
  private int questionsGuessed = 0;

  public PlayerPerformance() {
  }

  public PlayerPerformance(int playerId) {
    this.playerId = playerId;
  }

  public PlayerPerformance(int playerId, int points, int questionsGuessed) {
    this.playerId = playerId;
    this.points = points;
    this.questionsGuessed = questionsGuessed;
  }

  public int getPlayerId() {
    return playerId;
  }

  public void setPlayerId(int playerId) {
    this.playerId = playerId;
  }

  public int getPoints() {
    return points;
  }

  public void setPoints(int points) {
    this.points = points;
  }

  public int getQuestionsGuessed() {
    return questionsGuessed;
  }

  public void setQuestionsGuessed(int questionsGuessed) {
    this.questionsGuessed = questionsGuessed;
  }
}
