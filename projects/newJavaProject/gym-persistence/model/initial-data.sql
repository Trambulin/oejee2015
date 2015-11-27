INSERT INTO trainer (trainer_name,trainer_height,trainer_weight) VALUES('Kiss Imre',170,85);
INSERT INTO trainer (trainer_name,trainer_height,trainer_weight) VALUES('Kozma Bea',160,50);
INSERT INTO trainer (trainer_name,trainer_height,trainer_weight) VALUES('Toth Peter',180,90); 
INSERT INTO trainer (trainer_name,trainer_height,trainer_weight) VALUES('Nagy Janos',175,77); 
INSERT INTO trainer (trainer_name,trainer_height,trainer_weight) VALUES('Csati Attila',170,75); 
INSERT INTO trainer (trainer_name,trainer_height,trainer_weight) VALUES('Varga Judit',165,55); 
INSERT INTO trainer (trainer_name,trainer_height,trainer_weight) VALUES('Tolnay Robert',168,70); 
INSERT INTO trainer (trainer_name,trainer_height,trainer_weight) VALUES('Bencze Erzsebet',163,48); 
INSERT INTO trainer (trainer_name,trainer_height,trainer_weight) VALUES('Jonas Matyas',188,96); 
INSERT INTO trainer (trainer_name,trainer_height,trainer_weight) VALUES('Barna Ibolya',157,45); 
INSERT INTO trainer (trainer_name,trainer_height,trainer_weight) VALUES('Forgach Beatrix',165,55); 
INSERT INTO trainer (trainer_name,trainer_height,trainer_weight) VALUES('Lorinc Tímea',170,60);
INSERT INTO trainer (trainer_name,trainer_height,trainer_weight) VALUES('Varadi Ferenc',180,80); 
INSERT INTO trainer (trainer_name,trainer_height,trainer_weight) VALUES('Mester Dora',163,68);
INSERT INTO trainer (trainer_name,trainer_height,trainer_weight) VALUES('Berta Emese',153,42);
INSERT INTO trainer (trainer_name,trainer_height,trainer_weight) VALUES('Lantos Gergely',170,78);
INSERT INTO trainer (trainer_name,trainer_height,trainer_weight) VALUES('Csikos Dalma',168,63);

INSERT INTO workout_type (workout_type_name) VALUES('eroemeles');
INSERT INTO workout_type (workout_type_name) VALUES('crossfit');
INSERT INTO workout_type (workout_type_name) VALUES('kuzdosport/onvedelem');
INSERT INTO workout_type (workout_type_name) VALUES('box');
INSERT INTO workout_type (workout_type_name) VALUES('allokepesseg');
INSERT INTO workout_type (workout_type_name) VALUES('sulyemeles');
INSERT INTO workout_type (workout_type_name) VALUES('sajat testsulyos');
INSERT INTO workout_type (workout_type_name) VALUES('nyujtas');
INSERT INTO workout_type (workout_type_name) VALUES('joga');
INSERT INTO workout_type (workout_type_name) VALUES('tanc');
INSERT INTO workout_type (workout_type_name) VALUES('alakformalo');


