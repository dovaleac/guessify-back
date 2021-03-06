/*
 * This file is generated by jOOQ.
 */
package com.dovaleac.guessing.game.jooq.generated.games.tables;


import com.dovaleac.guessing.game.jooq.generated.games.Games;
import com.dovaleac.guessing.game.jooq.generated.games.Indexes;
import com.dovaleac.guessing.game.jooq.generated.games.Keys;
import com.dovaleac.guessing.game.jooq.generated.games.tables.records.QuestionInGameRecord;
import com.dovaleac.guessing.game.jooq.generated.independent.tables.Question;

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
public class QuestionInGame extends TableImpl<QuestionInGameRecord> {

    private static final long serialVersionUID = -2133087121;

    /**
     * The reference instance of <code>games.question_in_game</code>
     */
    public static final QuestionInGame QUESTION_IN_GAME = new QuestionInGame();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<QuestionInGameRecord> getRecordType() {
        return QuestionInGameRecord.class;
    }

    /**
     * The column <code>games.question_in_game.id</code>.
     */
    public final TableField<QuestionInGameRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('games.question_in_game_id_seq'::regclass)", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>games.question_in_game.question_id</code>.
     */
    public final TableField<QuestionInGameRecord, Integer> QUESTION_ID = createField("question_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>games.question_in_game.game_id</code>.
     */
    public final TableField<QuestionInGameRecord, Integer> GAME_ID = createField("game_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>games.question_in_game.current_clue</code>.
     */
    public final TableField<QuestionInGameRecord, Integer> CURRENT_CLUE = createField("current_clue", org.jooq.impl.SQLDataType.INTEGER.defaultValue(org.jooq.impl.DSL.field("0", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>games.question_in_game.execution_order</code>.
     */
    public final TableField<QuestionInGameRecord, Integer> EXECUTION_ORDER = createField("execution_order", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>games.question_in_game.status</code>.
     */
    public final TableField<QuestionInGameRecord, String> STATUS = createField("status", org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * Create a <code>games.question_in_game</code> table reference
     */
    public QuestionInGame() {
        this(DSL.name("question_in_game"), null);
    }

    /**
     * Create an aliased <code>games.question_in_game</code> table reference
     */
    public QuestionInGame(String alias) {
        this(DSL.name(alias), QUESTION_IN_GAME);
    }

    /**
     * Create an aliased <code>games.question_in_game</code> table reference
     */
    public QuestionInGame(Name alias) {
        this(alias, QUESTION_IN_GAME);
    }

    private QuestionInGame(Name alias, Table<QuestionInGameRecord> aliased) {
        this(alias, aliased, null);
    }

    private QuestionInGame(Name alias, Table<QuestionInGameRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> QuestionInGame(Table<O> child, ForeignKey<O, QuestionInGameRecord> key) {
        super(child, key, QUESTION_IN_GAME);
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
        return Arrays.<Index>asList(Indexes.QUESTION_IN_GAME_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<QuestionInGameRecord, Integer> getIdentity() {
        return Keys.IDENTITY_QUESTION_IN_GAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<QuestionInGameRecord> getPrimaryKey() {
        return Keys.QUESTION_IN_GAME_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<QuestionInGameRecord>> getKeys() {
        return Arrays.<UniqueKey<QuestionInGameRecord>>asList(Keys.QUESTION_IN_GAME_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<QuestionInGameRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<QuestionInGameRecord, ?>>asList(Keys.QUESTION_IN_GAME__QUESTION_IN_GAME_QUESTION_ID_FKEY, Keys.QUESTION_IN_GAME__QUESTION_IN_GAME_GAME_ID_FKEY);
    }

    public Question question() {
        return new Question(this, Keys.QUESTION_IN_GAME__QUESTION_IN_GAME_QUESTION_ID_FKEY);
    }

    public Game game() {
        return new Game(this, Keys.QUESTION_IN_GAME__QUESTION_IN_GAME_GAME_ID_FKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QuestionInGame as(String alias) {
        return new QuestionInGame(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QuestionInGame as(Name alias) {
        return new QuestionInGame(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public QuestionInGame rename(String name) {
        return new QuestionInGame(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public QuestionInGame rename(Name name) {
        return new QuestionInGame(name, null);
    }
}
