/*
 * This file is generated by jOOQ.
 */
package com.dovaleac.guessing.game.jooq.generated.independent.tables.records;


import com.dovaleac.guessing.game.jooq.generated.independent.tables.QuestionSet;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Row2;
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
public class QuestionSetRecord extends UpdatableRecordImpl<QuestionSetRecord> implements Record2<Integer, Integer> {

    private static final long serialVersionUID = -460065501;

    /**
     * Setter for <code>independent.question_set.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>independent.question_set.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>independent.question_set.lang_id</code>.
     */
    public void setLangId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>independent.question_set.lang_id</code>.
     */
    public Integer getLangId() {
        return (Integer) get(1);
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
    // Record2 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<Integer, Integer> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<Integer, Integer> valuesRow() {
        return (Row2) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return QuestionSet.QUESTION_SET.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return QuestionSet.QUESTION_SET.LANG_ID;
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
        return getLangId();
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
        return getLangId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QuestionSetRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QuestionSetRecord value2(Integer value) {
        setLangId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QuestionSetRecord values(Integer value1, Integer value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached QuestionSetRecord
     */
    public QuestionSetRecord() {
        super(QuestionSet.QUESTION_SET);
    }

    /**
     * Create a detached, initialised QuestionSetRecord
     */
    public QuestionSetRecord(Integer id, Integer langId) {
        super(QuestionSet.QUESTION_SET);

        set(0, id);
        set(1, langId);
    }
}
