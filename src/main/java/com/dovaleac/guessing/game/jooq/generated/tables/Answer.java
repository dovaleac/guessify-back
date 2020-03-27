/*
 * This file is generated by jOOQ.
 */
package com.dovaleac.guessing.game.jooq.generated.tables;


import com.dovaleac.guessing.game.jooq.generated.Games;
import com.dovaleac.guessing.game.jooq.generated.Indexes;
import com.dovaleac.guessing.game.jooq.generated.Keys;
import com.dovaleac.guessing.game.jooq.generated.tables.records.AnswerRecord;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


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
public class Answer extends TableImpl<AnswerRecord> {

    private static final long serialVersionUID = -556842525;

    /**
     * The reference instance of <code>games.answer</code>
     */
    public static final Answer ANSWER = new Answer();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<AnswerRecord> getRecordType() {
        return AnswerRecord.class;
    }

    /**
     * The column <code>games.answer.id</code>.
     */
    public final TableField<AnswerRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('games.answer_id_seq'::regclass)", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>games.answer.question_in_game_id</code>.
     */
    public final TableField<AnswerRecord, Integer> QUESTION_IN_GAME_ID = createField("question_in_game_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>games.answer.player_id</code>.
     */
    public final TableField<AnswerRecord, Integer> PLAYER_ID = createField("player_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>games.answer.answer</code>.
     */
    public final TableField<AnswerRecord, String> ANSWER_ = createField("answer", org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>games.answer.status</code>.
     */
    public final TableField<AnswerRecord, String> STATUS = createField("status", org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>games.answer.round</code>.
     */
    public final TableField<AnswerRecord, Integer> ROUND = createField("round", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>games.answer.moment</code>.
     */
    public final TableField<AnswerRecord, OffsetDateTime> MOMENT = createField("moment", org.jooq.impl.SQLDataType.TIMESTAMPWITHTIMEZONE, this, "");

    /**
     * Create a <code>games.answer</code> table reference
     */
    public Answer() {
        this(DSL.name("answer"), null);
    }

    /**
     * Create an aliased <code>games.answer</code> table reference
     */
    public Answer(String alias) {
        this(DSL.name(alias), ANSWER);
    }

    /**
     * Create an aliased <code>games.answer</code> table reference
     */
    public Answer(Name alias) {
        this(alias, ANSWER);
    }

    private Answer(Name alias, Table<AnswerRecord> aliased) {
        this(alias, aliased, null);
    }

    private Answer(Name alias, Table<AnswerRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Answer(Table<O> child, ForeignKey<O, AnswerRecord> key) {
        super(child, key, ANSWER);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Games.GAMES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.ANSWER_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<AnswerRecord, Integer> getIdentity() {
        return Keys.IDENTITY_ANSWER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<AnswerRecord> getPrimaryKey() {
        return Keys.ANSWER_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<AnswerRecord>> getKeys() {
        return Arrays.<UniqueKey<AnswerRecord>>asList(Keys.ANSWER_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<AnswerRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<AnswerRecord, ?>>asList(Keys.ANSWER__ANSWER_QUESTION_IN_GAME_ID_FKEY, Keys.ANSWER__ANSWER_PLAYER_ID_FKEY);
    }

    public QuestionInGame questionInGame() {
        return new QuestionInGame(this, Keys.ANSWER__ANSWER_QUESTION_IN_GAME_ID_FKEY);
    }

    public Player player() {
        return new Player(this, Keys.ANSWER__ANSWER_PLAYER_ID_FKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Answer as(String alias) {
        return new Answer(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Answer as(Name alias) {
        return new Answer(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Answer rename(String name) {
        return new Answer(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Answer rename(Name name) {
        return new Answer(name, null);
    }
}