package com.dovaleac.guessing.game.dao;

import com.dovaleac.guessing.game.jooq.generated.tables.records.PlayerInScoreboardRecord;
import com.dovaleac.guessing.game.model.scoreboard.Scoreboard;

import java.util.stream.Stream;

public interface ScoreboardDao {

  Stream<PlayerInScoreboardRecord> getScoreboard(int gameId);
  void updateScoreboard(int gameId, Scoreboard scoreboard);
}
