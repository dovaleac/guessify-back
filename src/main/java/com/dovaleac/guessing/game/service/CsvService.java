package com.dovaleac.guessing.game.service;

import com.dovaleac.guessing.game.model.request.Question;

import java.util.stream.Stream;

public interface CsvService {
  Stream<Question> readQuestionsFromFile(String content, int cluesPerQuestion);
}
