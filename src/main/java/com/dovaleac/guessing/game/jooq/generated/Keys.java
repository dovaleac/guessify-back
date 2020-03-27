/*
 * This file is generated by jOOQ.
 */
package com.dovaleac.guessing.game.jooq.generated;


import com.dovaleac.guessing.game.jooq.generated.tables.Answer;
import com.dovaleac.guessing.game.jooq.generated.tables.ClueRequest;
import com.dovaleac.guessing.game.jooq.generated.tables.Game;
import com.dovaleac.guessing.game.jooq.generated.tables.GameConfig;
import com.dovaleac.guessing.game.jooq.generated.tables.Player;
import com.dovaleac.guessing.game.jooq.generated.tables.PlayerInScoreboard;
import com.dovaleac.guessing.game.jooq.generated.tables.Question;
import com.dovaleac.guessing.game.jooq.generated.tables.QuestionInGame;
import com.dovaleac.guessing.game.jooq.generated.tables.QuestionSet;
import com.dovaleac.guessing.game.jooq.generated.tables.Room;
import com.dovaleac.guessing.game.jooq.generated.tables.Scoring;
import com.dovaleac.guessing.game.jooq.generated.tables.records.AnswerRecord;
import com.dovaleac.guessing.game.jooq.generated.tables.records.ClueRequestRecord;
import com.dovaleac.guessing.game.jooq.generated.tables.records.GameConfigRecord;
import com.dovaleac.guessing.game.jooq.generated.tables.records.GameRecord;
import com.dovaleac.guessing.game.jooq.generated.tables.records.PlayerInScoreboardRecord;
import com.dovaleac.guessing.game.jooq.generated.tables.records.PlayerRecord;
import com.dovaleac.guessing.game.jooq.generated.tables.records.QuestionInGameRecord;
import com.dovaleac.guessing.game.jooq.generated.tables.records.QuestionRecord;
import com.dovaleac.guessing.game.jooq.generated.tables.records.QuestionSetRecord;
import com.dovaleac.guessing.game.jooq.generated.tables.records.RoomRecord;
import com.dovaleac.guessing.game.jooq.generated.tables.records.ScoringRecord;

import javax.annotation.Generated;

