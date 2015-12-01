--INSTERT INTO account
INSERT INTO account (first_name, last_name, name, email, password, is_activated, warn_count, ban_expire)  
	VALUES ('Bence', 'Ditrich', 'DBence', 'benoemail@jeezusom.com', 'nagyontitkos', TRUE, 0, NULL);
INSERT INTO account (first_name, last_name, name, email, password, is_activated, warn_count, ban_expire) 
	VALUES ('Márton', 'Bognár', 'BMarci', 'marciemail@jeezusom.com', 'ezisnagyontitkos', TRUE, 3, NULL);
INSERT INTO account (first_name, last_name, name, email, password, is_activated, warn_count, ban_expire) 
	VALUES ('Dániel', 'Takács', 'TDani', 'daniemail@jeezusom.com', 'szintennagyontitkos', TRUE, 1, '2015/12/24');


--INSTERT INTO attribute
INSERT INTO attribute (attribute_name) 
	VALUES ('Health');
INSERT INTO attribute (attribute_name) 
	VALUES ('Mana');
INSERT INTO attribute (attribute_name) 
	VALUES ('Strength');
INSERT INTO attribute (attribute_name) 
	VALUES ('Magic');
	

	
--INSTERT INTO character_race
INSERT INTO character_race (name, bonus_attribute, bonus_amount) 
	VALUES ('Human', 3, 100);
INSERT INTO character_race (name, bonus_attribute, bonus_amount) 
	VALUES ('Centaur', 1, 200);
INSERT INTO character_race (name, bonus_attribute, bonus_amount) 
	VALUES ('Harpy', 2, 100);
INSERT INTO character_race (name, bonus_attribute, bonus_amount) 
	VALUES ('Satyr', 4, 50);
	
	
--INSTERT INTO character_base
INSERT INTO character_base (name, experience, race_id, is_male, money_amount, account_id) 
	VALUES ('Beno', 100000, 1, TRUE, 5000, 1);
INSERT INTO character_base (name, experience, race_id, is_male, money_amount, account_id) 
	VALUES ('Namaron', 100000, 2, TRUE, 5000, 2);
INSERT INTO character_base (name, experience, race_id, is_male, money_amount, account_id) 
	VALUES ('Wainwright', 40000, 4, TRUE, 5000, 3);

	
--INSTERT INTO character_attribute
INSERT INTO character_attribute (character_id, attribute_id, amount) 
	VALUES (1, 1, 1000);
INSERT INTO character_attribute (character_id, attribute_id, amount) 
	VALUES (1, 2, 1000);
INSERT INTO character_attribute (character_id, attribute_id, amount) 
	VALUES (1, 3, 1100);
INSERT INTO character_attribute (character_id, attribute_id, amount) 
	VALUES (1, 4, 1000);
INSERT INTO character_attribute (character_id, attribute_id, amount) 
	VALUES (2, 1, 1200);
INSERT INTO character_attribute (character_id, attribute_id, amount) 
	VALUES (2, 2, 1000);
INSERT INTO character_attribute (character_id, attribute_id, amount) 
	VALUES (2, 3, 1000);
INSERT INTO character_attribute (character_id, attribute_id, amount) 
	VALUES (2, 4, 1000);
INSERT INTO character_attribute (character_id, attribute_id, amount) 
	VALUES (3, 1, 1200);
INSERT INTO character_attribute (character_id, attribute_id, amount) 
	VALUES (3, 2, 1000);
INSERT INTO character_attribute (character_id, attribute_id, amount) 
	VALUES (3, 3, 1000);
INSERT INTO character_attribute (character_id, attribute_id, amount) 
	VALUES (3, 4, 1000);

--INSTERT INTO activity 
INSERT INTO activity (character_id, login_date, logout_date, ip_address) 
	VALUES (1, '2015/10/15', NULL, '192.168.72.2');
INSERT INTO activity (character_id, login_date, logout_date, ip_address) 
	VALUES (2, '2015/10/14', '2015/10/15', '192.168.72.3');
INSERT INTO activity (character_id, login_date, logout_date, ip_address) 
	VALUES (3, '2015/10/13', '2015/10/14', '192.168.72.4');
