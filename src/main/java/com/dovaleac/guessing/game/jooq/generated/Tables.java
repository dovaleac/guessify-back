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

import javax.annotation.Generated;


/**
 * Convenience access to all tables in games
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>games.answer</code>.
     */
    public static final Answer ANSWER = com.dovaleac.guessing.game.jooq.generated.tables.Answer.ANSWER;

    /**
     * The table <code>games.clue_request</code>.
     */
    public static final ClueRequest CLUE_REQUEST = com.dovaleac.guessing.game.jooq.generated.tables.ClueRequest.CLUE_REQUEST;

    /**
     * The table <code>games.game</code>.
     */
    public static final Game GAME = com.dovaleac.guessing.game.jooq.generated.tables.Game.GAME;

    /**
     * The table <code>games.game_config</code>.
     */
    public static final GameConfig GAME_CONFIG = com.dovaleac.guessing.game.jooq.generated.tables.GameConfig.GAME_CONFIG;

    /**
     * The table <code>games.player</code>.
     */
    public static final Player PLAYER = com.dovaleac.guessing.game.jooq.generated.tables.Player.PLAYER;

    /**
     * The table <code>games.player_in_scoreboard</code>.
     */
    public static final PlayerInScoreboard PLAYER_IN_SCOREBOARD = com.dovaleac.guessing.game.jooq.generated.tables.PlayerInScoreboard.PLAYER_IN_SCOREBOARD;

    /**
     * The table <code>games.question</code>.
     */
    public static final Question QUESTION = com.dovaleac.guessing.game.jooq.generated.tables.Question.QUESTION;

    /**
     * The table <code>games.question_in_game</code>.
     */
    public static final QuestionInGame QUESTION_IN_GAME = com.dovaleac.guessing.game.jooq.generated.tables.QuestionInGame.QUESTION_IN_GAME;

    /**
     * The table <code>games.question_set</code>.
     */
    public static final QuestionSet QUESTION_SET = com.dovaleac.guessing.game.jooq.generated.tables.QuestionSet.QUESTION_SET;

    /**
     * The table <code>games.room</code>.
     */
    public static final Room ROOM = com.dovaleac.guessing.game.jooq.generated.tables.Room.ROOM;

    /**
     * The table <code>games.scoring</code>.
     */
    public static final Scoring SCORING = com.dovaleac.guessing.game.jooq.generated.tables.Scoring.SCORING;
}