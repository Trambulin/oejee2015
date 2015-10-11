CREATE TABLE c_type(
	c_type_id SERIAL NOT NULL,
	c_type_name CHARACTER VARYING(40) NOT NULL,
	CONSTRAINT PK_C_TYPE_ID PRIMARY KEY (c_type_id)
);

ALTER TABLE c_type OWNER TO postgres;

CREATE TABLE condominium(
	condominium_id SERIAL NOT NULL,
	condominium_loc CHARACTER VARYING(100) NOT NULL,	--location
	condominium_floors INTEGER NOT NULL,
	condominium_build_year DATE NOT NULL,
	condominium_type INTEGER NOT NULL,
	CONSTRAINT PK_CONDOMINIUM_ID PRIMARY KEY (condominium_id),
	CONSTRAINT FK_CONDOMINIUM_TYPE FOREIGN KEY (condominium_type)
		REFERENCES c_type (c_type_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);
ALTER TABLE condominium OWNER TO postgres;

CREATE TABLE c_owner(
	c_owner_id SERIAL NOT NULL,
	c_owner_name CHARACTER VARYING(120) NOT NULL,
	c_owner_birt_date DATE,
	c_owner_gender CHARACTER VARYING(1) NOT NULL,-- m: male, f:female
	c_owner_phone CHARACTER VARYING(12) NOT NULL,
	c_owner_e_mail CHARACTER VARYING(60) NOT NULL,
	CONSTRAINT PK_OWNER_ID PRIMARY KEY (c_owner_id)
);
ALTER TABLE c_owner OWNER TO postgres;

CREATE TABLE repair(
	repair_id SERIAL NOT NULL,
	repair_con_id INTEGER NOT NULL,	--condominium_id
	repair_description TEXT,
	repair_price REAL NOT NULL,
	repair_date DATE NOT NULL,
	CONSTRAINT PK_REPAIR_ID PRIMARY KEY (repair_id),
	CONSTRAINT FK_REPAIR_CONDOMINIUM FOREIGN KEY (repair_con_id)
		REFERENCES condominium (condominium_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);
ALTER TABLE repair OWNER TO postgres;

CREATE TABLE c_user(
		c_user_login CHARACTER VARYING(50) NOT NULL,
		c_user_pass CHARACTER VARYING(200) NOT NULL,
		c_user_e_mail CHARACTER VARYING(100) NOT NULL,
		c_user_full_name CHARACTER VARYING(150) NOT NULL,
		CONSTRAINT PK_C_USER_ID PRIMARY KEY(c_user_login)
);
ALTER TABLE c_user OWNER TO postgres;

CREATE TABLE condominium_owner(
		condominium_owner_id INTEGER NOT NULL,
		owner_id INTEGER NOT NULL,
		condominium_id INTEGER NOT NULL, 
		stair INTEGER NOT NULL,
		door INTEGER NOT NULL,
		CONSTRAINT PK_CONDOMINIUM_OWNER_ID PRIMARY KEY(condominium_owner_id)
);
ALTER TABLE condominium_owner OWNER TO postgres;

CREATE TABLE notification(
		notification_id SERIAL NOT NULL,
		condominium_owner_id INTEGER NOT NULL, --fk_condominium_owner
		notification_message CHARACTER VARYING(200) NOT NULL,
		notification_date DATE NOT NULL,
		notification_answer CHARACTER VARYING(150) NOT NULL,
		notification_completed INTEGER NOT NULL,
		CONSTRAINT PK_NOTIFICATION_ID PRIMARY KEY(notification_id),
		CONSTRAINT FK_NOTIFICATION FOREIGN KEY (condominium_owner_id)
		REFERENCES condominium_owner (condominium_owner_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);
ALTER TABLE notification OWNER TO postgres;

CREATE TABLE repair_notification(
		repair_notification_id SERIAL NOT NULL,
		repair_id INTEGER NOT NULL,
		notification_id INTEGER NOT NULL,
		CONSTRAINT PK_REPAIR_NOTIFICATION_ID PRIMARY KEY (repair_notification_id),
		CONSTRAINT FK_NOTIFICATION FOREIGN KEY (repair_id)
		REFERENCES repair (repair_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT,
		CONSTRAINT FK_REPAIR FOREIGN KEY (notification_id)
		REFERENCES notification (notification_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);
ALTER TABLE repair_notification OWNER TO postgres;