GRANT SELECT, INSERT, UPDATE, DELETE ON trainer,workout,workout_type,trainer_qualification,trainer_contact,timetable TO gymowner_role;

GRANT USAGE, SELECT, UPDATE ON trainer_trainer_id_seq TO gymowner_role;
GRANT USAGE, SELECT, UPDATE ON workout_workout_id_seq TO gymowner_role;
GRANT USAGE, SELECT, UPDATE ON trainer_qualification_trainer_qualification_id_seq TO gymowner_role;
GRANT USAGE, SELECT, UPDATE ON trainer_contact_trainer_contact_id_seq TO gymowner_role;
GRANT USAGE, SELECT, UPDATE ON timetable_timetable_id_seq TO gymowner_role;