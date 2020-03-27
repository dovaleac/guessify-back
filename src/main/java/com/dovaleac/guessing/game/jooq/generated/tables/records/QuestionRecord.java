/*
 * This file is generated by jOOQ.
 */
package com.dovaleac.guessing.game.jooq.generated.tables.records;


import com.dovaleac.guessing.game.jooq.generated.tables.Question;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
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
public class QuestionRecord extends UpdatableRecordImpl<QuestionRecord> implements Record4<Integer, Integer, String[], String> {

    private static final long serialVersionUID = -356810210;

    /**
     * Setter for <code>games.question.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>games.question.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>games.question.question_set_id</code>.
     */
    public void setQuestionSetId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>games.question.question_set_id</code>.
     */
    public Integer getQuestionSetId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>games.question.clues</code>.
     */
    public void setClues(String... value) {
        set(2, value);
    }

    /**
     * Getter for <code>games.question.clues</code>.
     */
    public String[] getClues() {
        return (String[]) get(2);
    }

    /**
     * Setter for <code>games.question.answer</code>.
     */
    public void setAnswer(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>games.question.answer</code>.
     */
    public String getAnswer() {
        return (String) get(3);
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
    // Record4 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Integer, Integer, String[], String> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Integer, Integer, String[], String> valuesRow() {
        return (Row4) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Question.QUESTION.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return Question.QUESTION.QUESTION_SET_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String[]> field3() {
        return Question.QUESTION.CLUES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Question.QUESTION.ANSWER;
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
        return getQuestionSetId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] component3() {
        return getClues();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getAnswer();
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
        return getQuestionSetId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] value3() {
        return getClues();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getAnswer();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QuestionRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QuestionRecord value2(Integer value) {
        setQuestionSetId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QuestionRecord value3(String... value) {
        setClues(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QuestionRecord value4(String value) {
        setAnswer(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QuestionRecord values(Integer value1, Integer value2, String[] value3, String value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached QuestionRecord
     */
    public QuestionRecord() {
        super(Question.QUESTION);
    }

    /**
     * Create a detached, initialised QuestionRecord
     */
    public QuestionRecord(Integer id, Integer questionSetId, String[] clues, String answer) {
        super(Question.QUESTION);

        set(0, id);
        set(1, questionSetId);
        set(2, clues);
        set(3, answer);
    }
}