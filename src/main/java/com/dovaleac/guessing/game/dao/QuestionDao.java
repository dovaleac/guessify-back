package com.dovaleac.guessing.game.dao;

import com.dovaleac.guessing.game.jooq.generated.games.tables.records.QuestionInGameRecord;
import com.dovaleac.guessing.game.jooq.generated.independent.tables.records.QuestionRecord;
import com.dovaleac.guessing.game.jooq.generated.independent.tables.records.QuestionSetRecord;
import com.dovaleac.guessing.game.model.enums.QuestionInGameStatus;
import com.dovaleac.guessing.game.model.request.Question;

import java.util.stream.Stream;

public interface QuestionDao {

  QuestionSetRecord createQuestionSet(int langId);
  QuestionRecord createQuestion(Question question, int questionSetId);
  void consolidateQuestionsForGame(int gameId, int questionSetId);
  void moveQuestionFromOldStatusToNewStatus(int questionInGameId, QuestionInGameStatus oldStatus,
      QuestionInGameStatus newStatus);
  Stream<QuestionInGameRecord> getQuestionsInGameForGameId(int gameId);
}
