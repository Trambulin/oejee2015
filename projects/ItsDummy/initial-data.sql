INSERT INTO brand (brand_id, brand_name) VALUES (0, 'BMW'); 

INSERT INTO cartype (cartype_id, car_brand_id, type_of_car, model) VALUES (0, 0, 'crossover','x6');

INSERT INTO car (car_id, car_cartype_id, production_date, fuel, color, price) VALUES (2, 'HISTORICAL');

INSERT INTO customer (customer_id, registration_date, name, login_name, email, passwd) VALUES (0, '2015.10.04', 'Fontos László', 'Laceee', 'lece@lacee.ru', 'hardpasswd');

INSERT INTO rent (rent_id, rent_car_id, rent_customer_id, rent_date) VALUES (0, 0, 0, '2015.10.04');
