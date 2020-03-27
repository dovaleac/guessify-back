package com.dovaleac.guessing.game.dao;

import com.dovaleac.guessing.game.jooq.generated.tables.records.AnswerRecord;
import com.dovaleac.guessing.game.model.enums.AnswerStatus;

import java.time.OffsetDateTime;
import java.util.stream.Stream;

public interface AnswerDao {

  void createAnswer(
      int questionInGameId, int playerId, int round, String answer, OffsetDateTime moment);

  void resolveAnswer(int answerId, AnswerStatus status);

  Stream<AnswerRecord> getAllAnswersInGame(int gameId);

}
