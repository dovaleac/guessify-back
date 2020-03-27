package com.dovaleac.guessing.game.utils.jooq;

import io.micronaut.context.annotation.Value;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.jooq.impl.DefaultConfiguration;

import javax.inject.Singleton;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

@Singleton
public class DslContextSupplierImpl implements DslContextSupplier {
  @Value("${jdbc.host}")
  private String host;
  @Value("${jdbc.port}")
  private String port;
  @Value("${jdbc.user}")
  private String user;
  @Value("${jdbc.password}")
  private String password;

  @Override
  public <T> T executeFunction(Function<DSLContext, T> function) {
    try(DSLContext dslContext = getDslContext())
    {
      return function.apply(dslContext);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

  }

  @Override
  public void executeConsumer(Consumer<DSLContext> consumer) {
    try(DSLContext dslContext = getDslContext())
    {
      consumer.accept(dslContext);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

  }

  @Override
  public <T, IT> T executeFunctionWithStream(Function<DSLContext, Stream<IT>> producer,
      Function<Stream<IT>, T> consumer) {
    try(DSLContext dslContext = getDslContext())
    {
      return consumer.apply(producer.apply(dslContext));
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public <IT> void executeConsumerWithStream(Function<DSLContext, Stream<IT>> producer,
      Consumer<Stream<IT>> consumer) {
    try(DSLContext dslContext = getDslContext())
    {
      consumer.accept(producer.apply(dslContext));
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  private DSLContext getDslContext() throws SQLException {
    return DSL.using(new DefaultConfiguration()
        .set(DriverManager.getConnection(
            "jdbc:postgresql://" + host + ":" + port + "/guessing_game",
            user,
            password))
        .set(SQLDialect.POSTGRES));
  }
}
