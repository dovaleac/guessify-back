package com.dovaleac.guessing.game.dao;

import com.dovaleac.guessing.game.jooq.generated.tables.records.QuestionRecord;
import com.dovaleac.guessing.game.jooq.generated.tables.records.QuestionSetRecord;
import com.dovaleac.guessing.game.jooq.generated.tables.records.ScoringRecord;
import com.dovaleac.guessing.game.model.enums.QuestionInGameStatus;
import com.dovaleac.guessing.game.model.request.Question;
import com.dovaleac.guessing.game.model.request.Scoring;

public interface QuestionDao {

  QuestionSetRecord createQuestionSet();
  QuestionRecord createQuestion(Question question, int questionSetId);
  void consolidateQuestionsForGame(int gameId, int questionSetId);
  void moveQuestionFromOldStatusToNewStatus(int questionInGameId, QuestionInGameStatus oldStatus,
      QuestionInGameStatus newStatus);
}
