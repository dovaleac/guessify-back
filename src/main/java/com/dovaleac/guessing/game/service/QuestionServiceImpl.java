package com.dovaleac.guessing.game.service;

import com.dovaleac.guessing.game.dao.AnswerDao;
import com.dovaleac.guessing.game.dao.ClueDao;
import com.dovaleac.guessing.game.dao.QuestionDao;
import com.dovaleac.guessing.game.model.enums.AnswerStatus;
import com.dovaleac.guessing.game.model.dto.QuestionDto;

import javax.inject.Singleton;
import java.time.OffsetDateTime;

import static com.dovaleac.guessing.game.model.enums.QuestionInGameStatus.*;

@Singleton
public class QuestionServiceImpl implements QuestionService {

  private final AnswerDao answerDao;
  private final ClueDao clueDao;
  private final QuestionDao questionDao;
  private final GameService gameService;
  private final ScoreboardService scoreboardService;

  public QuestionServiceImpl(AnswerDao answerDao,
      ClueDao clueDao, QuestionDao questionDao,
      GameService gameService,
      ScoreboardService scoreboardService) {
    this.answerDao = answerDao;
    this.clueDao = clueDao;
    this.questionDao = questionDao;
    this.gameService = gameService;
    this.scoreboardService = scoreboardService;
  }

  @Override
  public void askForClue(int questionInGameId, int playerId, int currentClue) {
    clueDao.askForClue(questionInGameId, playerId, currentClue, OffsetDateTime.now());
  }

  @Override
  public void giveClue(int questionInGameId, int nextClue) {
    clueDao.giveClue(questionInGameId, nextClue);
  }

  @Override
  public void guess(int questionInGameId, int playerId, int currentClue, String answer) {
    OffsetDateTime time = OffsetDateTime.now();
    answerDao.createAnswer(questionInGameId, playerId, currentClue, answer, time);
  }

  @Override
  public QuestionDto getQuestionStatus(int questionInGameId) {
    return null;
  }

  @Override
  public void markAnswerAsRight(int answerId, int questionInGameId, int gameId,
      Integer nextQuestionInGameId) {
    answerDao.resolveAnswer(answerId, AnswerStatus.RIGHT);
    scoreboardService.recalculatePointsForGame(gameId);
    solveQuestion(questionInGameId);
    if (nextQuestionInGameId == null) {
      gameService.finishGame(gameId);
    } else {
      startQuestion(nextQuestionInGameId);
    }
  }

  @Override
  public void revealQuestion(int questionInGameId, int gameId, Integer nextQuestionInGameId) {
    revealQuestion(questionInGameId);
    if (nextQuestionInGameId == null) {
      gameService.finishGame(gameId);
    } else {
      startQuestion(nextQuestionInGameId);
    }
  }

  @Override
  public void markAnswerAsWrong(int answerId) {
    answerDao.resolveAnswer(answerId, AnswerStatus.WRONG);
  }

  @Override
  public void startQuestion(int questionInGameId) {
    questionDao.moveQuestionFromOldStatusToNewStatus(questionInGameId, READY, ACTIVE);
  }

  @Override
  public void solveQuestion(int questionInGameId) {
    questionDao.moveQuestionFromOldStatusToNewStatus(questionInGameId, ACTIVE, SOLVED);
  }

  @Override
  public void revealQuestion(int questionInGameId) {
    questionDao.moveQuestionFromOldStatusToNewStatus(questionInGameId, ACTIVE, REVEALED);
  }
}
