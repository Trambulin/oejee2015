CREATE TABLE account (
	account_id INTEGER NOT NULL,
	first_name CHARACTER VARYING(40) NOT NULL,
	last_name CHARACTER VARYING(40) NOT NULL,
	name CHARACTER VARYING(15) NOT NULL,
	email CHARACTER VARYING(60) NOT NULL,
	password CHARACTER VARYING(60) NOT NULL,
	is_activated BOOLEAN NOT NULL,
	warn_count INTEGER NOT NULL,
	ban_expire DATE, -- NULL if not banned, 0000-00-00 if banned permanently
	CONSTRAINT PK_ACCOUNT_ID PRIMARY KEY (account_id)
);
ALTER TABLE account OWNER TO postgres;
CREATE UNIQUE INDEX I_ACCOUNT_EMAIL ON account USING btree (email);

CREATE TABLE attribute (
	attribute_id INTEGER NOT NULL,
	attribute_name CHARACTER VARYING(20) NOT NULL,
	CONSTRAINT PK_ATTRIBUTE_ID PRIMARY KEY (attribute_id)
);
ALTER TABLE attribute OWNER TO postgres;

CREATE TABLE character_race (
	race_id INTEGER NOT NULL,
	name CHARACTER VARYING(20) NOT NULL,
	bonus_attribute INTEGER, -- the attribute's ID for which the bonus is counted
	bonus_amount REAL,
	CONSTRAINT PK_CHARACTER_RACE_ID PRIMARY KEY (race_id),
	CONSTRAINT FK_BONUS_ATTRIBUTE_ID FOREIGN KEY (bonus_attribute)
	  REFERENCES attribute (attribute_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);
ALTER TABLE character_race OWNER TO postgres;
CREATE UNIQUE INDEX I_CHARACTER_RACE_NAME ON character_race USING btree (name);

CREATE TABLE character_base (
	character_id INTEGER NOT NULL,
	name CHARACTER VARYING(15) NOT NULL,
	experience INTEGER NOT NULL,
	race_id INTEGER NOT NULL,
	is_male BOOLEAN NOT NULL,
	money_amount INTEGER NOT NULL,
	account_id INTEGER NOT NULL,
	CONSTRAINT PK_CHARACTER_ID PRIMARY KEY (character_id),
	CONSTRAINT FK_RACE_ID FOREIGN KEY (race_id)
	  REFERENCES character_race (race_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT,
	CONSTRAINT FK_ACCOUNT_ID FOREIGN KEY (account_id)
	  REFERENCES account (account_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);
ALTER TABLE character_base OWNER TO postgres;
CREATE INDEX I_CHARACTER_BASE_RACE_ID ON character_base (race_id);


CREATE TABLE character_attribute (
	character_id INTEGER NOT NULL,
	attribute_id INTEGER NOT NULL,
	amount REAL NOT NULL,
	CONSTRAINT PK_CHARACTER_ATTRIBUTE_ID PRIMARY KEY (character_id, attribute_id), -- composite PK
	CONSTRAINT FK_CHARACTER_ID FOREIGN KEY (character_id)
	  REFERENCES character_base (character_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT,
	CONSTRAINT FK_ATTRIBUTE_ID FOREIGN KEY (attribute_id)
	  REFERENCES attribute (attribute_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);
ALTER TABLE character_attribute OWNER TO postgres;

CREATE TABLE activity (
	activity_id INTEGER NOT NULL,
	character_id INTEGER NOT NULL,
	login_date DATE NOT NULL,
	logout_date DATE, -- can be set later (when the actual logout happens)
	ip_address CHARACTER VARYING(39) NOT NULL, -- IPv4 (15), IPv6 (39) with separators
	CONSTRAINT PK_ACTIVITY_ID PRIMARY KEY (activity_id),
	CONSTRAINT FK_CHARACTER_ID FOREIGN KEY (character_id)
	  REFERENCES character_base (character_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);
ALTER TABLE activity OWNER TO postgres;
CREATE INDEX I_ACTIVITY_LOGIN_DATE ON activity (login_date);