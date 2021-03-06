/*
 * This file is generated by jOOQ.
 */
package com.dovaleac.guessing.game.jooq.generated.games.tables;


import com.dovaleac.guessing.game.jooq.generated.games.Games;
import com.dovaleac.guessing.game.jooq.generated.games.Indexes;
import com.dovaleac.guessing.game.jooq.generated.games.Keys;
import com.dovaleac.guessing.game.jooq.generated.games.tables.records.RoomRecord;

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
public class Room extends TableImpl<RoomRecord> {

    private static final long serialVersionUID = 432404016;

    /**
     * The reference instance of <code>games.room</code>
     */
    public static final Room ROOM = new Room();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<RoomRecord> getRecordType() {
        return RoomRecord.class;
    }

    /**
     * The column <code>games.room.id</code>.
     */
    public final TableField<RoomRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('games.room_id_seq'::regclass)", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>games.room.number</code>.
     */
    public final TableField<RoomRecord, String> NUMBER = createField("number", org.jooq.impl.SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>games.room.password</code>.
     */
    public final TableField<RoomRecord, String> PASSWORD = createField("password", org.jooq.impl.SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * Create a <code>games.room</code> table reference
     */
    public Room() {
        this(DSL.name("room"), null);
    }

    /**
     * Create an aliased <code>games.room</code> table reference
     */
    public Room(String alias) {
        this(DSL.name(alias), ROOM);
    }

    /**
     * Create an aliased <code>games.room</code> table reference
     */
    public Room(Name alias) {
        this(alias, ROOM);
    }

    private Room(Name alias, Table<RoomRecord> aliased) {
        this(alias, aliased, null);
    }

    private Room(Name alias, Table<RoomRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Room(Table<O> child, ForeignKey<O, RoomRecord> key) {
        super(child, key, ROOM);
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
        return Arrays.<Index>asList(Indexes.ROOM_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<RoomRecord, Integer> getIdentity() {
        return Keys.IDENTITY_ROOM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<RoomRecord> getPrimaryKey() {
        return Keys.ROOM_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<RoomRecord>> getKeys() {
        return Arrays.<UniqueKey<RoomRecord>>asList(Keys.ROOM_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Room as(String alias) {
        return new Room(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Room as(Name alias) {
        return new Room(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Room rename(String name) {
        return new Room(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Room rename(Name name) {
        return new Room(name, null);
    }
}
