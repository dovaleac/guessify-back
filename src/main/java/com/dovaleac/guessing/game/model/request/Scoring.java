package com.dovaleac.guessing.game.model.request;

import com.dovaleac.guessing.game.adapter.ScoringAdapter;

public class Scoring {

  private String scorings;
  private int malusIfMissed;

  public Scoring() {}

  private Scoring(String scorings, int malusIfMissed) {
    this.scorings = scorings;
    this.malusIfMissed = malusIfMissed;
  }

  public static Scoring fromCluesPerQuestion(int cluesPerQuestion) {
    return new Scoring(
        ScoringAdapter.serialize(ScoringAdapter.fromCluesPerQuestion(cluesPerQuestion)),
        0
    );
  }

  public String getScorings() {
    return scorings;
  }

  public void setScorings(String scorings) {
    this.scorings = scorings;
  }

  public int getMalusIfMissed() {
    return malusIfMissed;
  }

  public void setMalusIfMissed(int malusIfMissed) {
    this.malusIfMissed = malusIfMissed;
  }
}
