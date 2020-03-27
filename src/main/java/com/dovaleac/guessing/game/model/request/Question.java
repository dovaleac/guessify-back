package com.dovaleac.guessing.game.model.request;

public class Question {

  private String[] clues;
  private String answer;

  public Question() {
  }

  public String[] getClues() {
    return clues;
  }

  public void setClues(String[] clues) {
    this.clues = clues;
  }

  public String getAnswer() {
    return answer;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }
}
