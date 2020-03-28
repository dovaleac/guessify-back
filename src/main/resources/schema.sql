SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

DROP SCHEMA if exists games cascade;
CREATE SCHEMA games;

DROP SCHEMA if exists independent cascade;
CREATE SCHEMA independent;

CREATE TABLE independent.lang (
    id serial primary key,
    abbrev character(2),
    name character varying
);

INSERT INTO independent.lang
    (abbrev, name)
VALUES ('en', 'English');

INSERT INTO independent.lang
    (abbrev, name)
VALUES ('es', 'Español');


CREATE TABLE games.room (
    id serial primary key,
    number character varying not null,
    password character varying not null
);

CREATE TABLE games.scoring (
    id serial primary key,
    scorings character varying,
    malus_if_missed integer
);

CREATE TABLE games.game_config (
    id serial primary key,
    total_rounds integer not null,
    clues_per_question integer default 5,
    errors_allowed_per_question integer default 1,
    scoring_id integer not null references games.scoring(id)
);

CREATE TABLE independent.question_set (
    id serial primary key,
    lang_id integer not null references independent.lang(id)
);

CREATE TABLE games.game (
    id serial primary key,
    room_id integer not null references games.room(id),
    game_config_id integer not null references games.game_config(id),
    lang_id integer not null references independent.lang(id),
    status character varying,
    question_set_id integer not null references independent.question_set(id)
);

CREATE TABLE games.player (
    id serial primary key,
    room_id integer not null references games.room(id),
    name character varying,
    role character varying,
    points integer default 0,
    status character varying
);

ALTER TABLE games.game ADD COLUMN master_player_id integer not null references games.player(id);

CREATE TABLE independent.question (
    id serial primary key,
    question_set_id integer not null references independent.question_set(id),
    clues character varying [],
    answer character varying,
    difficulty integer default 3,
    fun_facts character varying
);

CREATE TABLE games.question_in_game (
    id serial primary key,
    question_id integer not null references independent.question(id),
    game_id integer not null references games.game(id),
    current_clue integer default 0,
    execution_order integer,
    status character varying
);

CREATE TABLE games.answer (
    id serial primary key,
    question_in_game_id integer not null references games.question_in_game(id),
    player_id integer not null references games.player(id),
    answer character varying,
    status character varying,
    current_clue integer,
    moment timestamptz
);

CREATE TABLE games.player_in_scoreboard (
    id serial primary key,
    game_id integer not null references games.game(id),
    player_id integer not null references games.player(id),
    points integer,
    questions_guessed integer
);

CREATE TABLE games.clue_request (
    id serial primary key,
    question_in_game_id integer not null references games.question_in_game(id),
    player_id integer not null references games.player(id),
    moment timestamptz,
    current_clue integer
);

