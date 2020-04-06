package com.dovaleac.guessing.game.model.request;

public class Question {

  private String[] clues;
  private String answer;
  private int difficulty;
  private String funFacts;

  public Question() {
  }

  public Question(String[] clues, String answer, int difficulty, String funFacts) {
    this.clues = clues;
    this.answer = answer;
    this.difficulty = difficulty;
    this.funFacts = funFacts;
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

  public int getDifficulty() {
    return difficulty;
  }

  public void setDifficulty(int difficulty) {
    this.difficulty = difficulty;
  }

  public String getFunFacts() {
    return funFacts;
  }

  public void setFunFacts(String funFacts) {
    this.funFacts = funFacts;
  }
}
