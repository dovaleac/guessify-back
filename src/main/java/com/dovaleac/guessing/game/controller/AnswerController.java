package com.dovaleac.guessing.game.controller;

import com.dovaleac.guessing.game.service.QuestionService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Put;
import io.micronaut.http.annotation.QueryValue;

import javax.annotation.Nullable;

@Controller("/answer")
public class AnswerController {

  private final QuestionService questionService;

  public AnswerController(QuestionService questionService) {
    this.questionService = questionService;
  }

  @Put("/{answerId}/accept")
  public HttpResponse<String> acceptAnswer(@PathVariable int answerId,
      @QueryValue int questionInGameId, @QueryValue int gameId,
      @QueryValue @Nullable Integer nextQuestionInGameId) {
    questionService.markAnswerAsRight(answerId, questionInGameId, gameId, nextQuestionInGameId);
    return HttpResponse.ok();
  }

  @Put("/{answerId}/reject")
  public HttpResponse<String> rejectAnswer(@PathVariable int answerId) {
    questionService.markAnswerAsWrong(answerId);
    return HttpResponse.ok();
  }

}
