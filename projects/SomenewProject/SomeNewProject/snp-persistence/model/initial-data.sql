-- INSERT INTO customer_role
INSERT INTO customer_role (customer_role_name) VALUES ('administrator');
INSERT INTO customer_role (customer_role_name) VALUES ('customer');

-- INSERT INTO category
INSERT INTO category (category_name) VALUES ('thriller');
INSERT INTO category (category_name) VALUES ('fantasy');
INSERT INTO category (category_name) VALUES ('comic');

-- INSERT INTO product
INSERT INTO product (product_serial, product_name, product_category) VALUES ('ASD001', 'Product 1', 1);
INSERT INTO product (product_serial, product_name, product_category) VALUES ('ASD002', 'Product 2', 2);
INSERT INTO product (product_serial, product_name, product_category) VALUES ('ASD003', 'Product 3', 3);

-- INSERT INTO customer
INSERT INTO customer (customer_role_id, customer_name, customer_password) VALUES (2, 'Bognár Márton', 'babd4a84418fb04015ac773f7459727c');
INSERT INTO customer (customer_role_id, customer_name, customer_password) VALUES (2, 'Takács Dániel', 'babd4a84418fb04015ac773f7459727c');

-- INSERT INTO attribute
INSERT INTO attribute (attribute_product_id, attribute_name, attribute_value) VALUES (1, 'title', 'Dearly Devoted Dexter');
INSERT INTO attribute (attribute_product_id, attribute_name, attribute_value) VALUES (1, 'author', 'Jeff Lindsay');
INSERT INTO attribute (attribute_product_id, attribute_name, attribute_value) VALUES (1, 'stock', '10');
INSERT INTO attribute (attribute_product_id, attribute_name, attribute_value) VALUES (2, 'title', 'Darkly Dreaming Dexter');
INSERT INTO attribute (attribute_product_id, attribute_name, attribute_value) VALUES (2, 'author', 'Jeff Lindsay');
INSERT INTO attribute (attribute_product_id, attribute_name, attribute_value) VALUES (2, 'stock', '20');
INSERT INTO attribute (attribute_product_id, attribute_name, attribute_value) VALUES (3, 'title', 'Dexter in the Dark');
INSERT INTO attribute (attribute_product_id, attribute_name, attribute_value) VALUES (3, 'author', 'Jeff Lindsay');
INSERT INTO attribute (attribute_product_id, attribute_name, attribute_value) VALUES (3, 'stock', '30');

-- INSERT INTO product_order
INSERT INTO product_order (product_order_number, product_order_customer_id, product_order_quantity, product_order_product_id, product_order_delivered) VALUES ('ON0001', 1, 1, 1, false);
INSERT INTO product_order (product_order_number, product_order_customer_id, product_order_quantity, product_order_product_id, product_order_delivered) VALUES ('ON0002', 1, 2, 1, true);
INSERT INTO product_order (product_order_number, product_order_customer_id, product_order_quantity, product_order_product_id, product_order_delivered) VALUES ('ON0003', 2, 3, 1, false);