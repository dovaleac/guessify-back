package com.dovaleac.guessing.game.service;

import com.dovaleac.guessing.game.model.dto.QuestionDto;

public interface QuestionService {

  void askForClue(int questionInGameId, int playerId, int currentClue);
  void giveClue(int questionInGameId, int nextClue);
  void guess(int questionInGameId, int playerId, int currentClue, String answer);
  QuestionDto getQuestionStatus(int questionInGameId);
  void markAnswerAsRight(int answerId, int questionInGameId, int gameId,
      Integer nextQuestionInGameId);
  void revealQuestion(int questionInGameId, int gameId,
      Integer nextQuestionInGameId);
  void markAnswerAsWrong(int answerId);

  void startQuestion(int questionInGameId);
  void solveQuestion(int questionInGameId);

  void revealQuestion(int questionInGameId);
}
