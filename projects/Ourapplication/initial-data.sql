INSERT INTO c_type (c_type_id,c_type_name) VALUES (1,'flat');
INSERT INTO c_type (c_type_id,c_type_name) VALUES (2,'brick building');

INSERT INTO condominium (condominium_id,condominium_loc,condominium_floors,condominium_build_year,condominium_type) VALUES(1,'Budapest XIII. Váci út 121.',3,'1971-07-13',1);
INSERT INTO condominium (condominium_id,condominium_loc,condominium_floors,condominium_build_year,condominium_type) VALUES(2,'Budapest XII. Kossuth út 12.',2,'1951-07-13',2);
INSERT INTO condominium (condominium_id,condominium_loc,condominium_floors,condominium_build_year,condominium_type) VALUES(3,'Budapest XI. Jókai út 10.',6,'1941-07-13',1);

INSERT INTO c_owner (c_owner_id,c_owner_name,c_owner_birt_date,c_owner_gender, c_owner_phone,c_owner_e_mail) VALUES(1,'Nagy Nándor','1981-07-13','m','06301254578','n@n.com'); 
INSERT INTO c_owner (c_owner_id,c_owner_name,c_owner_birt_date,c_owner_gender, c_owner_phone,c_owner_e_mail) VALUES(2,'Nagy Angéla','1991-07-13','f','06701254578','n@a.com'); 
INSERT INTO c_owner (c_owner_id,c_owner_name,c_owner_birt_date,c_owner_gender, c_owner_phone,c_owner_e_mail) VALUES(3,'Kis Károly','1981-07-13','m','06201254578','n@k.com'); 

INSERT INTO repair (repair_id,repair_con_id,repair_description,repair_price,repair_date) VALUES (1,1,'desc1',123000,'2005-07-13');
INSERT INTO repair (repair_id,repair_con_id,repair_description,repair_price,repair_date) VALUES (2,2,'desc2',90000,'2005-07-13');
INSERT INTO repair (repair_id,repair_con_id,repair_description,repair_price,repair_date) VALUES (3,1,'desc3',123700,'2005-07-13');

INSERT INTO c_user (c_user_login,c_user_pass,c_user_e_mail,c_user_full_name) VALUES ('boss','s2e5a1E2asd21','boss@cond.com','B B');
INSERT INTO c_user (c_user_login,c_user_pass,c_user_e_mail,c_user_full_name) VALUES ('employee1','s2e5dssdE2asd21','e1@cond.com','E 1');
INSERT INTO c_user (c_user_login,c_user_pass,c_user_e_mail,c_user_full_name) VALUES ('employee2','s2e5a1E45sd21','e2@cond.com','E 2');
