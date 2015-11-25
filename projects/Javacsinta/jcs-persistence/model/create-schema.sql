CREATE TABLE pancake (
	pancake_id SERIAL NOT NULL,
	pancake_name CHARACTER VARYING(100) NOT NULL,
	pancake_price INTEGER NOT NULL,
	pancake_description CHARACTER VARYING(100),
	CONSTRAINT PK_PANCAKE_ID PRIMARY KEY (pancake_id)
);

CREATE UNIQUE INDEX UQI_PANCAKE_NAME ON pancake (pancake_name);
CREATE INDEX IX_PANCAKE_PRICE ON pancake (pancake_price);
	
ALTER TABLE pancake OWNER TO postgres;

CREATE TABLE address (
	address_id SERIAL NOT NULL,
	address_postcode INTEGER NOT NULL,
	address_street CHARACTER VARYING(100) NOT NULL,
	address_door CHARACTER VARYING(100) NOT NULL,
	CONSTRAINT PK_ADDRESS_ID PRIMARY KEY (address_id)
	
);
CREATE INDEX IX_POSTCODE ON address (address_postcode);

ALTER TABLE address OWNER TO postgres;

CREATE TABLE payment_method (
	payment_method_id SERIAL NOT NULL,
	payment_method_description CHARACTER VARYING(100) NOT NULL,
	CONSTRAINT PK_PAYMENT_METHOD_ID PRIMARY KEY (payment_method_id)
	
);

ALTER TABLE payment_method OWNER TO postgres;

CREATE TABLE customer (
	customer_id SERIAL NOT NULL,
	customer_address_id INTEGER NOT NULL,
	customer_name CHARACTER VARYING(100) NOT NULL,
	customer_phone CHARACTER VARYING(100) NOT NULL,
	customer_email CHARACTER VARYING(100) NOT NULL,
	customer_other_details CHARACTER VARYING(100),
	CONSTRAINT PK_CUSTOMER_ID PRIMARY KEY (customer_id),
	CONSTRAINT FK_CUSTOMER_ADDRESS FOREIGN KEY (customer_address_id)
	  REFERENCES address (address_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);

CREATE UNIQUE INDEX UQI_CUSTOMER_EMAIL ON customer (customer_email);

ALTER TABLE customer OWNER TO postgres;

CREATE TABLE employee (
	employee_id SERIAL NOT NULL,
	employee_address_id INTEGER NOT NULL,
	employee_name CHARACTER VARYING(100) NOT NULL,
	employee_phone CHARACTER VARYING(100) NOT NULL,
	employee_other_details CHARACTER VARYING(100),
	CONSTRAINT PK_EMPLOYEE_ID PRIMARY KEY (employee_id),
	CONSTRAINT FK_EMPLOYEE_ADDRESS FOREIGN KEY (employee_address_id)
	  REFERENCES address (address_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);

ALTER TABLE employee OWNER TO postgres;

CREATE TABLE delivery_status (
	delivery_status_id SERIAL NOT NULL,
	delivery_status_description CHARACTER VARYING(100) NOT NULL,
	CONSTRAINT PK_DELIVERY_STATUS_ID PRIMARY KEY (delivery_status_id)
	
);

ALTER TABLE delivery_status OWNER TO postgres;



CREATE TABLE order_header (
	order_header_id SERIAL NOT NULL,
	order_header_customer_id INTEGER NOT NULL,
	order_header_employee_id INTEGER NOT NULL,
	order_header_delivery_status_id INTEGER NOT NULL,
	order_header_total_price REAL NOT NULL,
	order_header_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
	order_header_payment_method_id INTEGER NOT NULL,
	CONSTRAINT PK_order_header_ID PRIMARY KEY (order_header_id),
	CONSTRAINT FK_order_header_CUSTOMER FOREIGN KEY (order_header_customer_id)
	  REFERENCES customer (customer_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT,
	CONSTRAINT FK_order_header_EMPLOYEE FOREIGN KEY (order_header_employee_id)
	  REFERENCES employee (employee_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT,
	CONSTRAINT FK_order_header_DELIVERY FOREIGN KEY (order_header_delivery_status_id)
	  REFERENCES delivery_status (delivery_status_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT,
	CONSTRAINT FK_order_header_payment_method FOREIGN KEY (order_header_payment_method_id)
	  REFERENCES payment_method (payment_method_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);

ALTER TABLE order_header OWNER TO postgres;

CREATE TABLE order_item (
	order_item_id SERIAL NOT NULL,
	order_item_pancake_id INTEGER NOT NULL,
	order_item_order_header_id INTEGER NOT NULL,
	order_item_amount INTEGER NOT NULL,
	order_item_total_price REAL NOT NULL,
	CONSTRAINT PK_order_item_ID PRIMARY KEY (order_item_id),
	CONSTRAINT FK_order_item_PANCAKE FOREIGN KEY (order_item_pancake_id)
	  REFERENCES pancake (pancake_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT,
	CONSTRAINT FK_order_item_HEADER FOREIGN KEY (order_item_order_header_id)
	  REFERENCES order_header (order_header_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);

ALTER TABLE order_item OWNER TO postgres;

CREATE VIEW order_detail AS
	SELECT
		ROW_NUMBER() OVER() AS order_detail_id,
		order_item_pancake_id AS order_detail_pancake_id,
		order_header_customer_id AS order_detail_customer_id,
		order_item_amount AS order_detail_amount,
		DATE_TRUNC('month', order_header_date) AS order_detail_date     
	FROM order_item
		INNER JOIN order_header ON ( order_item_order_header_id = order_header_id ) 
	WHERE ( 1 = 1 );
	
ALTER TABLE order_detail OWNER TO postgres;