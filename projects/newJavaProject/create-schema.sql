CREATE TABLE trainer(
trainer_id SERIAL NOT NULL,
trainer_name CHARACTER VARYING(20) NOT NULL,
trainer_height INTEGER,
trainer_weight INTEGER,
PRIMARY KEY(trainer_id));

ALTER TABLE trainer OWNER TO postgres;

CREATE TABLE workout(
workout_id SERIAL NOT NULL,
workout_name CHARACTER VARYING(20) NOT NULL,
workout_hardness CHARACTER VARYING(10) NOT NULL,
workout_number_of_people INTEGER,
workout_requirement CHARACTER VARYING(10),
trainer_id INTEGER NOT NULL,
PRIMARY KEY(workout_id),
FOREIGN KEY(trainer_id) REFERENCES trainer(trainer_id),
CONSTRAINT people CHECK (workout_number_of_people>1 AND workout_number_of_people<35));

ALTER TABLE workout OWNER TO postgres;

CREATE TABLE workout_type(
workout_id INTEGER NOT NULL,
workout_type_name CHARACTER VARYING(20),
FOREIGN KEY(workout_id) REFERENCES workout(workout_id));

ALTER TABLE workout_type OWNER TO postgres;

CREATE TABLE trainer_qualification(
trainer_qualification_id SERIAL NOT NULL,
trainer_id INTEGER NOT NULL,
trainer_qualification_name CHARACTER VARYING(30) NOT NULL,
trainer_qualification_level VARCHAR(5) NOT NULL,
trainer_qualification_year INTEGER,
PRIMARY KEY(trainer_qualification_id),
FOREIGN KEY(trainer_id) REFERENCES trainer(trainer_id));

ALTER TABLE trainer_qualification OWNER TO postgres;

CREATE TABLE trainer_contact(
trainer_contact_id SERIAL NOT NULL,
trainer_id INTEGER NOT NULL,
trainer_contact_type CHARACTER VARYING(10) NOT NULL,
trainer_contact_value CHARACTER VARYING(20),
PRIMARY KEY (trainer_contact_id),
FOREIGN KEY(trainer_id) REFERENCES trainer(trainer_id),
CONSTRAINT constract1 UNIQUE(trainer_contact_value));

ALTER TABLE trainer_contact OWNER TO postgres;

CREATE TABLE timetable(
timetable_id SERIAL NOT NULL,
timetable_room CHARACTER VARYING(15) NOT NULL,
timetable_day CHARACTER VARYING(10) NOT NULL,
timetable_time CHARACTER VARYING(5) NOT NULL,
workout_id INTEGER NOT NULL,
PRIMARY KEY (timetable_id),
FOREIGN KEY (workout_id) REFERENCES workout(workout_id));

ALTER TABLE timetable OWNER TO postgres;

CREATE UNIQUE INDEX WORKOUT_NAME ON workout USING btree (workout_name);
CREATE UNIQUE INDEX TRAINER_NAME ON trainer USING btree (trainer_name);