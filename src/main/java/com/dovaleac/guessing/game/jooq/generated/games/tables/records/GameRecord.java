/*
 * This file is generated by jOOQ.
 */
package com.dovaleac.guessing.game.jooq.generated.games.tables.records;


import com.dovaleac.guessing.game.jooq.generated.games.tables.Game;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Row7;
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
public class GameRecord extends UpdatableRecordImpl<GameRecord> implements Record7<Integer, Integer, Integer, Integer, String, Integer, Integer> {

    private static final long serialVersionUID = 2133665479;

    /**
     * Setter for <code>games.game.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>games.game.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>games.game.room_id</code>.
     */
    public void setRoomId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>games.game.room_id</code>.
     */
    public Integer getRoomId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>games.game.game_config_id</code>.
     */
    public void setGameConfigId(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>games.game.game_config_id</code>.
     */
    public Integer getGameConfigId() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>games.game.lang_id</code>.
     */
    public void setLangId(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>games.game.lang_id</code>.
     */
    public Integer getLangId() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>games.game.status</code>.
     */
    public void setStatus(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>games.game.status</code>.
     */
    public String getStatus() {
        return (String) get(4);
    }

    /**
     * Setter for <code>games.game.question_set_id</code>.
     */
    public void setQuestionSetId(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>games.game.question_set_id</code>.
     */
    public Integer getQuestionSetId() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>games.game.master_player_id</code>.
     */
    public void setMasterPlayerId(Integer value) {
        set(6, value);
    }

    /**
     * Getter for <code>games.game.master_player_id</code>.
     */
    public Integer getMasterPlayerId() {
        return (Integer) get(6);
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
    // Record7 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<Integer, Integer, Integer, Integer, String, Integer, Integer> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<Integer, Integer, Integer, Integer, String, Integer, Integer> valuesRow() {
        return (Row7) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Game.GAME.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return Game.GAME.ROOM_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return Game.GAME.GAME_CONFIG_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return Game.GAME.LANG_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return Game.GAME.STATUS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field6() {
        return Game.GAME.QUESTION_SET_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field7() {
        return Game.GAME.MASTER_PLAYER_ID;
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
        return getRoomId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component3() {
        return getGameConfigId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component4() {
        return getLangId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component6() {
        return getQuestionSetId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component7() {
        return getMasterPlayerId();
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
        return getRoomId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value3() {
        return getGameConfigId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value4() {
        return getLangId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value6() {
        return getQuestionSetId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value7() {
        return getMasterPlayerId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GameRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GameRecord value2(Integer value) {
        setRoomId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GameRecord value3(Integer value) {
        setGameConfigId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GameRecord value4(Integer value) {
        setLangId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GameRecord value5(String value) {
        setStatus(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GameRecord value6(Integer value) {
        setQuestionSetId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GameRecord value7(Integer value) {
        setMasterPlayerId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GameRecord values(Integer value1, Integer value2, Integer value3, Integer value4, String value5, Integer value6, Integer value7) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached GameRecord
     */
    public GameRecord() {
        super(Game.GAME);
    }

    /**
     * Create a detached, initialised GameRecord
     */
    public GameRecord(Integer id, Integer roomId, Integer gameConfigId, Integer langId, String status, Integer questionSetId, Integer masterPlayerId) {
        super(Game.GAME);

        set(0, id);
        set(1, roomId);
        set(2, gameConfigId);
        set(3, langId);
        set(4, status);
        set(5, questionSetId);
        set(6, masterPlayerId);
    }
}
