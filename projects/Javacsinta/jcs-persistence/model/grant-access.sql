GRANT SELECT, INSERT, UPDATE, DELETE ON pancake, address,payment_method,customer,employee,delivery_status,order_detail,order_header TO javacsinta_role;

GRANT USAGE, SELECT, UPDATE ON pancake_pancake_id_seq TO javacsinta_role;
GRANT USAGE, SELECT, UPDATE ON address_address_id_seq TO javacsinta_role;
GRANT USAGE, SELECT, UPDATE ON payment_method_payment_method_id_seq TO javacsinta_role;
GRANT USAGE, SELECT, UPDATE ON customer_customer_id_seq TO javacsinta_role;
GRANT USAGE, SELECT, UPDATE ON employee_employee_id_seq TO javacsinta_role;
GRANT USAGE, SELECT, UPDATE ON delivery_status_delivery_status_id_seq TO javacsinta_role;
GRANT USAGE, SELECT, UPDATE ON order_header_order_header_id_seq TO javacsinta_role;
GRANT USAGE, SELECT, UPDATE ON order_detail_order_detail_id_seq TO javacsinta_role;