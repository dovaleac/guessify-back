package com.dovaleac.guessing.game.controller;

import com.dovaleac.guessing.game.service.QuestionService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Put;
import io.micronaut.http.annotation.QueryValue;

@Controller("/question")
public class QuestionController {

  private final QuestionService questionService;

  public QuestionController(QuestionService questionService) {
    this.questionService = questionService;
  }

  @Put("/{questionInGameId}/clue")
  public HttpResponse<String> askForClue(@PathVariable int questionInGameId,
      @QueryValue int playerId, @QueryValue int round) {
    questionService.askForClue(questionInGameId, playerId, round);
    return HttpResponse.ok();
  }

  @Put("/{questionInGameId}/answer")
  public HttpResponse<String> guess(@PathVariable int questionInGameId,
      @QueryValue int playerId, @QueryValue int round, @QueryValue String answer) {
    questionService.guess(questionInGameId, playerId, round, answer);
    return HttpResponse.ok();
  }

}
