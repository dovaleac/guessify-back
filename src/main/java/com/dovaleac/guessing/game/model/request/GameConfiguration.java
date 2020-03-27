package com.dovaleac.guessing.game.model.request;

public class GameConfiguration {

  private int totalRounds;
  private int cluesPerQuestion;
  private int errorsAllowedPerQuestion;
  private Scoring scoring;

  public GameConfiguration() {
  }

  public int getTotalRounds() {
    return totalRounds;
  }

  public void setTotalRounds(int totalRounds) {
    this.totalRounds = totalRounds;
  }

  public int getCluesPerQuestion() {
    return cluesPerQuestion;
  }

  public void setCluesPerQuestion(int cluesPerQuestion) {
    this.cluesPerQuestion = cluesPerQuestion;
  }

  public int getErrorsAllowedPerQuestion() {
    return errorsAllowedPerQuestion;
  }

  public void setErrorsAllowedPerQuestion(int errorsAllowedPerQuestion) {
    this.errorsAllowedPerQuestion = errorsAllowedPerQuestion;
  }

  public Scoring getScoring() {
    return scoring;
  }

  public void setScoring(Scoring scoring) {
    this.scoring = scoring;
  }
}
