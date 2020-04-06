package com.dovaleac.guessing.game.service;

import com.dovaleac.guessing.game.dao.GameConfigurationDao;
import com.dovaleac.guessing.game.dao.GameDao;
import com.dovaleac.guessing.game.dao.QuestionDao;
import com.dovaleac.guessing.game.dao.ScoreboardDao;
import com.dovaleac.guessing.game.dao.ScoringDao;
import com.dovaleac.guessing.game.jooq.generated.games.tables.records.GameRecord;
import com.dovaleac.guessing.game.model.dto.GameDefinitionDto;
import com.dovaleac.guessing.game.model.dto.GameDynamicInfo;
import com.dovaleac.guessing.game.model.dto.GameId;
import com.dovaleac.guessing.game.model.dto.QuestionDto;
import com.dovaleac.guessing.game.model.dto.QuestionInGame;
import com.dovaleac.guessing.game.model.enums.GameStatus;
import com.dovaleac.guessing.game.model.request.GameConfiguration;
import com.dovaleac.guessing.game.model.request.Question;

import javax.inject.Singleton;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class GameServiceImpl implements GameService {

  private final GameDao gameDao;
  private final GameConfigurationDao gameConfigurationDao;
  private final ScoringDao scoringDao;
  private final QuestionDao questionDao;
  private final ScoreboardDao scoreboardDao;

  public GameServiceImpl(
      GameDao gameDao,
      GameConfigurationDao gameConfigurationDao,
      ScoringDao scoringDao,
      QuestionDao questionDao,
      ScoreboardDao scoreboardDao) {
    this.gameDao = gameDao;
    this.gameConfigurationDao = gameConfigurationDao;
    this.scoringDao = scoringDao;
    this.questionDao = questionDao;
    this.scoreboardDao = scoreboardDao;
  }

  @Override
  public GameId createGame(
      int roomId,
      int masterId,
      GameConfiguration gameConfiguration,
      Integer questionSetId,
      int langId) {

    if (questionSetId == null) {
      questionSetId = questionDao.createQuestionSet(langId).getId();
    }

    Integer scoringId = scoringDao.createScoring(gameConfiguration.getScoring()).getId();
    Integer gameConfigurationId =
        gameConfigurationDao.createGameConfiguration(gameConfiguration, scoringId).getId();
    return new GameId(
        gameDao.createGame(gameConfigurationId, roomId, masterId, questionSetId, langId).getId());
  }

  @Override
  public void addQuestionToGame(int gameId, Question question) {
    GameRecord gameRecord = gameDao.getGameFromId(gameId);
    questionDao.createQuestion(question, gameRecord.getQuestionSetId());
  }

  @Override
  public boolean startGame(int gameId, int roomId) {
    boolean startingWentRight = gameDao.startGame(gameId);
    if (startingWentRight) {
      Integer questionSetId = gameDao.getGameFromId(gameId).getQuestionSetId();
      questionDao.consolidateQuestionsForGame(gameId, questionSetId);
      scoreboardDao.insertAllAvailablePlayersFromRoom(gameId, roomId);
    }
    return startingWentRight;
  }

  @Override
  public boolean finishGame(int gameId) {
    return gameDao.finishGame(gameId);
  }

  @Override
  public GameDefinitionDto getGameStaticInfo(int gameId) {
    List<QuestionDto> questions =
        gameDao
            .getQuestionDefinitionsInGame(gameId)
            .map(
                questionRecord ->
                    new QuestionDto(
                        questionRecord.getId(),
                        questionRecord.getClues(),
                        questionRecord.getAnswer(),
                        questionRecord.getDifficulty(),
                        questionRecord.getFunFacts()))
            .collect(Collectors.toList());
    GameConfiguration gameConfiguration = gameConfigurationDao.getGameConfiguration(gameId);
    return new GameDefinitionDto(questions, gameConfiguration);
  }

  @Override
  public GameDynamicInfo getGameDynamicInfo(int gameId) {
    GameStatus gameStatus = GameStatus.valueOf(gameDao.getGameFromId(gameId).getStatus());
    List<QuestionInGame> questionsInGame =
        questionDao.getQuestionsInGameForGameId(gameId).map(QuestionInGame::fromRecord)
        .collect(Collectors.toList());
    return new GameDynamicInfo(gameStatus, questionsInGame);
  }
}
