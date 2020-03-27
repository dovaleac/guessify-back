package com.dovaleac.guessing.game.adapter;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ScoringAdapter {

  public static final String COUPLES_SEPARATOR = ";";
  public static final String START_COUPLE = "(";
  public static final String JOIN_COUPLE = ",";
  public static final String END_COUPLE = ")";

  public static Map<Integer, Integer> deserialize(String fromDb) {
    return Stream.of(fromDb.split(COUPLES_SEPARATOR))
        .collect(
            Collectors.toMap(
                pair ->
                    Integer.valueOf(
                        pair.substring(pair.indexOf(START_COUPLE) + 1, pair.indexOf(JOIN_COUPLE))),
                pair ->
                    Integer.valueOf(
                        pair.substring(pair.indexOf(JOIN_COUPLE) + 1, pair.indexOf(END_COUPLE)))));
  }

  public static String serialize(Map<Integer, Integer> toDb) {
    return toDb.entrySet()
        .stream()
        .map(entry -> START_COUPLE + entry.getKey() + JOIN_COUPLE + entry.getValue() + END_COUPLE)
        .collect(Collectors.joining(COUPLES_SEPARATOR));
  }
}
