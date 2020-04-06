package com.dovaleac.guessing.game.model.request;

import javax.annotation.Nullable;

public class GameConfiguration {

  private int totalRounds;
  private int cluesPerQuestion;
  private int errorsAllowedPerQuestion;
  @Nullable
  private Scoring scoring;

  public GameConfiguration() {
  }

  public GameConfiguration(int totalRounds, int cluesPerQuestion, int errorsAllowedPerQuestion,
      @Nullable Scoring scoring) {
    this.totalRounds = totalRounds;
    this.cluesPerQuestion = cluesPerQuestion;
    this.errorsAllowedPerQuestion = errorsAllowedPerQuestion;
    this.scoring = scoring;
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
    if (scoring == null) {
      return Scoring.fromCluesPerQuestion(cluesPerQuestion);
    }
    return scoring;
  }

  public void setScoring(Scoring scoring) {
    this.scoring = scoring;
  }
}
