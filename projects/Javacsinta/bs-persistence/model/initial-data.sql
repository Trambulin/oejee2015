INSERT INTO pancake (pancake_id, pancake_name,pancake_price,pancake_description) VALUES (1, 'CSOKIS PALACSINTA',1000,''); 
INSERT INTO pancake (pancake_id, pancake_name,pancake_price,pancake_description) VALUES (2, 'TUROS PALACSINTA',1200,'');

INSERT INTO address (address_id, address_postcode,address_street,address_door) VALUES (1, 1037,'KUNIGUNDA UTJA 35.','2B');
INSERT INTO address (address_id, address_postcode,address_street,address_door) VALUES (2, 1117,'IRINYI JOZSEF UTCA 42.','808');

INSERT INTO payment_method (payment_method_id,payment_method_description) VALUES (1, 'KESZPENZ');
INSERT INTO payment_method (payment_method_id,payment_method_description) VALUES (2, 'KARTYA');

INSERT INTO customer (customer_id,customer_address_id,customer_payment_method_id,customer_name,customer_phone,customer_email,customer_other_details) VALUES (1, 1,1,'KOVACS JANOS','0630-5650257','kovacs.janos@gmail.com','');

INSERT INTO employee (employee_id,employee_address_id,employee_name,employee_phone,employee_other_details) VALUES (1, 2,'NAGY JOZSEF','0670-43-53-187','');

INSERT INTO delivery_status (delivery_status_id,delivery_status_description) VALUES (1, 'FUGGOBEN');
INSERT INTO delivery_status (delivery_status_id,delivery_status_description) VALUES (2, 'SIKERES');
INSERT INTO delivery_status (delivery_status_id,delivery_status_description) VALUES (3, 'SIKERTELEN');

INSERT INTO order_master (order_master_id,order_master_customer_id,order_master_employee_id,order_master_delivery_status_id,order_master_total_price) VALUES (1,1,1,1,3200);

INSERT INTO order_detail (order_detail_id,order_detail_pancake_id,order_detail_order_master_id,order_detail_amount,order_detail_total_price) VALUES (1, 1,1,2,2000);
INSERT INTO order_detail (order_detail_id,order_detail_pancake_id,order_detail_order_master_id,order_detail_amount,order_detail_total_price) VALUES (2, 2,1,1,1200);


