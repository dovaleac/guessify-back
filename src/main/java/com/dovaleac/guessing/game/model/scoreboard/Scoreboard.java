package com.dovaleac.guessing.game.model.scoreboard;

import com.dovaleac.guessing.game.jooq.generated.games.tables.records.AnswerRecord;
import com.dovaleac.guessing.game.model.enums.AnswerStatus;
import io.reactivex.Flowable;

import java.util.function.Function;

public class Scoreboard {
  private final Flowable<PlayerPerformance> performances;

  public Scoreboard(Flowable<PlayerPerformance> performances) {
    this.performances = performances;
  }

  public static Scoreboard calculateFromAnswers(
      Flowable<AnswerRecord> answers, Function<Integer, Integer> pointsFunction) {
    return new Scoreboard(
        answers
            .groupBy(AnswerRecord::getPlayerId)
            .flatMapSingle(
                onePlayersAllAnswers ->
                    onePlayersAllAnswers
                        .filter(
                            answer ->
                                AnswerStatus.valueOf(answer.getStatus()) == AnswerStatus.RIGHT)
                        .reduce(
                            new PlayerPerformance(onePlayersAllAnswers.getKey()),
                            (playerPerformance, answerRecord) -> {
                              playerPerformance.setQuestionsGuessed(
                                  playerPerformance.getQuestionsGuessed() + 1);
                              playerPerformance.setPoints(
                                  playerPerformance.getPoints()
                                      + pointsFunction.apply(answerRecord.getCurrentClue()));
                              return playerPerformance;
                            })));
  }

  public Flowable<PlayerPerformance> getPerformances() {
    return performances;
  }
}
