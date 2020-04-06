package com.dovaleac.guessing.game.controller;

import com.dovaleac.guessing.game.model.dto.GameDefinitionDto;
import com.dovaleac.guessing.game.model.dto.GameDynamicInfo;
import com.dovaleac.guessing.game.model.dto.GameId;
import com.dovaleac.guessing.game.model.request.GameConfiguration;
import com.dovaleac.guessing.game.model.request.Question;
import com.dovaleac.guessing.game.service.CsvService;
import com.dovaleac.guessing.game.service.GameService;
import com.dovaleac.guessing.game.service.LangService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Patch;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import io.micronaut.http.annotation.QueryValue;
import io.reactivex.Flowable;
import io.reactivex.Single;

import javax.annotation.Nullable;
import java.util.List;
import java.util.stream.Collectors;

@Controller("/game")
public class GameController {

  private final CsvService csvService;
  private final GameService gameService;
  private final LangService langService;

  public GameController(CsvService csvService,
      GameService gameService,
      LangService langService) {
    this.csvService = csvService;
    this.gameService = gameService;
    this.langService = langService;
  }

  @Post
  public Single<GameId> createGame(@QueryValue Integer roomId, @QueryValue int masterId,
      @QueryValue @Nullable Integer questionSetId, @QueryValue String lang,
      @Body Single<GameConfiguration> gameConfigurationSingle) {
    return gameConfigurationSingle.map(gameConfiguration ->
    {
      Integer langId = langService.getLangByAbbrev(lang).getId();
      return gameService.createGame(roomId, masterId, gameConfiguration, questionSetId, langId);
    });
  }

  @Patch("/{gameId}/questions")
  public Single<HttpResponse<String>> addQuestionsToGame(@PathVariable Integer gameId,
      @Body Flowable<Question> questions) {
    return questions.reduce(HttpResponse.ok(), (mutableHttpResponse, question) -> {
      gameService.addQuestionToGame(gameId, question);
      return mutableHttpResponse;
    });
  }

  @Get("/{gameId}/dynamic-info")
  public GameDynamicInfo getGameStatus(@PathVariable Integer gameId) {
    return gameService.getGameDynamicInfo(gameId);
  }


  @Put(value = "/{gameId}/questions-file", consumes = MediaType.MULTIPART_FORM_DATA)
  public HttpResponse<List<Question>> loadQuestionsCsv(@PathVariable Integer gameId,
      @QueryValue int cluesPerQuestion, byte[] file) {
    String fileContent = new String(file);
    List<Question> questions = csvService.readQuestionsFromFile(fileContent, cluesPerQuestion)
        .collect(Collectors.toList());
    questions.forEach(question -> gameService.addQuestionToGame(gameId, question));
    return HttpResponse.ok(questions);
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
  public HttpResponse startGame(@PathVariable Integer gameId, @QueryValue int roomId) {
    return gameService.startGame(gameId, roomId)
        ? HttpResponse.ok()
        : HttpResponse.notFound("Game doesn't exist or can't be started");
  }

  @Get("/{gameId}/static-info")
  public HttpResponse<GameDefinitionDto> getStaticInfo(@PathVariable Integer gameId) {
    return HttpResponse.ok(gameService.getGameStaticInfo(gameId));
  }

}
