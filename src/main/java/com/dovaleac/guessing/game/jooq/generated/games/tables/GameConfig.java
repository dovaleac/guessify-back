/*
 * This file is generated by jOOQ.
 */
package com.dovaleac.guessing.game.jooq.generated.games.tables;


import com.dovaleac.guessing.game.jooq.generated.games.Games;
import com.dovaleac.guessing.game.jooq.generated.games.Indexes;
import com.dovaleac.guessing.game.jooq.generated.games.Keys;
import com.dovaleac.guessing.game.jooq.generated.games.tables.records.GameConfigRecord;

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
public class GameConfig extends TableImpl<GameConfigRecord> {

    private static final long serialVersionUID = 1595213598;

    /**
     * The reference instance of <code>games.game_config</code>
     */
    public static final GameConfig GAME_CONFIG = new GameConfig();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<GameConfigRecord> getRecordType() {
        return GameConfigRecord.class;
    }

    /**
     * The column <code>games.game_config.id</code>.
     */
    public final TableField<GameConfigRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('games.game_config_id_seq'::regclass)", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>games.game_config.total_rounds</code>.
     */
    public final TableField<GameConfigRecord, Integer> TOTAL_ROUNDS = createField("total_rounds", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>games.game_config.clues_per_question</code>.
     */
    public final TableField<GameConfigRecord, Integer> CLUES_PER_QUESTION = createField("clues_per_question", org.jooq.impl.SQLDataType.INTEGER.defaultValue(org.jooq.impl.DSL.field("5", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>games.game_config.errors_allowed_per_question</code>.
     */
    public final TableField<GameConfigRecord, Integer> ERRORS_ALLOWED_PER_QUESTION = createField("errors_allowed_per_question", org.jooq.impl.SQLDataType.INTEGER.defaultValue(org.jooq.impl.DSL.field("1", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>games.game_config.scoring_id</code>.
     */
    public final TableField<GameConfigRecord, Integer> SCORING_ID = createField("scoring_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * Create a <code>games.game_config</code> table reference
     */
    public GameConfig() {
        this(DSL.name("game_config"), null);
    }

    /**
     * Create an aliased <code>games.game_config</code> table reference
     */
    public GameConfig(String alias) {
        this(DSL.name(alias), GAME_CONFIG);
    }

    /**
     * Create an aliased <code>games.game_config</code> table reference
     */
    public GameConfig(Name alias) {
        this(alias, GAME_CONFIG);
    }

    private GameConfig(Name alias, Table<GameConfigRecord> aliased) {
        this(alias, aliased, null);
    }

    private GameConfig(Name alias, Table<GameConfigRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> GameConfig(Table<O> child, ForeignKey<O, GameConfigRecord> key) {
        super(child, key, GAME_CONFIG);
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
        return Arrays.<Index>asList(Indexes.GAME_CONFIG_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<GameConfigRecord, Integer> getIdentity() {
        return Keys.IDENTITY_GAME_CONFIG;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<GameConfigRecord> getPrimaryKey() {
        return Keys.GAME_CONFIG_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<GameConfigRecord>> getKeys() {
        return Arrays.<UniqueKey<GameConfigRecord>>asList(Keys.GAME_CONFIG_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<GameConfigRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<GameConfigRecord, ?>>asList(Keys.GAME_CONFIG__GAME_CONFIG_SCORING_ID_FKEY);
    }

    public Scoring scoring() {
        return new Scoring(this, Keys.GAME_CONFIG__GAME_CONFIG_SCORING_ID_FKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GameConfig as(String alias) {
        return new GameConfig(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GameConfig as(Name alias) {
        return new GameConfig(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public GameConfig rename(String name) {
        return new GameConfig(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public GameConfig rename(Name name) {
        return new GameConfig(name, null);
    }
}