import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>games</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<AnswerRecord, Integer> IDENTITY_ANSWER = Identities0.IDENTITY_ANSWER;
    public static final Identity<ClueRequestRecord, Integer> IDENTITY_CLUE_REQUEST = Identities0.IDENTITY_CLUE_REQUEST;
    public static final Identity<GameRecord, Integer> IDENTITY_GAME = Identities0.IDENTITY_GAME;
    public static final Identity<GameConfigRecord, Integer> IDENTITY_GAME_CONFIG = Identities0.IDENTITY_GAME_CONFIG;
    public static final Identity<PlayerRecord, Integer> IDENTITY_PLAYER = Identities0.IDENTITY_PLAYER;
    public static final Identity<PlayerInScoreboardRecord, Integer> IDENTITY_PLAYER_IN_SCOREBOARD = Identities0.IDENTITY_PLAYER_IN_SCOREBOARD;
    public static final Identity<QuestionRecord, Integer> IDENTITY_QUESTION = Identities0.IDENTITY_QUESTION;
    public static final Identity<QuestionInGameRecord, Integer> IDENTITY_QUESTION_IN_GAME = Identities0.IDENTITY_QUESTION_IN_GAME;
    public static final Identity<QuestionSetRecord, Integer> IDENTITY_QUESTION_SET = Identities0.IDENTITY_QUESTION_SET;
    public static final Identity<RoomRecord, Integer> IDENTITY_ROOM = Identities0.IDENTITY_ROOM;
    public static final Identity<ScoringRecord, Integer> IDENTITY_SCORING = Identities0.IDENTITY_SCORING;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<AnswerRecord> ANSWER_PKEY = UniqueKeys0.ANSWER_PKEY;
    public static final UniqueKey<ClueRequestRecord> CLUE_REQUEST_PKEY = UniqueKeys0.CLUE_REQUEST_PKEY;
    public static final UniqueKey<GameRecord> GAME_PKEY = UniqueKeys0.GAME_PKEY;
    public static final UniqueKey<GameConfigRecord> GAME_CONFIG_PKEY = UniqueKeys0.GAME_CONFIG_PKEY;
    public static final UniqueKey<PlayerRecord> PLAYER_PKEY = UniqueKeys0.PLAYER_PKEY;
    public static final UniqueKey<PlayerInScoreboardRecord> PLAYER_IN_SCOREBOARD_PKEY = UniqueKeys0.PLAYER_IN_SCOREBOARD_PKEY;
    public static final UniqueKey<QuestionRecord> QUESTION_PKEY = UniqueKeys0.QUESTION_PKEY;
    public static final UniqueKey<QuestionInGameRecord> QUESTION_IN_GAME_PKEY = UniqueKeys0.QUESTION_IN_GAME_PKEY;
    public static final UniqueKey<QuestionSetRecord> QUESTION_SET_PKEY = UniqueKeys0.QUESTION_SET_PKEY;
    public static final UniqueKey<RoomRecord> ROOM_PKEY = UniqueKeys0.ROOM_PKEY;
    public static final UniqueKey<ScoringRecord> SCORING_PKEY = UniqueKeys0.SCORING_PKEY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<AnswerRecord, QuestionInGameRecord> ANSWER__ANSWER_QUESTION_IN_GAME_ID_FKEY = ForeignKeys0.ANSWER__ANSWER_QUESTION_IN_GAME_ID_FKEY;
    public static final ForeignKey<AnswerRecord, PlayerRecord> ANSWER__ANSWER_PLAYER_ID_FKEY = ForeignKeys0.ANSWER__ANSWER_PLAYER_ID_FKEY;
    public static final ForeignKey<ClueRequestRecord, QuestionInGameRecord> CLUE_REQUEST__CLUE_REQUEST_QUESTION_IN_GAME_ID_FKEY = ForeignKeys0.CLUE_REQUEST__CLUE_REQUEST_QUESTION_IN_GAME_ID_FKEY;
    public static final ForeignKey<ClueRequestRecord, PlayerRecord> CLUE_REQUEST__CLUE_REQUEST_PLAYER_ID_FKEY = ForeignKeys0.CLUE_REQUEST__CLUE_REQUEST_PLAYER_ID_FKEY;
    public static final ForeignKey<GameRecord, RoomRecord> GAME__GAME_ROOM_ID_FKEY = ForeignKeys0.GAME__GAME_ROOM_ID_FKEY;
    public static final ForeignKey<GameRecord, GameConfigRecord> GAME__GAME_GAME_CONFIG_ID_FKEY = ForeignKeys0.GAME__GAME_GAME_CONFIG_ID_FKEY;
    public static final ForeignKey<GameRecord, QuestionSetRecord> GAME__GAME_QUESTION_SET_ID_FKEY = ForeignKeys0.GAME__GAME_QUESTION_SET_ID_FKEY;
    public static final ForeignKey<GameRecord, PlayerRecord> GAME__GAME_MASTER_PLAYER_ID_FKEY = ForeignKeys0.GAME__GAME_MASTER_PLAYER_ID_FKEY;
    public static final ForeignKey<GameConfigRecord, ScoringRecord> GAME_CONFIG__GAME_CONFIG_SCORING_ID_FKEY = ForeignKeys0.GAME_CONFIG__GAME_CONFIG_SCORING_ID_FKEY;
    public static final ForeignKey<PlayerRecord, RoomRecord> PLAYER__PLAYER_ROOM_ID_FKEY = ForeignKeys0.PLAYER__PLAYER_ROOM_ID_FKEY;
    public static final ForeignKey<PlayerInScoreboardRecord, GameRecord> PLAYER_IN_SCOREBOARD__PLAYER_IN_SCOREBOARD_GAME_ID_FKEY = ForeignKeys0.PLAYER_IN_SCOREBOARD__PLAYER_IN_SCOREBOARD_GAME_ID_FKEY;
    public static final ForeignKey<PlayerInScoreboardRecord, PlayerRecord> PLAYER_IN_SCOREBOARD__PLAYER_IN_SCOREBOARD_PLAYER_ID_FKEY = ForeignKeys0.PLAYER_IN_SCOREBOARD__PLAYER_IN_SCOREBOARD_PLAYER_ID_FKEY;
    public static final ForeignKey<QuestionRecord, QuestionSetRecord> QUESTION__QUESTION_QUESTION_SET_ID_FKEY = ForeignKeys0.QUESTION__QUESTION_QUESTION_SET_ID_FKEY;
    public static final ForeignKey<QuestionInGameRecord, QuestionRecord> QUESTION_IN_GAME__QUESTION_IN_GAME_QUESTION_ID_FKEY = ForeignKeys0.QUESTION_IN_GAME__QUESTION_IN_GAME_QUESTION_ID_FKEY;
    public static final ForeignKey<QuestionInGameRecord, GameRecord> QUESTION_IN_GAME__QUESTION_IN_GAME_GAME_ID_FKEY = ForeignKeys0.QUESTION_IN_GAME__QUESTION_IN_GAME_GAME_ID_FKEY;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 {
        public static Identity<AnswerRecord, Integer> IDENTITY_ANSWER = Internal.createIdentity(Answer.ANSWER, Answer.ANSWER.ID);
        public static Identity<ClueRequestRecord, Integer> IDENTITY_CLUE_REQUEST = Internal.createIdentity(ClueRequest.CLUE_REQUEST, ClueRequest.CLUE_REQUEST.ID);
        public static Identity<GameRecord, Integer> IDENTITY_GAME = Internal.createIdentity(Game.GAME, Game.GAME.ID);
        public static Identity<GameConfigRecord, Integer> IDENTITY_GAME_CONFIG = Internal.createIdentity(GameConfig.GAME_CONFIG, GameConfig.GAME_CONFIG.ID);
        public static Identity<PlayerRecord, Integer> IDENTITY_PLAYER = Internal.createIdentity(Player.PLAYER, Player.PLAYER.ID);
        public static Identity<PlayerInScoreboardRecord, Integer> IDENTITY_PLAYER_IN_SCOREBOARD = Internal.createIdentity(PlayerInScoreboard.PLAYER_IN_SCOREBOARD, PlayerInScoreboard.PLAYER_IN_SCOREBOARD.ID);
        public static Identity<QuestionRecord, Integer> IDENTITY_QUESTION = Internal.createIdentity(Question.QUESTION, Question.QUESTION.ID);
        public static Identity<QuestionInGameRecord, Integer> IDENTITY_QUESTION_IN_GAME = Internal.createIdentity(QuestionInGame.QUESTION_IN_GAME, QuestionInGame.QUESTION_IN_GAME.ID);
        public static Identity<QuestionSetRecord, Integer> IDENTITY_QUESTION_SET = Internal.createIdentity(QuestionSet.QUESTION_SET, QuestionSet.QUESTION_SET.ID);
        public static Identity<RoomRecord, Integer> IDENTITY_ROOM = Internal.createIdentity(Room.ROOM, Room.ROOM.ID);
        public static Identity<ScoringRecord, Integer> IDENTITY_SCORING = Internal.createIdentity(Scoring.SCORING, Scoring.SCORING.ID);
    }

    private static class UniqueKeys0 {
        public static final UniqueKey<AnswerRecord> ANSWER_PKEY = Internal.createUniqueKey(Answer.ANSWER, "answer_pkey", Answer.ANSWER.ID);
        public static final UniqueKey<ClueRequestRecord> CLUE_REQUEST_PKEY = Internal.createUniqueKey(ClueRequest.CLUE_REQUEST, "clue_request_pkey", ClueRequest.CLUE_REQUEST.ID);
        public static final UniqueKey<GameRecord> GAME_PKEY = Internal.createUniqueKey(Game.GAME, "game_pkey", Game.GAME.ID);
        public static final UniqueKey<GameConfigRecord> GAME_CONFIG_PKEY = Internal.createUniqueKey(GameConfig.GAME_CONFIG, "game_config_pkey", GameConfig.GAME_CONFIG.ID);
        public static final UniqueKey<PlayerRecord> PLAYER_PKEY = Internal.createUniqueKey(Player.PLAYER, "player_pkey", Player.PLAYER.ID);
        public static final UniqueKey<PlayerInScoreboardRecord> PLAYER_IN_SCOREBOARD_PKEY = Internal.createUniqueKey(PlayerInScoreboard.PLAYER_IN_SCOREBOARD, "player_in_scoreboard_pkey", PlayerInScoreboard.PLAYER_IN_SCOREBOARD.ID);
        public static final UniqueKey<QuestionRecord> QUESTION_PKEY = Internal.createUniqueKey(Question.QUESTION, "question_pkey", Question.QUESTION.ID);
        public static final UniqueKey<QuestionInGameRecord> QUESTION_IN_GAME_PKEY = Internal.createUniqueKey(QuestionInGame.QUESTION_IN_GAME, "question_in_game_pkey", QuestionInGame.QUESTION_IN_GAME.ID);
        public static final UniqueKey<QuestionSetRecord> QUESTION_SET_PKEY = Internal.createUniqueKey(QuestionSet.QUESTION_SET, "question_set_pkey", QuestionSet.QUESTION_SET.ID);
        public static final UniqueKey<RoomRecord> ROOM_PKEY = Internal.createUniqueKey(Room.ROOM, "room_pkey", Room.ROOM.ID);
        public static final UniqueKey<ScoringRecord> SCORING_PKEY = Internal.createUniqueKey(Scoring.SCORING, "scoring_pkey", Scoring.SCORING.ID);
    }

    private static class ForeignKeys0 {
        public static final ForeignKey<AnswerRecord, QuestionInGameRecord> ANSWER__ANSWER_QUESTION_IN_GAME_ID_FKEY = Internal.createForeignKey(com.dovaleac.guessing.game.jooq.generated.Keys.QUESTION_IN_GAME_PKEY, Answer.ANSWER, "answer__answer_question_in_game_id_fkey", Answer.ANSWER.QUESTION_IN_GAME_ID);
        public static final ForeignKey<AnswerRecord, PlayerRecord> ANSWER__ANSWER_PLAYER_ID_FKEY = Internal.createForeignKey(com.dovaleac.guessing.game.jooq.generated.Keys.PLAYER_PKEY, Answer.ANSWER, "answer__answer_player_id_fkey", Answer.ANSWER.PLAYER_ID);
        public static final ForeignKey<ClueRequestRecord, QuestionInGameRecord> CLUE_REQUEST__CLUE_REQUEST_QUESTION_IN_GAME_ID_FKEY = Internal.createForeignKey(com.dovaleac.guessing.game.jooq.generated.Keys.QUESTION_IN_GAME_PKEY, ClueRequest.CLUE_REQUEST, "clue_request__clue_request_question_in_game_id_fkey", ClueRequest.CLUE_REQUEST.QUESTION_IN_GAME_ID);
        public static final ForeignKey<ClueRequestRecord, PlayerRecord> CLUE_REQUEST__CLUE_REQUEST_PLAYER_ID_FKEY = Internal.createForeignKey(com.dovaleac.guessing.game.jooq.generated.Keys.PLAYER_PKEY, ClueRequest.CLUE_REQUEST, "clue_request__clue_request_player_id_fkey", ClueRequest.CLUE_REQUEST.PLAYER_ID);
        public static final ForeignKey<GameRecord, RoomRecord> GAME__GAME_ROOM_ID_FKEY = Internal.createForeignKey(com.dovaleac.guessing.game.jooq.generated.Keys.ROOM_PKEY, Game.GAME, "game__game_room_id_fkey", Game.GAME.ROOM_ID);
        public static final ForeignKey<GameRecord, GameConfigRecord> GAME__GAME_GAME_CONFIG_ID_FKEY = Internal.createForeignKey(com.dovaleac.guessing.game.jooq.generated.Keys.GAME_CONFIG_PKEY, Game.GAME, "game__game_game_config_id_fkey", Game.GAME.GAME_CONFIG_ID);
        public static final ForeignKey<GameRecord, QuestionSetRecord> GAME__GAME_QUESTION_SET_ID_FKEY = Internal.createForeignKey(com.dovaleac.guessing.game.jooq.generated.Keys.QUESTION_SET_PKEY, Game.GAME, "game__game_question_set_id_fkey", Game.GAME.QUESTION_SET_ID);
        public static final ForeignKey<GameRecord, PlayerRecord> GAME__GAME_MASTER_PLAYER_ID_FKEY = Internal.createForeignKey(com.dovaleac.guessing.game.jooq.generated.Keys.PLAYER_PKEY, Game.GAME, "game__game_master_player_id_fkey", Game.GAME.MASTER_PLAYER_ID);
        public static final ForeignKey<GameConfigRecord, ScoringRecord> GAME_CONFIG__GAME_CONFIG_SCORING_ID_FKEY = Internal.createForeignKey(com.dovaleac.guessing.game.jooq.generated.Keys.SCORING_PKEY, GameConfig.GAME_CONFIG, "game_config__game_config_scoring_id_fkey", GameConfig.GAME_CONFIG.SCORING_ID);
        public static final ForeignKey<PlayerRecord, RoomRecord> PLAYER__PLAYER_ROOM_ID_FKEY = Internal.createForeignKey(com.dovaleac.guessing.game.jooq.generated.Keys.ROOM_PKEY, Player.PLAYER, "player__player_room_id_fkey", Player.PLAYER.ROOM_ID);
        public static final ForeignKey<PlayerInScoreboardRecord, GameRecord> PLAYER_IN_SCOREBOARD__PLAYER_IN_SCOREBOARD_GAME_ID_FKEY = Internal.createForeignKey(com.dovaleac.guessing.game.jooq.generated.Keys.GAME_PKEY, PlayerInScoreboard.PLAYER_IN_SCOREBOARD, "player_in_scoreboard__player_in_scoreboard_game_id_fkey", PlayerInScoreboard.PLAYER_IN_SCOREBOARD.GAME_ID);
        public static final ForeignKey<PlayerInScoreboardRecord, PlayerRecord> PLAYER_IN_SCOREBOARD__PLAYER_IN_SCOREBOARD_PLAYER_ID_FKEY = Internal.createForeignKey(com.dovaleac.guessing.game.jooq.generated.Keys.PLAYER_PKEY, PlayerInScoreboard.PLAYER_IN_SCOREBOARD, "player_in_scoreboard__player_in_scoreboard_player_id_fkey", PlayerInScoreboard.PLAYER_IN_SCOREBOARD.PLAYER_ID);
        public static final ForeignKey<QuestionRecord, QuestionSetRecord> QUESTION__QUESTION_QUESTION_SET_ID_FKEY = Internal.createForeignKey(com.dovaleac.guessing.game.jooq.generated.Keys.QUESTION_SET_PKEY, Question.QUESTION, "question__question_question_set_id_fkey", Question.QUESTION.QUESTION_SET_ID);
        public static final ForeignKey<QuestionInGameRecord, QuestionRecord> QUESTION_IN_GAME__QUESTION_IN_GAME_QUESTION_ID_FKEY = Internal.createForeignKey(com.dovaleac.guessing.game.jooq.generated.Keys.QUESTION_PKEY, QuestionInGame.QUESTION_IN_GAME, "question_in_game__question_in_game_question_id_fkey", QuestionInGame.QUESTION_IN_GAME.QUESTION_ID);
        public static final ForeignKey<QuestionInGameRecord, GameRecord> QUESTION_IN_GAME__QUESTION_IN_GAME_GAME_ID_FKEY = Internal.createForeignKey(com.dovaleac.guessing.game.jooq.generated.Keys.GAME_PKEY, QuestionInGame.QUESTION_IN_GAME, "question_in_game__question_in_game_game_id_fkey", QuestionInGame.QUESTION_IN_GAME.GAME_ID);
    }
}
