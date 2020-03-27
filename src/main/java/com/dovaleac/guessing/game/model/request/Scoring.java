package com.dovaleac.guessing.game.model.request;

public class Scoring {

  private String scorings;
  private int malusIfMissed;

  public Scoring() {}

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
