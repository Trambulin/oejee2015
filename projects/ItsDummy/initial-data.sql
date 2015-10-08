INSERT INTO brand (brand_id, brand_name) VALUES (0, 'BMW'); 

INSERT INTO cartype (cartype_id, car_brand_id, model) VALUES (0, 0,'x6');

INSERT INTO car (car_id, car_cartype_id, production_date, fuel, color, price) VALUES (0, 0, '2013.06.13', 'diesel', 'Black (Matt)', 399999);

INSERT INTO customer (customer_id, name, login_name, passwd) VALUES (0, 'Fontos László', 'Laceee', 'hardpasswd');

INSERT INTO cust_contact (cust_contact_id, cust_contact_customer_id, email, phone_number, mail_address) VALUES (0, 0, 'lachee@quest.ru', '666', 'München Gralstrasse 3');

INSERT INTO rent (rent_id, rent_car_id, rent_customer_id, rent_date, rent_expiration) VALUES (0, 0, 0, '2015.10.04', '2016.03.04');
