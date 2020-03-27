package com.dovaleac.guessing.game.service;

import com.dovaleac.guessing.game.model.scoreboard.Scoreboard;

public interface ScoreboardService {
  Scoreboard recalculatePointsForGame(int gameId);
}
