INSERT INTO pancake (pancake_id, pancake_name,pancake_price,pancake_description) VALUES (1, 'CSOKIS PALACSINTA',1000,''); 
INSERT INTO pancake (pancake_id, pancake_name,pancake_price,pancake_description) VALUES (2, 'TUROS PALACSINTA',1200,'');
INSERT INTO pancake (pancake_id, pancake_name,pancake_price,pancake_description) VALUES (3, 'BARACKLEKVAROS PALACSINTA',1500,'');

INSERT INTO address (address_id, address_postcode,address_street,address_door) VALUES (1, 1037,'KUNIGUNDA UTJA 35.','2B');
INSERT INTO address (address_id, address_postcode,address_street,address_door) VALUES (2, 1117,'IRINYI JOZSEF UTCA 42.','808');

INSERT INTO payment_method (payment_method_id,payment_method_description) VALUES (0, 'CASH');
INSERT INTO payment_method (payment_method_id,payment_method_description) VALUES (1, 'CARD');

INSERT INTO customer (customer_id,customer_address_id,customer_name,customer_phone,customer_email,customer_other_details) VALUES (1, 1,'KOVACS JANOS','0630-5650257','kovacs.janos@gmail.com','');

INSERT INTO employee (employee_id,employee_address_id,employee_name,employee_phone,employee_other_details) VALUES (1, 2,'NAGY JOZSEF','0670-43-53-187','');

INSERT INTO delivery_status (delivery_status_id,delivery_status_description) VALUES (0, 'InProgress');
INSERT INTO delivery_status (delivery_status_id,delivery_status_description) VALUES (1, 'Delivered');


INSERT INTO order_header (order_header_id,order_header_customer_id,order_header_employee_id,order_header_delivery_status_id,order_header_total_price,order_header_date,order_header_payment_method_id) VALUES (1,1,1,1,3200,TO_TIMESTAMP(1406956934),1);
INSERT INTO order_header (order_header_id,order_header_customer_id,order_header_employee_id,order_header_delivery_status_id,order_header_total_price,order_header_date,order_header_payment_method_id) VALUES (2,1,1,1,4500,TO_TIMESTAMP(1443221607),1);

INSERT INTO order_item (order_item_id,order_item_pancake_id,order_item_order_header_id,order_item_amount,order_item_total_price) VALUES (1, 1,1,2,2000);
INSERT INTO order_item (order_item_id,order_item_pancake_id,order_item_order_header_id,order_item_amount,order_item_total_price) VALUES (2, 2,1,1,1200);
INSERT INTO order_item (order_item_id,order_item_pancake_id,order_item_order_header_id,order_item_amount,order_item_total_price) VALUES (3, 1,2,3,3000);
INSERT INTO order_item (order_item_id,order_item_pancake_id,order_item_order_header_id,order_item_amount,order_item_total_price) VALUES (4, 3,2,1,1500);

