package com.dovaleac.guessing.game.model.dto;

import com.dovaleac.guessing.game.model.enums.GameStatus;

import java.util.List;

public class GameDynamicInfo {

  private GameStatus gameStatus;
  private List<QuestionInGame> questionsInGame;

  public GameDynamicInfo(GameStatus gameStatus,
      List<QuestionInGame> questionsInGame) {
    this.gameStatus = gameStatus;
    this.questionsInGame = questionsInGame;
  }

  public GameDynamicInfo() {
  }

  public GameStatus getGameStatus() {
    return gameStatus;
  }

  public void setGameStatus(GameStatus gameStatus) {
    this.gameStatus = gameStatus;
  }

  public List<QuestionInGame> getQuestionsInGame() {
    return questionsInGame;
  }

  public void setQuestionsInGame(
      List<QuestionInGame> questionsInGame) {
    this.questionsInGame = questionsInGame;
  }
}