INSERT INTO workout (workout_name,workout_hardness,workout_number_of_people,workout_requirement,workout_trainer_id,workout_workout_type_id) VALUES('G beavatas','kezdo',5,NULL,1,1);
INSERT INTO workout (workout_name,workout_hardness,workout_number_of_people,workout_requirement,workout_trainer_id,workout_workout_type_id) VALUES('Athletic body','halado',8,'kezdo',1,1);
INSERT INTO workout (workout_name,workout_hardness,workout_number_of_people,workout_requirement,workout_trainer_id,workout_workout_type_id) VALUES('Crossfit','kezdo',7,NULL,3,2);
INSERT INTO workout (workout_name,workout_hardness,workout_number_of_people,workout_requirement,workout_trainer_id,workout_workout_type_id) VALUES('Krav maga','halado',15,'kezdo',5,3);
INSERT INTO workout (workout_name,workout_hardness,workout_number_of_people,workout_requirement,workout_trainer_id,workout_workout_type_id) VALUES('Thai box','kezdo',12,NULL,4,4);
INSERT INTO workout (workout_name,workout_hardness,workout_number_of_people,workout_requirement,workout_trainer_id,workout_workout_type_id) VALUES('Kettlebell','halado',10,'kezdo',5,5);
INSERT INTO workout (workout_name,workout_hardness,workout_number_of_people,workout_requirement,workout_trainer_id,workout_workout_type_id) VALUES('Kettlebell','kezdo',8,NULL,2,5);
INSERT INTO workout (workout_name,workout_hardness,workout_number_of_people,workout_requirement,workout_trainer_id,workout_workout_type_id) VALUES('Power training','kezdo',12,NULL,6,7);
INSERT INTO workout (workout_name,workout_hardness,workout_number_of_people,workout_requirement,workout_trainer_id,workout_workout_type_id) VALUES('UST','halado',5,'kezdo',1,1);
INSERT INTO workout (workout_name,workout_hardness,workout_number_of_people,workout_requirement,workout_trainer_id,workout_workout_type_id) VALUES('WOD','halado',12,NULL,3,2);
INSERT INTO workout (workout_name,workout_hardness,workout_number_of_people,workout_requirement,workout_trainer_id,workout_workout_type_id) VALUES('TRX','kezdo',14,NULL,7,7);
INSERT INTO workout (workout_name,workout_hardness,workout_number_of_people,workout_requirement,workout_trainer_id,workout_workout_type_id) VALUES('TRX','halado',14,'kezdo',7,7);
INSERT INTO workout (workout_name,workout_hardness,workout_number_of_people,workout_requirement,workout_trainer_id,workout_workout_type_id) VALUES('RIP60','halado',8,'kezdo',8,7);
INSERT INTO workout (workout_name,workout_hardness,workout_number_of_people,workout_requirement,workout_trainer_id,workout_workout_type_id) VALUES('Fegyencedzes','kezdo',22,NULL,10,7);
INSERT INTO workout (workout_name,workout_hardness,workout_number_of_people,workout_requirement,workout_trainer_id,workout_workout_type_id) VALUES('Fegyencedzes','halado',14,'kezdo',9,7);
INSERT INTO workout (workout_name,workout_hardness,workout_number_of_people,workout_requirement,workout_trainer_id,workout_workout_type_id) VALUES('Streching','kezdo',25,NULL,11,8);
INSERT INTO workout (workout_name,workout_hardness,workout_number_of_people,workout_requirement,workout_trainer_id,workout_workout_type_id) VALUES('Joga','kezdo',8,NULL,11,9);
INSERT INTO workout (workout_name,workout_hardness,workout_number_of_people,workout_requirement,workout_trainer_id,workout_workout_type_id) VALUES('Joga','halado',12,'kezdo',11,9);
INSERT INTO workout (workout_name,workout_hardness,workout_number_of_people,workout_requirement,workout_trainer_id,workout_workout_type_id) VALUES('Street workout','halado',10,NULL,13,7);
INSERT INTO workout (workout_name,workout_hardness,workout_number_of_people,workout_requirement,workout_trainer_id,workout_workout_type_id) VALUES('Spinning','kezdo',10,NULL,12,11);
INSERT INTO workout (workout_name,workout_hardness,workout_number_of_people,workout_requirement,workout_trainer_id,workout_workout_type_id) VALUES('Hip-hop','kezdo',16,NULL,12,10);
INSERT INTO workout (workout_name,workout_hardness,workout_number_of_people,workout_requirement,workout_trainer_id,workout_workout_type_id) VALUES('Karate','kezdo',16,NULL,16,3);
INSERT INTO workout (workout_name,workout_hardness,workout_number_of_people,workout_requirement,workout_trainer_id,workout_workout_type_id) VALUES('Erosito aerobic','kezdo',16,NULL,14,11);
INSERT INTO workout (workout_name,workout_hardness,workout_number_of_people,workout_requirement,workout_trainer_id,workout_workout_type_id) VALUES('Step aerobic','kezdo',16,NULL,15,11);
INSERT INTO workout (workout_name,workout_hardness,workout_number_of_people,workout_requirement,workout_trainer_id,workout_workout_type_id) VALUES('Indoor Cycling','kezdo',12,NULL,17,5);



