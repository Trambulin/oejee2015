INSERT INTO c_type (c_type_id,c_type_name) VALUES (1,'flat');
INSERT INTO c_type (c_type_id,c_type_name) VALUES (2,'brick building');

INSERT INTO condominium (condominium_loc,condominium_floors,condominium_build_year,condominium_type) VALUES('Budapest XIII. Váci út 121.',3,'1971-07-13',1);
INSERT INTO condominium (condominium_loc,condominium_floors,condominium_build_year,condominium_type) VALUES('Budapest XII. Kossuth út 12.',2,'1951-07-13',2);
INSERT INTO condominium (condominium_loc,condominium_floors,condominium_build_year,condominium_type) VALUES('Budapest XI. Jókai út 10.',6,'1941-07-13',1);

INSERT INTO c_owner (c_owner_name,c_owner_birt_date,c_owner_gender, c_owner_phone,c_owner_e_mail) VALUES('Nagy Nándor','1981-07-13','m','06301254578','n@n.com'); 
INSERT INTO c_owner (c_owner_name,c_owner_birt_date,c_owner_gender, c_owner_phone,c_owner_e_mail) VALUES('Nagy Angéla','1991-07-13','f','06701254578','n@a.com'); 
INSERT INTO c_owner (c_owner_name,c_owner_birt_date,c_owner_gender, c_owner_phone,c_owner_e_mail) VALUES('Kis Károly','1981-07-13','m','06201254578','n@k.com'); 

INSERT INTO repair (repair_con_id,repair_description,repair_price,repair_date) VALUES (1,'desc1',123000,'2005-07-13');
INSERT INTO repair (repair_con_id,repair_description,repair_price,repair_date) VALUES (2,'desc2',90000,'2005-07-13');
INSERT INTO repair (repair_con_id,repair_description,repair_price,repair_date) VALUES (1,'desc3',123700,'2005-07-13');
insert into repair (repair_con_id, repair_description,repair_price,repair_date) values(2,'paint',300000,'2012-08-01');
insert into repair (repair_con_id, repair_description,repair_price,repair_date) values(2,'painting',200000,'2015-08-01');
insert into repair (repair_con_id, repair_description,repair_price,repair_date) values(1,'nothing',80000,'2013-08-01');


INSERT INTO c_user (c_user_login,c_user_pass,c_user_e_mail,c_user_full_name) VALUES ('boss','s2e5a1E2asd21','boss@cond.com','B B');
INSERT INTO c_user (c_user_login,c_user_pass,c_user_e_mail,c_user_full_name) VALUES ('employee1','s2e5dssdE2asd21','e1@cond.com','E 1');
INSERT INTO c_user (c_user_login,c_user_pass,c_user_e_mail,c_user_full_name) VALUES ('employee2','s2e5a1E45sd21','e2@cond.com','E 2');

INSERT INTO condominium_owner(condominium_owner_id,owner_id,condominium_id,stair,door) VALUES (1,1,2,3,2);
INSERT INTO condominium_owner(condominium_owner_id,owner_id,condominium_id,stair,door) VALUES (2,2,1,1,4);
INSERT INTO condominium_owner(condominium_owner_id,owner_id,condominium_id,stair,door) VALUES (3,1,2,3,1);

INSERT INTO notification(condominium_owner_id,notification_message,notification_date,notification_answer,notification_completed) VALUES (2,'Téves','1990-02-20','Rendben',1);
INSERT INTO notification(condominium_owner_id,notification_message,notification_date,notification_answer,notification_completed) VALUES (1,'Megjavult','1991-09-30','Oké',1);
INSERT INTO notification(condominium_owner_id,notification_message,notification_date,notification_answer,notification_completed) VALUES (3,'Még Rossz','1988-04-11','Sietünk',0);

INSERT INTO repair_notification(repair_id,notification_id) VALUES (2,3);
INSERT INTO repair_notification(repair_id,notification_id) VALUES (1,2);
INSERT INTO repair_notification(repair_id,notification_id) VALUES (1,3);