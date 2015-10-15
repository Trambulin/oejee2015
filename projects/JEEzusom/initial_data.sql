--INSTERT INTO account
INSERT INTO account (account_id, first_name, last_name, name, email, password, is_activated, warn_count, ban_expire) 
	VALUES (1, "Bence", "Ditrich", DBence, benoemail@jeezusom.com, "nagyontitkos", TRUE, 0, NULL);
INSERT INTO account (account_id, first_name, last_name, name, email, password, is_activated, warn_count, ban_expire) 
	VALUES (1, "Márton", "Bognár", BMarci, marciemail@jeezusom.com, "ezisnagyontitkos", TRUE, 3, NULL)
INSERT INTO account (account_id, first_name, last_name, name, email, password, is_activated, warn_count, ban_expire) 
	VALUES (1, "Dániel", "Takács", TDani, daniemail@jeezusom.com, "szintennagyontitkos", TRUE, 1, 2015-12-24)

--INSTERT INTO character_base
INSERT INTO character_base (character_id, name, experience, race_id, is_male, money_amount, account_id) 
	VALUES (1, "Beno", 100000, 1, TRUE, 5000, 1);
INSERT INTO character_base (character_id, name, experience, race_id, is_male, money_amount, account_id) 
	VALUES (2, "Namaron", 100000, 2, TRUE, 5000, 2);
INSERT INTO character_base (character_id, name, experience, race_id, is_male, money_amount, account_id) 
	VALUES (3, "Ditrich", 80000, 2, TRUE, 5000, 3);
INSERT INTO character_base (character_id, name, experience, race_id, is_male, money_amount, account_id) 
	VALUES (4, "Wainwright", 40000, 4, TRUE, 5000, 4);

	
--INSTERT INTO character_race
INSERT INTO character_race (race_id, name, bonus_attribute, bonus_amount) 
	VALUES (1, "Human", 3, 100);
INSERT INTO character_race (race_id, name, bonus_attribute, bonus_amount) 
	VALUES (2, "Centaur", 1, 200);
INSERT INTO character_race (race_id, name, bonus_attribute, bonus_amount) 
	VALUES (3, "Harpy", 2, 100);
INSERT INTO character_race (race_id, name, bonus_attribute, bonus_amount) 
	VALUES (4, "Satyr", 4, 50);
	

--INSTERT INTO attribute
INSERT INTO attribute (attribute_id, attribute_name) 
	VALUES (1, "Health");
INSERT INTO attribute (attribute_id, attribute_name) 
	VALUES (2, "Mana");
INSERT INTO attribute (attribute_id, attribute_name) 
	VALUES (3, "Strength");
INSERT INTO attribute (attribute_id, attribute_name) 
	VALUES (4, "Magic");
	

	
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
INSERT INTO character_attribute (character_id, attribute_id, amount) 
	VALUES (4, 1, 1000);
INSERT INTO character_attribute (character_id, attribute_id, amount) 
	VALUES (4, 2, 1000);
INSERT INTO character_attribute (character_id, attribute_id, amount) 
	VALUES (4, 3, 1000);
INSERT INTO character_attribute (character_id, attribute_id, amount) 
	VALUES (4, 4, 1050);

--INSTERT INTO activity 
INSERT INTO activity (activity_id, character_id, login_date, logout_date, ip_address) 
	VALUES (1, 1, 2015-10-15, NULL, "192.168.72.2");
INSERT INTO activity (activity_id, character_id, login_date, logout_date, ip_address) 
	VALUES (2, 2, 2015-10-14, 2015-10-15, "192.168.72.3");
INSERT INTO activity (activity_id, character_id, login_date, logout_date, ip_address) 
	VALUES (3, 3, 2015-10-13, 2015-10-14, "192.168.72.4");
INSERT INTO activity (activity_id, character_id, login_date, logout_date, ip_address) 
	VALUES (4, 4, 2015-10-12, 2015-10-13, "192.168.72.5");