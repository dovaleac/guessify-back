package com.dovaleac.guessing.game.dao;

import com.dovaleac.guessing.game.jooq.generated.tables.records.ScoringRecord;
import com.dovaleac.guessing.game.model.request.Scoring;

public interface ScoringDao {

  ScoringRecord createScoring(Scoring scoring);
  ScoringRecord getScoringForGame(int gameId);
}