INSERT INTO trainer_contact (trainer_contact_trainer_id,trainer_contact_type,trainer_contact_value) VALUES(2,'telefon','+36304223670');
INSERT INTO trainer_contact (trainer_contact_trainer_id,trainer_contact_type,trainer_contact_value) VALUES(2,'email','beata@gmail.com');
INSERT INTO trainer_contact (trainer_contact_trainer_id,trainer_contact_type,trainer_contact_value) VALUES(3,'telefon','+36702314226');
INSERT INTO trainer_contact (trainer_contact_trainer_id,trainer_contact_type,trainer_contact_value) VALUES(3,'skype','toth.peter');
INSERT INTO trainer_contact (trainer_contact_trainer_id,trainer_contact_type,trainer_contact_value) VALUES(4,'telefon','+36301153641');
INSERT INTO trainer_contact (trainer_contact_trainer_id,trainer_contact_type,trainer_contact_value) VALUES(1,'email','imre@gmail.com');
INSERT INTO trainer_contact (trainer_contact_trainer_id,trainer_contact_type,trainer_contact_value) VALUES(1,'skype','kiss.imre');
INSERT INTO trainer_contact (trainer_contact_trainer_id,trainer_contact_type,trainer_contact_value) VALUES(1,'telefon','+36205714012');
INSERT INTO trainer_contact (trainer_contact_trainer_id,trainer_contact_type,trainer_contact_value) VALUES(5,'telefon','+36303254572');
INSERT INTO trainer_contact (trainer_contact_trainer_id,trainer_contact_type,trainer_contact_value) VALUES(5,'email',' attila@gmail.com');
INSERT INTO trainer_contact (trainer_contact_trainer_id,trainer_contact_type,trainer_contact_value) VALUES(6,'telefon','+36201116281');
INSERT INTO trainer_contact (trainer_contact_trainer_id,trainer_contact_type,trainer_contact_value) VALUES(7,'telefon','+36207856932');
INSERT INTO trainer_contact (trainer_contact_trainer_id,trainer_contact_type,trainer_contact_value) VALUES(8,'telefon','+36204856954');
INSERT INTO trainer_contact (trainer_contact_trainer_id,trainer_contact_type,trainer_contact_value) VALUES(8,'skype','b.erzsebet');
INSERT INTO trainer_contact (trainer_contact_trainer_id,trainer_contact_type,trainer_contact_value) VALUES(9,'telefon','+367826942');
INSERT INTO trainer_contact (trainer_contact_trainer_id,trainer_contact_type,trainer_contact_value) VALUES(10,'telefon','+36704875632');
INSERT INTO trainer_contact (trainer_contact_trainer_id,trainer_contact_type,trainer_contact_value) VALUES(11,'telefon','+36304936582');
INSERT INTO trainer_contact (trainer_contact_trainer_id,trainer_contact_type,trainer_contact_value) VALUES(11,'email','beatri@gmail.com');
INSERT INTO trainer_contact (trainer_contact_trainer_id,trainer_contact_type,trainer_contact_value) VALUES(12,'telefon','+36704129687');
INSERT INTO trainer_contact (trainer_contact_trainer_id,trainer_contact_type,trainer_contact_value) VALUES(13,'telefon','+36205478236');
INSERT INTO trainer_contact (trainer_contact_trainer_id,trainer_contact_type,trainer_contact_value) VALUES(13,'email','ferencv@gmail.com');
INSERT INTO trainer_contact (trainer_contact_trainer_id,trainer_contact_type,trainer_contact_value) VALUES(14,'telefon','+36701254796');
INSERT INTO trainer_contact (trainer_contact_trainer_id,trainer_contact_type,trainer_contact_value) VALUES(15,'telefon','+36704863588');
INSERT INTO trainer_contact (trainer_contact_trainer_id,trainer_contact_type,trainer_contact_value) VALUES(16,'telefon','+36304856932');
INSERT INTO trainer_contact (trainer_contact_trainer_id,trainer_contact_type,trainer_contact_value) VALUES(16,'skype','l.gergo');
INSERT INTO trainer_contact (trainer_contact_trainer_id,trainer_contact_type,trainer_contact_value) VALUES(16,'email','lgergo@gmail.com');
INSERT INTO trainer_contact (trainer_contact_trainer_id,trainer_contact_type,trainer_contact_value) VALUES(17,'telefon','+36304846932');


