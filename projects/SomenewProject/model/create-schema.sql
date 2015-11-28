CREATE TABLE user_role (
	user_role_id SERIAL NOT NULL,
	user_role_name CHARACTER VARYING(255) NOT NULL,
	user_role_create_date DATE NOT NULL,
	CONSTRAINT PK_USER_ROLE_ID PRIMARY KEY (user_role_id)
);
ALTER TABLE user_role OWNER TO postgres;


CREATE TABLE product (
	product_id SERIAL NOT NULL,
	product_serial CHARACTER VARYING(255) NOT NULL,
	product_name CHARACTER VARYING(255) NOT NULL,
	product_create_date DATE NOT NULL,
	CONSTRAINT PK_PRODUCT_ID PRIMARY KEY (product_id)
);
ALTER TABLE product OWNER TO postgres;
CREATE UNIQUE INDEX UI_PRODUCT_SERIAL ON product USING btree (product_serial);

CREATE TABLE user (
	user_id SERIAL NOT NULL,
	user_role_id INTEGER NOT NULL,
	user_username CHARACTER VARYING(255) NOT NULL,
	user_password CHARACTER VARYING(32) NOT NULL,
	user_create_date DATE NOT NULL,
	CONSTRAINT PK_USER_ID PRIMARY KEY (user_id),
	CONSTRAINT FK_USER_ROLE FOREIGN KEY (user_role_id) REFERENCES user_role (role_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);
ALTER TABLE user OWNER TO postgres;

CREATE TABLE attribute (
	attribute_id SERIAL NOT NULL,
	attribute_product_id INTEGER NOT NULL,
	attribute_name CHARACTER VARYING(255) NOT NULL,
	attribute_value CHARACTER VARYING(255) NOT NULL,
	attribute_create_date DATE NOT NULL,
	CONSTRAINT PK_ATTRIBUTE_ID PRIMARY KEY (attribute_id),
	CONSTRAINT FK_ATTRIBUTE_PRODUCT_ID FOREIGN KEY (attribute_product_id) REFERENCES product (product_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);
ALTER TABLE attribute OWNER TO postgres;


CREATE TABLE category (
	category_id SERIAL NOT NULL,
	category_name CHARACTER VARYING(255) NOT NULL,
	category_create_date DATE NOT NULL,
	CONSTRAINT PK_CATEGORY_ID PRIMARY KEY (category_id)
);
ALTER TABLE category OWNER TO postgres;

CREATE TABLE product_category (
	product_category_id SERIAL NOT NULL,
	product_category_product_id INTEGER NOT NULL,
	product_category_category_id INTEGER NOT NULL,
	CONSTRAINT PK_PRODUCT_CATEGORY_ID PRIMARY KEY (product_category_id)
	CONSTRAINT FK_PRODUCT_CATEGORY FOREIGN KEY (product_category_product_id) REFERENCES product (product_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT,
	CONSTRAINT FK_CATEGORY FOREIGN KEY (product_category_category_id) REFERENCES category (category_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT,
);
ALTER TABLE product_category OWNER TO postgres;

CREATE TABLE order (
	order_id SERIAL NOT NULL,
	order_number INTEGER NOT NULL,
	order_quantity INTEGER NOT NULL,
	order_product_id INTEGER NOT NULL,
	order_delivered BOOLEAN NOT NULL DEFAULT FALSE,
	CONSTRAINT PK_ORDER_ID PRIMARY KEY (order_id),
	CONSTRAINT FK_PRODUCT_ID FOREIGN KEY (order_product_id) REFERENCES product (product_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);
ALTER TABLE order OWNER TO postgres;
CREATE UNIQUE INDEX UI_ORDER_NUMBER ON order USING btree (order_number);
