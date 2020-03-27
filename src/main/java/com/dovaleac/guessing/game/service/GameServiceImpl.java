package com.dovaleac.guessing.game.service;

import com.dovaleac.guessing.game.dao.GameConfigurationDao;
import com.dovaleac.guessing.game.dao.GameDao;
import com.dovaleac.guessing.game.dao.QuestionDao;
import com.dovaleac.guessing.game.dao.ScoringDao;
import com.dovaleac.guessing.game.jooq.generated.tables.records.GameRecord;
import com.dovaleac.guessing.game.model.dto.GameId;
import com.dovaleac.guessing.game.model.request.GameConfiguration;
import com.dovaleac.guessing.game.model.request.Question;

import javax.inject.Singleton;

@Singleton
public class GameServiceImpl implements GameService {

  private final GameDao gameDao;
  private final GameConfigurationDao gameConfigurationDao;
  private final ScoringDao scoringDao;
  private final QuestionDao questionDao;

  public GameServiceImpl(
      GameDao gameDao,
      GameConfigurationDao gameConfigurationDao,
      ScoringDao scoringDao,
      QuestionDao questionDao) {
    this.gameDao = gameDao;
    this.gameConfigurationDao = gameConfigurationDao;
    this.scoringDao = scoringDao;
    this.questionDao = questionDao;
  }

  @Override
  public GameId createGame(
      int roomId, int masterId, GameConfiguration gameConfiguration, Integer questionSetId) {

    if (questionSetId == null) {
      questionSetId = questionDao.createQuestionSet().getId();
    }

    Integer scoringId = scoringDao.createScoring(gameConfiguration.getScoring()).getId();
    Integer gameConfigurationId =
        gameConfigurationDao.createGameConfiguration(gameConfiguration, scoringId).getId();
    return new GameId(
        gameDao.createGame(gameConfigurationId, roomId, masterId, questionSetId).getId());
  }

  @Override
  public void addQuestionToGame(int gameId, Question question) {
    GameRecord gameRecord = gameDao.getGameFromId(gameId);
    questionDao.createQuestion(question, gameRecord.getQuestionSetId());
  }

  @Override
  public boolean startGame(int gameId) {
    boolean startingWentRight = gameDao.startGame(gameId);
    if (startingWentRight) {
      Integer questionSetId = gameDao.getGameFromId(gameId).getQuestionSetId();
      questionDao.consolidateQuestionsForGame(gameId, questionSetId);
    }
    return startingWentRight;
  }

  @Override
  public boolean finishGame(int gameId) {
    return gameDao.finishGame(gameId);
  }
}
