package com.dovaleac.guessing.game.dao;

import java.time.OffsetDateTime;

public interface ClueDao {

  void askForClue(int questionInGameId, int playerId, int currentClue, OffsetDateTime time);
  void giveClue(int questionInGameId, int nextClue);

}
