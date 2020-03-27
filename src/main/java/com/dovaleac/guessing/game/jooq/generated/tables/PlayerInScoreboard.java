/*
 * This file is generated by jOOQ.
 */
package com.dovaleac.guessing.game.jooq.generated.tables;


import com.dovaleac.guessing.game.jooq.generated.Games;
import com.dovaleac.guessing.game.jooq.generated.Indexes;
import com.dovaleac.guessing.game.jooq.generated.Keys;
import com.dovaleac.guessing.game.jooq.generated.tables.records.PlayerInScoreboardRecord;

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
public class PlayerInScoreboard extends TableImpl<PlayerInScoreboardRecord> {

    private static final long serialVersionUID = -1215443745;

    /**
     * The reference instance of <code>games.player_in_scoreboard</code>
     */
    public static final PlayerInScoreboard PLAYER_IN_SCOREBOARD = new PlayerInScoreboard();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<PlayerInScoreboardRecord> getRecordType() {
        return PlayerInScoreboardRecord.class;
    }

    /**
     * The column <code>games.player_in_scoreboard.id</code>.
     */
    public final TableField<PlayerInScoreboardRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('games.player_in_scoreboard_id_seq'::regclass)", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>games.player_in_scoreboard.game_id</code>.
     */
    public final TableField<PlayerInScoreboardRecord, Integer> GAME_ID = createField("game_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>games.player_in_scoreboard.player_id</code>.
     */
    public final TableField<PlayerInScoreboardRecord, Integer> PLAYER_ID = createField("player_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>games.player_in_scoreboard.points</code>.
     */
    public final TableField<PlayerInScoreboardRecord, Integer> POINTS = createField("points", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>games.player_in_scoreboard.questions_guessed</code>.
     */
    public final TableField<PlayerInScoreboardRecord, Integer> QUESTIONS_GUESSED = createField("questions_guessed", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * Create a <code>games.player_in_scoreboard</code> table reference
     */
    public PlayerInScoreboard() {
        this(DSL.name("player_in_scoreboard"), null);
    }

    /**
     * Create an aliased <code>games.player_in_scoreboard</code> table reference
     */
    public PlayerInScoreboard(String alias) {
        this(DSL.name(alias), PLAYER_IN_SCOREBOARD);
    }

    /**
     * Create an aliased <code>games.player_in_scoreboard</code> table reference
     */
    public PlayerInScoreboard(Name alias) {
        this(alias, PLAYER_IN_SCOREBOARD);
    }

    private PlayerInScoreboard(Name alias, Table<PlayerInScoreboardRecord> aliased) {
        this(alias, aliased, null);
    }

    private PlayerInScoreboard(Name alias, Table<PlayerInScoreboardRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> PlayerInScoreboard(Table<O> child, ForeignKey<O, PlayerInScoreboardRecord> key) {
        super(child, key, PLAYER_IN_SCOREBOARD);
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
        return Arrays.<Index>asList(Indexes.PLAYER_IN_SCOREBOARD_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<PlayerInScoreboardRecord, Integer> getIdentity() {
        return Keys.IDENTITY_PLAYER_IN_SCOREBOARD;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<PlayerInScoreboardRecord> getPrimaryKey() {
        return Keys.PLAYER_IN_SCOREBOARD_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<PlayerInScoreboardRecord>> getKeys() {
        return Arrays.<UniqueKey<PlayerInScoreboardRecord>>asList(Keys.PLAYER_IN_SCOREBOARD_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<PlayerInScoreboardRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<PlayerInScoreboardRecord, ?>>asList(Keys.PLAYER_IN_SCOREBOARD__PLAYER_IN_SCOREBOARD_GAME_ID_FKEY, Keys.PLAYER_IN_SCOREBOARD__PLAYER_IN_SCOREBOARD_PLAYER_ID_FKEY);
    }

    public Game game() {
        return new Game(this, Keys.PLAYER_IN_SCOREBOARD__PLAYER_IN_SCOREBOARD_GAME_ID_FKEY);
    }

    public Player player() {
        return new Player(this, Keys.PLAYER_IN_SCOREBOARD__PLAYER_IN_SCOREBOARD_PLAYER_ID_FKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PlayerInScoreboard as(String alias) {
        return new PlayerInScoreboard(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PlayerInScoreboard as(Name alias) {
        return new PlayerInScoreboard(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public PlayerInScoreboard rename(String name) {
        return new PlayerInScoreboard(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public PlayerInScoreboard rename(Name name) {
        return new PlayerInScoreboard(name, null);
    }
}