INSERT INTO trainer_qualification(trainer_qualification_trainer_id, trainer_qualification_name , trainer_qualification_level, trainer_qualification_year) VALUES(4,'Thai Box Euro pass', 'T1', 2005 );
INSERT INTO trainer_qualification(trainer_qualification_trainer_id, trainer_qualification_name , trainer_qualification_level, trainer_qualification_year) VALUES(4,'Thai Box Euro pass', 'T2', 2008 );
INSERT INTO trainer_qualification(trainer_qualification_trainer_id, trainer_qualification_name , trainer_qualification_level, trainer_qualification_year) VALUES(4,'Thai Box Euro pass', 'T3', 2011 );
INSERT INTO trainer_qualification(trainer_qualification_trainer_id, trainer_qualification_name , trainer_qualification_level, trainer_qualification_year) VALUES(1,'Power Training kepzes', '1', 2009 );
INSERT INTO trainer_qualification(trainer_qualification_trainer_id, trainer_qualification_name , trainer_qualification_level, trainer_qualification_year) VALUES(1,'Power Training kepzes', '2', 2011 );
INSERT INTO trainer_qualification(trainer_qualification_trainer_id, trainer_qualification_name , trainer_qualification_level, trainer_qualification_year) VALUES(1,'Power Training kepzes', '3', 2013 );
INSERT INTO trainer_qualification(trainer_qualification_trainer_id, trainer_qualification_name , trainer_qualification_level, trainer_qualification_year) VALUES(3,'Crossfit Hungary', 'alap', 2013 );
INSERT INTO trainer_qualification(trainer_qualification_trainer_id, trainer_qualification_name , trainer_qualification_level, trainer_qualification_year) VALUES(5,'KMG', 'G1', 2011 );
INSERT INTO trainer_qualification(trainer_qualification_trainer_id, trainer_qualification_name , trainer_qualification_level, trainer_qualification_year) VALUES(5,'KMG', 'G2', 2012 );
INSERT INTO trainer_qualification(trainer_qualification_trainer_id, trainer_qualification_name , trainer_qualification_level, trainer_qualification_year) VALUES(5,'Kettlebell instruktori', 'D1', 2012 );

