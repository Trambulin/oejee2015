INSERT INTO brand (brand_id, brand_name) VALUES (0, 'BMW');
INSERT INTO brand (brand_id, brand_name) VALUES (1, 'AUDI');  
INSERT INTO brand (brand_id, brand_name) VALUES (2, 'OPEL');
INSERT INTO brand (brand_id, brand_name) VALUES (3, 'TOYOTA');
INSERT INTO brand (brand_id, brand_name) VALUES (4, 'SUZUKI');
INSERT INTO brand (brand_id, brand_name) VALUES (5, 'HONDA');
INSERT INTO brand (brand_id, brand_name) VALUES (6, 'MERCEDES-BENZ');
INSERT INTO brand (brand_id, brand_name) VALUES (7, 'LAMBORGHINI');
INSERT INTO brand (brand_id, brand_name) VALUES (8, 'TESLA');
INSERT INTO brand (brand_id, brand_name) VALUES (9, 'VOLKSWAGEN');
INSERT INTO brand (brand_id, brand_name) VALUES (10, 'PORSHE');

INSERT INTO cartype (cartype_id, cartype_brand_id, cartype_model) VALUES (0, 0,'x6');
INSERT INTO cartype (cartype_id, cartype_brand_id, cartype_model) VALUES (1, 1,'TT');

INSERT INTO car (car_id, car_cartype_id, car_production_date, car_fuel, car_color, car_price) VALUES (0, 0, '2013.06.13', 'diesel', 'Black (Matt)', 399999);
INSERT INTO car (car_id, car_cartype_id, car_production_date, car_fuel, car_color, car_price) VALUES (1, 1, '2012.02.22', 'diesel', 'Black (Matt)', 99999);

INSERT INTO customer (customer_id, customer_name, customer_login_name, customer_passwd) VALUES (0, 'Fontos László', 'Laceee', 'hardpasswd');
INSERT INTO customer (customer_id, customer_name, customer_login_name, customer_passwd) VALUES (1, 'Kérdés Zoltán', 'Zoleee', 'passwd');

INSERT INTO cust_contact (cust_contact_id, cust_contact_customer_id, email, phone_number, mail_address) VALUES (0, 0, 'lachee@quest.ru', '666', 'München Gralstrasse 3');
INSERT INTO cust_contact (cust_contact_id, cust_contact_customer_id, email, phone_number, mail_address) VALUES (1, 1, 'zoleee@check.ru', '777', 'München Gralstrasse 4');

INSERT INTO rent (rent_id, rent_car_id, rent_customer_id, rent_date, rent_expiration) VALUES (0, 0, 0, '2015.10.04', '2016.03.04');
INSERT INTO rent (rent_id, rent_car_id, rent_customer_id, rent_date, rent_expiration) VALUES (1, 1, 1, '2015.10.19', '2016.03.19');
