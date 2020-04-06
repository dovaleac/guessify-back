package com.dovaleac.guessing.game.service;

import com.dovaleac.guessing.game.model.request.Question;

import javax.inject.Singleton;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Singleton
public class CsvServiceImpl implements CsvService {

  @Override
  public Stream<Question> readQuestionsFromFile(String content, int cluesPerQuestion) {
    char delimiter = content.charAt(7); // because "Answer" has 6 characters
    return content
        .lines()
        .skip(1)
        .map(
            line -> {
              String[] splitLine = line.split(Pattern.quote(Character.toString(delimiter)));
              String answer = splitLine[0];
              String[] clues =
                  IntStream.range(1, cluesPerQuestion + 1)
                      .mapToObj(i -> splitLine[i])
                      .toArray(String[]::new);
              String funFacts = splitLine[cluesPerQuestion + 1];
              int difficulty = Integer.parseInt(splitLine[cluesPerQuestion + 2]);
              return new Question(clues, answer, difficulty, funFacts);
            });
  }
}
