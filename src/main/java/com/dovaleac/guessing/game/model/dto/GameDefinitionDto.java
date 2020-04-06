package com.dovaleac.guessing.game.model.dto;

import com.dovaleac.guessing.game.model.request.GameConfiguration;

import java.util.List;

public class GameDefinitionDto {
  private List<QuestionDto> questions;
  private GameConfiguration gameConfiguration;

  public GameDefinitionDto() {
  }

  public GameDefinitionDto(
      List<QuestionDto> questions,
      GameConfiguration gameConfiguration) {
    this.questions = questions;
    this.gameConfiguration = gameConfiguration;
  }

  public List<QuestionDto> getQuestions() {
    return questions;
  }

  public void setQuestions(List<QuestionDto> questions) {
    this.questions = questions;
  }

  public GameConfiguration getGameConfiguration() {
    return gameConfiguration;
  }

  public void setGameConfiguration(
      GameConfiguration gameConfiguration) {
    this.gameConfiguration = gameConfiguration;
  }
}
