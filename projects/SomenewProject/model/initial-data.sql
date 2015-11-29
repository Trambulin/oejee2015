-- INSERT INTO customer_role
INSERT INTO customer_role (customer_role_name, customer_role_create_date) VALUES ('administrator', CURRENT_DATE);
INSERT INTO customer_role (customer_role_name, customer_role_create_date) VALUES ('customer', CURRENT_DATE);

-- INSERT INTO product
INSERT INTO product (product_serial, product_name, product_create_date) VALUES ('ASD001', 'Product 1', CURRENT_DATE);
INSERT INTO product (product_serial, product_name, product_create_date) VALUES ('ASD002', 'Product 2', CURRENT_DATE);
INSERT INTO product (product_serial, product_name, product_create_date) VALUES ('ASD003', 'Product 3', CURRENT_DATE);

-- INSERT INTO customer
INSERT INTO customer (customer_role_id, customer_name, customer_password, customer_create_date) VALUES (2, 'Bognár Márton', 'babd4a84418fb04015ac773f7459727c', CURRENT_DATE);
INSERT INTO customer (customer_role_id, customer_name, customer_password, customer_create_date) VALUES (2, 'Takács Dániel', 'babd4a84418fb04015ac773f7459727c', CURRENT_DATE);

-- INSERT INTO attribute
INSERT INTO attribute (attribute_product_id, attribute_name, attribute_value, attribute_create_date) VALUES (1, 'title', 'Dearly Devoted Dexter', CURRENT_DATE);
INSERT INTO attribute (attribute_product_id, attribute_name, attribute_value, attribute_create_date) VALUES (1, 'author', 'Jeff Lindsay', CURRENT_DATE);
INSERT INTO attribute (attribute_product_id, attribute_name, attribute_value, attribute_create_date) VALUES (1, 'stock', '10', CURRENT_DATE);
INSERT INTO attribute (attribute_product_id, attribute_name, attribute_value, attribute_create_date) VALUES (2, 'title', 'Darkly Dreaming Dexter', CURRENT_DATE);
INSERT INTO attribute (attribute_product_id, attribute_name, attribute_value, attribute_create_date) VALUES (2, 'author', 'Jeff Lindsay', CURRENT_DATE);
INSERT INTO attribute (attribute_product_id, attribute_name, attribute_value, attribute_create_date) VALUES (2, 'stock', '20', CURRENT_DATE);
INSERT INTO attribute (attribute_product_id, attribute_name, attribute_value, attribute_create_date) VALUES (3, 'title', 'Dexter in the Dark', CURRENT_DATE);
INSERT INTO attribute (attribute_product_id, attribute_name, attribute_value, attribute_create_date) VALUES (3, 'author', 'Jeff Lindsay', CURRENT_DATE);
INSERT INTO attribute (attribute_product_id, attribute_name, attribute_value, attribute_create_date) VALUES (3, 'stock', '30', CURRENT_DATE);

-- INSERT INTO category
INSERT INTO category (category_name, category_create_date) VALUES ('thriller', CURRENT_DATE);
INSERT INTO category (category_name, category_create_date) VALUES ('fantasy', CURRENT_DATE);
INSERT INTO category (category_name, category_create_date) VALUES ('comic', CURRENT_DATE);

-- INSERT INTO product_category
INSERT INTO product_category (product_category_product_id, product_category_category_id) VALUES (1, 1);
INSERT INTO product_category (product_category_product_id, product_category_category_id) VALUES (2, 1);
INSERT INTO product_category (product_category_product_id, product_category_category_id) VALUES (3, 1);

-- INSERT INTO product_order
INSERT INTO product_order (product_order_number, product_order_customer_id, product_order_quantity, product_order_product_id, product_order_delivered) VALUES ('ON0001', 1, 1, 1, false);
INSERT INTO product_order (product_order_number, product_order_customer_id, product_order_quantity, product_order_product_id, product_order_delivered) VALUES ('ON0002', 1, 2, 1, true);
INSERT INTO product_order (product_order_number, product_order_customer_id, product_order_quantity, product_order_product_id, product_order_delivered) VALUES ('ON0003', 2, 3, 1, false);