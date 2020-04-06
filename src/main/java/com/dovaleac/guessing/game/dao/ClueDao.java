package com.dovaleac.guessing.game.dao;

import com.dovaleac.guessing.game.jooq.generated.games.tables.records.ClueRequestRecord;

import java.time.OffsetDateTime;
import java.util.stream.Stream;

public interface ClueDao {

  void askForClue(int questionInGameId, int playerId, int currentClue, OffsetDateTime time);
  void giveClue(int questionInGameId, int nextClue);
  Stream<ClueRequestRecord> getAllClueRequestsForQuestionInGame(int questionInGameId);

}
