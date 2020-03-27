package com.dovaleac.guessing.game.model.dto;

public class PlayerPerformance {
  private Player player;
  private int points;
  private int questionsGuessed;

  public PlayerPerformance() {
  }

  public PlayerPerformance(Player player, int points, int questionsGuessed) {
    this.player = player;
    this.points = points;
    this.questionsGuessed = questionsGuessed;
  }

  public Player getPlayer() {
    return player;
  }

  public void setPlayer(Player player) {
    this.player = player;
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
