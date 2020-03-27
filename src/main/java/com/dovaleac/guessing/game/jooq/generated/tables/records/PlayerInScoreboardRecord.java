/*
 * This file is generated by jOOQ.
 */
package com.dovaleac.guessing.game.jooq.generated.tables.records;


import com.dovaleac.guessing.game.jooq.generated.tables.PlayerInScoreboard;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class PlayerInScoreboardRecord extends UpdatableRecordImpl<PlayerInScoreboardRecord> implements Record5<Integer, Integer, Integer, Integer, Integer> {

    private static final long serialVersionUID = 452791264;

    /**
     * Setter for <code>games.player_in_scoreboard.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>games.player_in_scoreboard.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>games.player_in_scoreboard.game_id</code>.
     */
    public void setGameId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>games.player_in_scoreboard.game_id</code>.
     */
    public Integer getGameId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>games.player_in_scoreboard.player_id</code>.
     */
    public void setPlayerId(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>games.player_in_scoreboard.player_id</code>.
     */
    public Integer getPlayerId() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>games.player_in_scoreboard.points</code>.
     */
    public void setPoints(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>games.player_in_scoreboard.points</code>.
     */
    public Integer getPoints() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>games.player_in_scoreboard.questions_guessed</code>.
     */
    public void setQuestionsGuessed(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>games.player_in_scoreboard.questions_guessed</code>.
     */
    public Integer getQuestionsGuessed() {
        return (Integer) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<Integer, Integer, Integer, Integer, Integer> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<Integer, Integer, Integer, Integer, Integer> valuesRow() {
        return (Row5) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return PlayerInScoreboard.PLAYER_IN_SCOREBOARD.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return PlayerInScoreboard.PLAYER_IN_SCOREBOARD.GAME_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return PlayerInScoreboard.PLAYER_IN_SCOREBOARD.PLAYER_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return PlayerInScoreboard.PLAYER_IN_SCOREBOARD.POINTS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field5() {
        return PlayerInScoreboard.PLAYER_IN_SCOREBOARD.QUESTIONS_GUESSED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component2() {
        return getGameId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component3() {
        return getPlayerId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component4() {
        return getPoints();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component5() {
        return getQuestionsGuessed();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value2() {
        return getGameId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value3() {
        return getPlayerId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value4() {
        return getPoints();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value5() {
        return getQuestionsGuessed();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PlayerInScoreboardRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PlayerInScoreboardRecord value2(Integer value) {
        setGameId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PlayerInScoreboardRecord value3(Integer value) {
        setPlayerId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PlayerInScoreboardRecord value4(Integer value) {
        setPoints(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PlayerInScoreboardRecord value5(Integer value) {
        setQuestionsGuessed(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PlayerInScoreboardRecord values(Integer value1, Integer value2, Integer value3, Integer value4, Integer value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached PlayerInScoreboardRecord
     */
    public PlayerInScoreboardRecord() {
        super(PlayerInScoreboard.PLAYER_IN_SCOREBOARD);
    }

    /**
     * Create a detached, initialised PlayerInScoreboardRecord
     */
    public PlayerInScoreboardRecord(Integer id, Integer gameId, Integer playerId, Integer points, Integer questionsGuessed) {
        super(PlayerInScoreboard.PLAYER_IN_SCOREBOARD);

        set(0, id);
        set(1, gameId);
        set(2, playerId);
        set(3, points);
        set(4, questionsGuessed);
    }
}
