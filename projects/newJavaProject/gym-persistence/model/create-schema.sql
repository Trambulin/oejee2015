CREATE TABLE Trainer(
trainer_id SERIAL NOT NULL,
trainer_name CHARACTER VARYING(20) NOT NULL,
trainer_height INTEGER,
trainer_weight INTEGER,
PRIMARY KEY(trainer_id));

ALTER TABLE Trainer OWNER TO postgres;

CREATE TABLE Workout_type(
workout_type_id SERIAL NOT NULL,
workout_type_name CHARACTER VARYING(25),
PRIMARY KEY(workout_type_id));

ALTER TABLE Workout_type OWNER TO postgres;

CREATE TABLE Workout(
workout_id SERIAL NOT NULL,
workout_name CHARACTER VARYING(20) NOT NULL,
workout_hardness CHARACTER VARYING(10) NOT NULL,
workout_number_of_people INTEGER,
workout_requirement CHARACTER VARYING(10),
workout_trainer_id INTEGER NOT NULL,
workout_workout_type_id INTEGER NOT NULL,
PRIMARY KEY(workout_id),
FOREIGN KEY(workout_trainer_id) REFERENCES trainer(trainer_id),
FOREIGN KEY(workout_workout_type_id) REFERENCES workout_type(workout_type_id),
CONSTRAINT people CHECK (workout_number_of_people>1 AND workout_number_of_people<35));

ALTER TABLE Workout OWNER TO postgres;

CREATE TABLE Trainer_qualification(
trainer_qualification_id SERIAL NOT NULL,
trainer_qualification_trainer_id INTEGER NOT NULL,
trainer_qualification_name CHARACTER VARYING(30) NOT NULL,
trainer_qualification_level VARCHAR(5) NOT NULL,
trainer_qualification_year INTEGER,
PRIMARY KEY(trainer_qualification_id),
FOREIGN KEY(trainer_qualification_trainer_id) REFERENCES trainer(trainer_id));

ALTER TABLE Trainer_qualification OWNER TO postgres;

CREATE TABLE Trainer_contact(
trainer_contact_id SERIAL NOT NULL,
trainer_contact_trainer_id INTEGER NOT NULL,
trainer_contact_type CHARACTER VARYING(10) NOT NULL,
trainer_contact_value CHARACTER VARYING(20),
PRIMARY KEY (trainer_contact_id),
FOREIGN KEY(trainer_contact_trainer_id) REFERENCES trainer(trainer_id),
CONSTRAINT constract1 UNIQUE(trainer_contact_value));

ALTER TABLE Trainer_contact OWNER TO postgres;

CREATE TABLE Timetable(
timetable_id SERIAL NOT NULL,
timetable_room CHARACTER VARYING(15) NOT NULL,
timetable_day CHARACTER VARYING(15) NOT NULL,
timetable_time CHARACTER VARYING(5) NOT NULL,
workout_id INTEGER NOT NULL,
PRIMARY KEY (timetable_id),
FOREIGN KEY (workout_id) REFERENCES workout(workout_id));

ALTER TABLE Timetable OWNER TO postgres;

CREATE UNIQUE INDEX WORKOUT_NAME ON Workout USING btree (workout_name, workout_hardness);
CREATE UNIQUE INDEX TRAINER_NAME ON Trainer USING btree (trainer_name);