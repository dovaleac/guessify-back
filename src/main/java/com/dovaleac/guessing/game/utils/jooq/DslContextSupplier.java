package com.dovaleac.guessing.game.utils.jooq;

import org.jooq.DSLContext;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public interface DslContextSupplier {
  <T> T executeFunction(Function<DSLContext, T> function);
  void executeConsumer(Consumer<DSLContext> consumer);
  <T, IT> T executeFunctionWithStream(Function<DSLContext, Stream<IT>> producer, Function<Stream<IT>, T> consumer);
  <IT> void executeConsumerWithStream(Function<DSLContext, Stream<IT>> producer, Consumer<Stream<IT>> consumer);
}