INSERT INTO timetable (timetable_room,timetable_day,timetable_time,workout_id) VALUES('nagy terem','hetfo','15:30',6);
INSERT INTO timetable (timetable_room,timetable_day,timetable_time,workout_id) VALUES('kis terem','hetfo','17:30',7);
INSERT INTO timetable (timetable_room,timetable_day,timetable_time,workout_id) VALUES('udvar','kedd','16:00',8);
INSERT INTO timetable (timetable_room,timetable_day,timetable_time,workout_id) VALUES('kis terem','kedd','12:15',1);
INSERT INTO timetable (timetable_room,timetable_day,timetable_time,workout_id) VALUES('fitness terem','szerda','17:30',5);
INSERT INTO timetable (timetable_room,timetable_day,timetable_time,workout_id) VALUES('fitness terem','szerda','19:30',5);
INSERT INTO timetable (timetable_room,timetable_day,timetable_time,workout_id) VALUES('kiss terem','szerda','13:30',9);
INSERT INTO timetable (timetable_room,timetable_day,timetable_time,workout_id) VALUES('nagy terem','szerda','15:30',4);
INSERT INTO timetable (timetable_room,timetable_day,timetable_time,workout_id) VALUES('kis terem','csutortok','15:00',2);
INSERT INTO timetable (timetable_room,timetable_day,timetable_time,workout_id) VALUES('nagy terem','csutortok','19:00',10);
INSERT INTO timetable (timetable_room,timetable_day,timetable_time,workout_id) VALUES('fitness terem','hetfo','19:00',1);
INSERT INTO timetable (timetable_room,timetable_day,timetable_time,workout_id) VALUES('kis terem','kedd','11:00',7);
INSERT INTO timetable (timetable_room,timetable_day,timetable_time,workout_id) VALUES('nagy terem','csutortok','15:00',11);
INSERT INTO timetable (timetable_room,timetable_day,timetable_time,workout_id) VALUES('nagy terem','csutortok','14:30',14);
INSERT INTO timetable (timetable_room,timetable_day,timetable_time,workout_id) VALUES('udvar','szerda','16:15',7);
INSERT INTO timetable (timetable_room,timetable_day,timetable_time,workout_id) VALUES('nagy terem','kedd','12:15',6);
INSERT INTO timetable (timetable_room,timetable_day,timetable_time,workout_id) VALUES('nagy terem','hetfo','20:00',6);
INSERT INTO timetable (timetable_room,timetable_day,timetable_time,workout_id) VALUES('nagy terem','szombat','11:00',19);
INSERT INTO timetable (timetable_room,timetable_day,timetable_time,workout_id) VALUES('fitness terem','kedd','21:00',8);
INSERT INTO timetable (timetable_room,timetable_day,timetable_time,workout_id) VALUES('nagy terem','csutortok','17:30',8);
INSERT INTO timetable (timetable_room,timetable_day,timetable_time,workout_id) VALUES('kis terem','kedd','07:00',8);
INSERT INTO timetable (timetable_room,timetable_day,timetable_time,workout_id) VALUES('kis terem','kedd','12:00',1);
INSERT INTO timetable (timetable_room,timetable_day,timetable_time,workout_id) VALUES('fitness terem','csutortok','15:30',1);
INSERT INTO timetable (timetable_room,timetable_day,timetable_time,workout_id) VALUES('udvar','hetfo','16:00',1);
INSERT INTO timetable (timetable_room,timetable_day,timetable_time,workout_id) VALUES('udvar','hetfo','17:00',5);
INSERT INTO timetable (timetable_room,timetable_day,timetable_time,workout_id) VALUES('kis terem','szerda','12:00',5);
INSERT INTO timetable (timetable_room,timetable_day,timetable_time,workout_id) VALUES('nagy terem','kedd','11:00',12);
INSERT INTO timetable (timetable_room,timetable_day,timetable_time,workout_id) VALUES('fitness terem','pentek','08:00',9);
INSERT INTO timetable (timetable_room,timetable_day,timetable_time,workout_id) VALUES('fitness terem','szerda','11:00',9);
INSERT INTO timetable (timetable_room,timetable_day,timetable_time,workout_id) VALUES('kis terem','szombat','12:00',9);
INSERT INTO timetable (timetable_room,timetable_day,timetable_time,workout_id) VALUES('fitness terem','kedd','11:00',9);
INSERT INTO timetable (timetable_room,timetable_day,timetable_time,workout_id) VALUES('kis terem','csutortok','14:30',4);
INSERT INTO timetable (timetable_room,timetable_day,timetable_time,workout_id) VALUES('kis terem','hetfo','12:15',4);
INSERT INTO timetable (timetable_room,timetable_day,timetable_time,workout_id) VALUES('fitness terem','pentek','18:00',4);
INSERT INTO timetable (timetable_room,timetable_day,timetable_time,workout_id) VALUES('nagy terem','kedd','19:30',4);
INSERT INTO timetable (timetable_room,timetable_day,timetable_time,workout_id) VALUES('nagy terem','csutortok','15:30',2);
INSERT INTO timetable (timetable_room,timetable_day,timetable_time,workout_id) VALUES('udvar','csutortok','14:15',2);
INSERT INTO timetable (timetable_room,timetable_day,timetable_time,workout_id) VALUES('udvar','szombat','15:45',2);
INSERT INTO timetable (timetable_room,timetable_day,timetable_time,workout_id) VALUES('kis terem','pentek','19:00',2);
INSERT INTO timetable (timetable_room,timetable_day,timetable_time,workout_id) VALUES('fitness terem','hetfo','20:00',2);
INSERT INTO timetable (timetable_room,timetable_day,timetable_time,workout_id) VALUES('nagy terem','hetfo','21:00',10);
INSERT INTO timetable (timetable_room,timetable_day,timetable_time,workout_id) VALUES('nagy terem','pentek','10:00',15);
INSERT INTO timetable (timetable_room,timetable_day,timetable_time,workout_id) VALUES('fitness terem','szerda','10:00',10);
INSERT INTO timetable (timetable_room,timetable_day,timetable_time,workout_id) VALUES('kis terem','pentek','07:00',10);
INSERT INTO timetable (timetable_room,timetable_day,timetable_time,workout_id) VALUES('fitness terem','kedd','08:00',7);
INSERT INTO timetable (timetable_room,timetable_day,timetable_time,workout_id) VALUES('kis terem','kedd','09:00',11);
INSERT INTO timetable (timetable_room,timetable_day,timetable_time,workout_id) VALUES('kis terem','pentek','10:00',16);
INSERT INTO timetable (timetable_room,timetable_day,timetable_time,workout_id) VALUES('nagy terem','kedd','17:00',17);
INSERT INTO timetable (timetable_room,timetable_day,timetable_time,workout_id) VALUES('nagy terem','hetfo','15:00',18);
INSERT INTO timetable (timetable_room,timetable_day,timetable_time,workout_id) VALUES('udvar','pentek','13:30',23);
INSERT INTO timetable (timetable_room,timetable_day,timetable_time,workout_id) VALUES('nagy terem','kedd','14:30',24);
INSERT INTO timetable (timetable_room,timetable_day,timetable_time,workout_id) VALUES('nagy terem','pentek','17:30',25);
INSERT INTO timetable (timetable_room,timetable_day,timetable_time,workout_id) VALUES('kis terem','szerda','14:00',25);
INSERT INTO timetable (timetable_room,timetable_day,timetable_time,workout_id) VALUES('kis terem','szerda','15:00',20);
INSERT INTO timetable (timetable_room,timetable_day,timetable_time,workout_id) VALUES('nagy terem','szerda','16:00',21);
INSERT INTO timetable (timetable_room,timetable_day,timetable_time,workout_id) VALUES('kis terem','szerda','14:30',22);
INSERT INTO timetable (timetable_room,timetable_day,timetable_time,workout_id) VALUES('kis terem','szerda','09:00',5);