/*
 * This file is generated by jOOQ.
 */
package com.dovaleac.guessing.game.jooq.generated.independent.tables;


import com.dovaleac.guessing.game.jooq.generated.independent.Independent;
import com.dovaleac.guessing.game.jooq.generated.independent.Indexes;
import com.dovaleac.guessing.game.jooq.generated.independent.Keys;
import com.dovaleac.guessing.game.jooq.generated.independent.tables.records.QuestionSetRecord;

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
public class QuestionSet extends TableImpl<QuestionSetRecord> {

    private static final long serialVersionUID = -774795962;

    /**
     * The reference instance of <code>independent.question_set</code>
     */
    public static final QuestionSet QUESTION_SET = new QuestionSet();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<QuestionSetRecord> getRecordType() {
        return QuestionSetRecord.class;
    }

    /**
     * The column <code>independent.question_set.id</code>.
     */
    public final TableField<QuestionSetRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('independent.question_set_id_seq'::regclass)", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>independent.question_set.lang_id</code>.
     */
    public final TableField<QuestionSetRecord, Integer> LANG_ID = createField("lang_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * Create a <code>independent.question_set</code> table reference
     */
    public QuestionSet() {
        this(DSL.name("question_set"), null);
    }

    /**
     * Create an aliased <code>independent.question_set</code> table reference
     */
    public QuestionSet(String alias) {
        this(DSL.name(alias), QUESTION_SET);
    }

    /**
     * Create an aliased <code>independent.question_set</code> table reference
     */
    public QuestionSet(Name alias) {
        this(alias, QUESTION_SET);
    }

    private QuestionSet(Name alias, Table<QuestionSetRecord> aliased) {
        this(alias, aliased, null);
    }

    private QuestionSet(Name alias, Table<QuestionSetRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> QuestionSet(Table<O> child, ForeignKey<O, QuestionSetRecord> key) {
        super(child, key, QUESTION_SET);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Independent.INDEPENDENT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.QUESTION_SET_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<QuestionSetRecord, Integer> getIdentity() {
        return Keys.IDENTITY_QUESTION_SET;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<QuestionSetRecord> getPrimaryKey() {
        return Keys.QUESTION_SET_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<QuestionSetRecord>> getKeys() {
        return Arrays.<UniqueKey<QuestionSetRecord>>asList(Keys.QUESTION_SET_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<QuestionSetRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<QuestionSetRecord, ?>>asList(Keys.QUESTION_SET__QUESTION_SET_LANG_ID_FKEY);
    }

    public Lang lang() {
        return new Lang(this, Keys.QUESTION_SET__QUESTION_SET_LANG_ID_FKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QuestionSet as(String alias) {
        return new QuestionSet(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QuestionSet as(Name alias) {
        return new QuestionSet(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public QuestionSet rename(String name) {
        return new QuestionSet(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public QuestionSet rename(Name name) {
        return new QuestionSet(name, null);
    }
}