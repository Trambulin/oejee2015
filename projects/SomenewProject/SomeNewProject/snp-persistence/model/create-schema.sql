CREATE TABLE customer_role (
	customer_role_id SERIAL NOT NULL,
	customer_role_name CHARACTER VARYING(255) NOT NULL,
	CONSTRAINT PK_customer_ROLE_ID PRIMARY KEY (customer_role_id)
);
ALTER TABLE customer_role OWNER TO postgres;

CREATE TABLE category (
 	category_id SERIAL NOT NULL,
 	category_name CHARACTER VARYING(255) NOT NULL,
 	CONSTRAINT PK_CATEGORY_ID PRIMARY KEY (category_id)
);
ALTER TABLE category OWNER TO postgres;

CREATE TABLE product (
	product_id SERIAL NOT NULL,
	product_serial CHARACTER VARYING(255) NOT NULL,
	product_name CHARACTER VARYING(255) NOT NULL,
	product_category INTEGER NOT NULL,
	CONSTRAINT PK_PRODUCT_ID PRIMARY KEY (product_id),
	CONSTRAINT FK_PRODUCT_CATEGORY FOREIGN KEY (product_category) REFERENCES category (category_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);
ALTER TABLE product OWNER TO postgres;
CREATE UNIQUE INDEX UI_PRODUCT_SERIAL ON product USING btree (product_serial);

CREATE TABLE customer (
	customer_id SERIAL NOT NULL,
	customer_role_id INTEGER NOT NULL,
	customer_name CHARACTER VARYING(255) NOT NULL,
	customer_password CHARACTER VARYING(32) NOT NULL,
	CONSTRAINT PK_customer_ID PRIMARY KEY (customer_id),
	CONSTRAINT FK_customer_ROLE FOREIGN KEY (customer_role_id) REFERENCES customer_role (customer_role_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);
ALTER TABLE customer OWNER TO postgres;

CREATE TABLE attribute (
	attribute_id SERIAL NOT NULL,
	attribute_product_id INTEGER NOT NULL,
	attribute_name CHARACTER VARYING(255) NOT NULL,
	attribute_value CHARACTER VARYING(255) NOT NULL,
	CONSTRAINT PK_ATTRIBUTE_ID PRIMARY KEY (attribute_id),
	CONSTRAINT FK_ATTRIBUTE_PRODUCT_ID FOREIGN KEY (attribute_product_id) REFERENCES product (product_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);
ALTER TABLE attribute OWNER TO postgres;

CREATE TABLE product_order (
	product_order_id SERIAL NOT NULL,
	product_order_number CHARACTER VARYING(255) NOT NULL,
	product_order_customer_id INTEGER NOT NULL,
	product_order_quantity INTEGER NOT NULL,
	product_order_product_id INTEGER NOT NULL,
	product_order_delivered BOOLEAN NOT NULL DEFAULT FALSE,
	CONSTRAINT PK_product_order_ID PRIMARY KEY (product_order_id),
	CONSTRAINT FK_PRODUCT_ID FOREIGN KEY (product_order_product_id) REFERENCES product (product_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT,
	CONSTRAINT FK_PRODUCT_ORDER_CUSTOMER_ID FOREIGN KEY (product_order_customer_id) REFERENCES customer (customer_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);
ALTER TABLE product_order OWNER TO postgres;
CREATE UNIQUE INDEX UI_product_order_NUMBER ON product_order USING btree (product_order_number);
