package com.dovaleac.guessing.game.controller;

import com.dovaleac.guessing.game.service.QuestionService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Put;
import io.micronaut.http.annotation.QueryValue;

import javax.annotation.Nullable;

@Controller("/question")
public class QuestionController {

  private final QuestionService questionService;

  public QuestionController(QuestionService questionService) {
    this.questionService = questionService;
  }

  @Put("/{questionInGameId}/request-clue")
  public HttpResponse<String> askForClue(@PathVariable int questionInGameId,
      @QueryValue int playerId, @QueryValue int currentClue) {
    questionService.askForClue(questionInGameId, playerId, currentClue);
    return HttpResponse.ok();
  }

  @Put("/{questionInGameId}/clue")
  public HttpResponse<String> giveClue(@PathVariable int questionInGameId,
      @QueryValue int nextClue) {
    questionService.giveClue(questionInGameId, nextClue);
    return HttpResponse.ok();
  }

  @Put("/{questionInGameId}/answer")
  public HttpResponse<String> guess(@PathVariable int questionInGameId,
      @QueryValue int playerId, @QueryValue int currentClue, @QueryValue String answer) {
    questionService.guess(questionInGameId, playerId, currentClue, answer);
    return HttpResponse.ok();
  }


  @Put("/{questionInGameId}/reveal")
  public HttpResponse<String> acceptAnswer(
      @PathVariable int questionInGameId, @QueryValue int gameId,
      @QueryValue @Nullable Integer nextQuestionInGameId) {
    questionService.revealQuestion(questionInGameId, gameId, nextQuestionInGameId);
    return HttpResponse.ok();
  }

}
