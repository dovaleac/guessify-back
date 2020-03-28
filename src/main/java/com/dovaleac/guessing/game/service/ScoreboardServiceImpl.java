package com.dovaleac.guessing.game.service;

import com.dovaleac.guessing.game.adapter.ScoringAdapter;
import com.dovaleac.guessing.game.dao.AnswerDao;
import com.dovaleac.guessing.game.dao.ScoreboardDao;
import com.dovaleac.guessing.game.dao.ScoringDao;
import com.dovaleac.guessing.game.jooq.generated.games.tables.records.AnswerRecord;
import com.dovaleac.guessing.game.model.scoreboard.Scoreboard;
import com.dovaleac.guessing.game.utils.reactive.Flowables;
import io.reactivex.Flowable;

import javax.inject.Singleton;
import java.util.Map;
import java.util.function.Function;

@Singleton
public class ScoreboardServiceImpl implements ScoreboardService {

  private final AnswerDao answerDao;
  private final ScoringDao scoringDao;
  private final ScoreboardDao scoreboardDao;

  public ScoreboardServiceImpl(AnswerDao answerDao, ScoringDao scoringDao,
      ScoreboardDao scoreboardDao) {
    this.answerDao = answerDao;
    this.scoringDao = scoringDao;
    this.scoreboardDao = scoreboardDao;
  }

  @Override
  public Scoreboard recalculatePointsForGame(int gameId) {
    Flowable<AnswerRecord> answers =
        Flowables.flowableFromStream(answerDao.getAllAnswersInGame(gameId));
    Map<Integer, Integer> scorings =
        ScoringAdapter.deserialize(scoringDao.getScoringForGame(gameId).getScorings());

    Function<Integer, Integer> scoringFunction = round -> scorings.getOrDefault(round, 0);

    Scoreboard scoreboard = Scoreboard.calculateFromAnswers(answers, scoringFunction);

    scoreboardDao.updateScoreboard(gameId, scoreboard);

    return scoreboard;
  }
}
