CREATE TABLE brand (
	brand_id INTEGER NOT NULL,
	brand_name CHARACTER VARYING(100) NOT NULL,
	CONSTRAINT PK_BRAND_ID PRIMARY KEY (brand_id)
);

ALTER TABLE brand OWNER TO postgres;

CREATE TABLE cartype (
	cartype_id INTEGER NOT NULL,
	cartype_brand_id INTEGER NOT NULL,
	cartype_model CHARACTER VARYING(100) NOT NULL,
	CONSTRAINT PK_CARTYPE_ID PRIMARY KEY (cartype_id),
	CONSTRAINT FK_CARBRAND_BRAND FOREIGN KEY (cartype_brand_id)
	  REFERENCES brand (brand_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);

ALTER TABLE cartype OWNER TO postgres;

CREATE INDEX I_CARTYPE_MODEL ON cartype (cartype_model);

CREATE TABLE car (
	car_id INTEGER NOT NULL,
	car_cartype_id INTEGER NOT NULL,
	car_production_date DATE NOT NULL,
	car_fuel CHARACTER VARYING(100) NOT NULL,
	car_color CHARACTER VARYING(100) NOT NULL,
	car_price REAL NOT NULL,
	CONSTRAINT PK_CAR_ID PRIMARY KEY (car_id),
	CONSTRAINT FK_CAR_CARTYPE FOREIGN KEY (car_cartype_id)
	  REFERENCES cartype (cartype_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);

ALTER TABLE car OWNER TO postgres;

CREATE INDEX I_CAR_PRODUCTION_DATE ON car (car_production_date);

CREATE TABLE customer (
	customer_id INTEGER NOT NULL,
	customer_name CHARACTER VARYING(100) NOT NULL,
	customer_login_name CHARACTER VARYING(100) NOT NULL,
	customer_passwd CHARACTER VARYING(100) NOT NULL,
	CONSTRAINT PK_CUSTOMER_ID PRIMARY KEY (customer_id)
);

ALTER TABLE customer OWNER TO postgres;

CREATE UNIQUE INDEX UI_CUSTOMER_NAME ON customer USING btree (customer_login_name);

CREATE TABLE cust_contact (
	cust_contact_id INTEGER NOT NULL,
	cust_contact_customer_id INTEGER NOT NULL,
	email CHARACTER VARYING(100) NOT NULL,
	phone_number CHARACTER VARYING(20),
	mail_address CHARACTER VARYING(150),
	CONSTRAINT PK_CUST_CONTACT PRIMARY KEY (cust_contact_id),
	CONSTRAINT FK_CUST_CONTACT_CUSTOMER FOREIGN KEY (cust_contact_customer_id)
	  REFERENCES customer (customer_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);

ALTER TABLE cust_contact OWNER TO postgres;

CREATE UNIQUE INDEX UI_CUST_CONTACT_EMAIL ON cust_contact USING btree (email);

CREATE TABLE rent (
	rent_id SERIAL NOT NULL,
	rent_car_id INTEGER NOT NULL,
	rent_customer_id INTEGER NOT NULL,
	rent_date DATE NOT NULL,
	rent_expiration DATE,
	CONSTRAINT PK_RENT_ID PRIMARY KEY (rent_id),
	CONSTRAINT FK_RENT_CAR FOREIGN KEY (rent_car_id)
	  REFERENCES car (car_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT,
	CONSTRAINT FK_RENT_CUSTOMER FOREIGN KEY (rent_customer_id)
	  REFERENCES customer (customer_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);

ALTER TABLE rent OWNER TO postgres;

CREATE INDEX I_RENT_RENT_EXPIRATION ON rent (rent_expiration NULLS FIRST);

CREATE VIEW rentdetail AS
	SELECT
		ROW_NUMBER() OVER() AS rentdetail_id,
		rent_customer_id AS rentdetail_customer_id,
		car_cartype_id AS rentdetail_cartype_id,
		car_price AS rentdetail_price,
		DATE_TRUNC('year', car_production_date) AS rentdetail_year     
	FROM rent
		INNER JOIN car ON ( rent_car_id = car_id ) 
	WHERE ( 1 = 1 );
	
ALTER TABLE rentdetail OWNER TO postgres;