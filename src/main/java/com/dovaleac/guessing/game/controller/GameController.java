package com.dovaleac.guessing.game.controller;

import com.dovaleac.guessing.game.model.dto.GameId;
import com.dovaleac.guessing.game.model.request.GameConfiguration;
import com.dovaleac.guessing.game.model.request.Question;
import com.dovaleac.guessing.game.service.GameService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Patch;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import io.micronaut.http.annotation.QueryValue;
import io.reactivex.Flowable;
import io.reactivex.Single;

import javax.annotation.Nullable;

@Controller("/game")
public class GameController {

  private final GameService gameService;

  public GameController(GameService gameService) {
    this.gameService = gameService;
  }

  @Post
  public Single<GameId> createGame(@QueryValue Integer roomId, @QueryValue int masterId,
      @QueryValue @Nullable Integer questionSetId,
      @Body Single<GameConfiguration> gameConfigurationSingle) {
    return gameConfigurationSingle.map(gameConfiguration ->
        gameService.createGame(roomId, masterId, gameConfiguration, questionSetId));
  }

  @Patch("/{gameId}/questions")
  public Single<HttpResponse<String>> addQuestionsToGame(@PathVariable Integer gameId,
      @Body Flowable<Question> questions) {
    return questions.reduce(HttpResponse.ok(), (mutableHttpResponse, question) -> {
      gameService.addQuestionToGame(gameId, question);
      return mutableHttpResponse;
    });
  }

  @Patch("/{gameId}/question")
  public Single<HttpResponse<String>> addQuestionToGame(@PathVariable Integer gameId,
      @Body Single<Question> questionSingle) {
    return questionSingle.map(question -> {
      gameService.addQuestionToGame(gameId, question);
      return HttpResponse.ok();
    });
  }

  @Put("/{gameId}/start")
  public HttpResponse startGame(@PathVariable Integer gameId) {
    return gameService.startGame(gameId)
        ? HttpResponse.ok()
        : HttpResponse.notFound("Game doesn't exist or can't be started");
  }

}
