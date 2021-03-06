/*
 * This file is generated by jOOQ.
 */
package com.dovaleac.guessing.game.jooq.generated.independent.tables.records;


import com.dovaleac.guessing.game.jooq.generated.independent.tables.Question;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
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
public class QuestionRecord extends UpdatableRecordImpl<QuestionRecord> implements Record6<Integer, Integer, String[], String, Integer, String> {

    private static final long serialVersionUID = 1046352689;

    /**
     * Setter for <code>independent.question.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>independent.question.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>independent.question.question_set_id</code>.
     */
    public void setQuestionSetId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>independent.question.question_set_id</code>.
     */
    public Integer getQuestionSetId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>independent.question.clues</code>.
     */
    public void setClues(String... value) {
        set(2, value);
    }

    /**
     * Getter for <code>independent.question.clues</code>.
     */
    public String[] getClues() {
        return (String[]) get(2);
    }

    /**
     * Setter for <code>independent.question.answer</code>.
     */
    public void setAnswer(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>independent.question.answer</code>.
     */
    public String getAnswer() {
        return (String) get(3);
    }

    /**
     * Setter for <code>independent.question.difficulty</code>.
     */
    public void setDifficulty(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>independent.question.difficulty</code>.
     */
    public Integer getDifficulty() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>independent.question.fun_facts</code>.
     */
    public void setFunFacts(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>independent.question.fun_facts</code>.
     */
    public String getFunFacts() {
        return (String) get(5);
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
    // Record6 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<Integer, Integer, String[], String, Integer, String> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<Integer, Integer, String[], String, Integer, String> valuesRow() {
        return (Row6) super.valuesRow();
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
    public Field<Integer> field5() {
        return Question.QUESTION.DIFFICULTY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return Question.QUESTION.FUN_FACTS;
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
    public Integer component5() {
        return getDifficulty();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getFunFacts();
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
    public Integer value5() {
        return getDifficulty();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getFunFacts();
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
    public QuestionRecord value5(Integer value) {
        setDifficulty(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QuestionRecord value6(String value) {
        setFunFacts(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QuestionRecord values(Integer value1, Integer value2, String[] value3, String value4, Integer value5, String value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
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
    public QuestionRecord(Integer id, Integer questionSetId, String[] clues, String answer, Integer difficulty, String funFacts) {
        super(Question.QUESTION);

        set(0, id);
        set(1, questionSetId);
        set(2, clues);
        set(3, answer);
        set(4, difficulty);
        set(5, funFacts);
    }
}
