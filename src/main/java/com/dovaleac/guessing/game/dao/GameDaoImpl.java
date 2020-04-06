package com.dovaleac.guessing.game.dao;

import com.dovaleac.guessing.game.jooq.generated.games.tables.Game;
import com.dovaleac.guessing.game.jooq.generated.games.tables.records.GameRecord;
import com.dovaleac.guessing.game.jooq.generated.independent.tables.records.QuestionRecord;
import com.dovaleac.guessing.game.model.dto.GameDefinitionDto;
import com.dovaleac.guessing.game.model.enums.GameStatus;
import com.dovaleac.guessing.game.utils.jooq.DslContextSupplier;

import javax.inject.Singleton;
import java.util.Optional;
import java.util.stream.Stream;

@Singleton
public class GameDaoImpl implements GameDao {

  public static final Game GAME = Game.GAME;
  public static final com.dovaleac.guessing.game.jooq.generated.independent.tables.Question QUESTION =
      com.dovaleac.guessing.game.jooq.generated.independent.tables.Question.QUESTION;
  private final DslContextSupplier dslContextSupplier;

  public GameDaoImpl(DslContextSupplier dslContextSupplier) {
    this.dslContextSupplier = dslContextSupplier;
  }

  @Override
  public Optional<GameRecord> getCurrentGameForRoom(int roomId) {
    return dslContextSupplier.executeFunctionWithStream(
        dslContext ->
            dslContext
                .selectFrom(GAME)
                .where(GAME.ROOM_ID.eq(roomId))
                .and(GAME.STATUS.eq(GameStatus.CREATED.name()))
                .fetchStream(),
        Stream::findAny);
  }

  @Override
  public GameDefinitionDto getDtoFromRecord(GameRecord gameRecord) {
    return null;
  }

  @Override
  public GameRecord getGameFromId(int id) {
    return dslContextSupplier.executeFunction(
        dslContext -> dslContext.selectFrom(GAME).where(GAME.ID.eq(id)).fetchOne());
  }

  @Override
  public boolean startGame(int gameId) {
    return advanceGameStatus(gameId, GameStatus.STARTED, GameStatus.CREATED);
  }

  @Override
  public boolean finishGame(int gameId) {
    return advanceGameStatus(gameId, GameStatus.FINISHED, GameStatus.STARTED);
  }

  private boolean advanceGameStatus(int gameId, GameStatus newStatus, GameStatus currentStatus) {
    Integer updatedRows =
        dslContextSupplier.executeFunction(
            dslContext ->
                dslContext
                    .update(GAME)
                    .set(GAME.STATUS, newStatus.name())
                    .where(GAME.ID.eq(gameId))
                    .and(GAME.STATUS.eq(currentStatus.name()))
                    .execute());

    return updatedRows == 1;
  }

  @Override
  public GameRecord createGame(
      int gameConfigId, int roomId, int masterPlayerId, int questionSetId, int langId) {
    return dslContextSupplier.executeFunction(
        dslContext ->
            dslContext
                .insertInto(GAME)
                .columns(
                    GAME.GAME_CONFIG_ID,
                    GAME.MASTER_PLAYER_ID,
                    GAME.ROOM_ID,
                    GAME.STATUS,
                    GAME.QUESTION_SET_ID,
                    GAME.LANG_ID)
                .values(
                    gameConfigId,
                    masterPlayerId,
                    roomId,
                    GameStatus.CREATED.name(),
                    questionSetId,
                    langId)
                .returning(GAME.ID)
                .fetchOne());
  }

  @Override
  public Stream<QuestionRecord> getQuestionDefinitionsInGame(int gameId) {
    return dslContextSupplier.executeFunction(dslContext -> dslContext
    .select(QUESTION.fields())
        .from(QUESTION)
        .join(GAME)
        .on(GAME.QUESTION_SET_ID.eq(QUESTION.QUESTION_SET_ID))
        .where(GAME.ID.eq(gameId))
        .fetchStreamInto(QuestionRecord.class)
        );
  }
}
