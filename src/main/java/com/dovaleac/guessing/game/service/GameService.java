package com.dovaleac.guessing.game.service;

import com.dovaleac.guessing.game.model.dto.GameDefinitionDto;
import com.dovaleac.guessing.game.model.dto.GameDynamicInfo;
import com.dovaleac.guessing.game.model.dto.GameId;
import com.dovaleac.guessing.game.model.enums.GameStatus;
import com.dovaleac.guessing.game.model.request.GameConfiguration;
import com.dovaleac.guessing.game.model.request.Question;

public interface GameService {
  GameId createGame(int roomId, int masterId, GameConfiguration gameConfiguration,
      Integer questionSetId, int langId);

  void addQuestionToGame(int gameId, Question question);

  boolean startGame(int gameId, int roomId);
  boolean finishGame(int gameId);

  GameDefinitionDto getGameStaticInfo(int gameId);
  GameDynamicInfo getGameDynamicInfo(int gameId);
}
