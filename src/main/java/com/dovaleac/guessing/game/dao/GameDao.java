package com.dovaleac.guessing.game.dao;

import com.dovaleac.guessing.game.jooq.generated.games.tables.records.GameRecord;
import com.dovaleac.guessing.game.jooq.generated.independent.tables.records.QuestionRecord;
import com.dovaleac.guessing.game.model.dto.GameDefinitionDto;

import java.util.Optional;
import java.util.stream.Stream;

public interface GameDao {

  Optional<GameRecord> getCurrentGameForRoom(int roomId);

  GameDefinitionDto getDtoFromRecord(GameRecord gameRecord);

  GameRecord getGameFromId(int id);

  boolean startGame(int gameId);

  boolean finishGame(int gameId);

  GameRecord createGame(
      int gameConfigId, int roomId, int masterPlayerId, int questionSetId, int langId);

  Stream<QuestionRecord> getQuestionDefinitionsInGame(int gameId);
}
