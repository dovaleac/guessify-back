package com.dovaleac.guessing.game.utils.reactive;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;

import java.util.stream.Stream;

public class Flowables {

  public static <T> Flowable<T> flowableFromStream(Stream<T> stream) {
    return Flowable.create(flowableEmitter -> {
      try {
        stream.forEach(flowableEmitter::onNext);
        flowableEmitter.onComplete();
      } catch (Exception ex) {
        flowableEmitter.onError(ex);
      }
    }, BackpressureStrategy.BUFFER);
  }
}
