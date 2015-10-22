-- Termék kategóriák (szándékosan kicsit kurtább a lista mint az életben)
INSERT INTO product_type (pdt_id, pdt_name) VALUES (1, 'Alaplap');
INSERT INTO product_type (pdt_id, pdt_name) VALUES (2, 'Billentyűzet');
INSERT INTO product_type (pdt_id, pdt_name) VALUES (3, 'Egér');
INSERT INTO product_type (pdt_id, pdt_name) VALUES (4, 'Joystick');
INSERT INTO product_type (pdt_id, pdt_name) VALUES (5, 'Hangszóró, fejhallgató');
INSERT INTO product_type (pdt_id, pdt_name) VALUES (6, 'Memória - RAM');
INSERT INTO product_type (pdt_id, pdt_name) VALUES (7, 'Memória kártya, pendrive');
INSERT INTO product_type (pdt_id, pdt_name) VALUES (8, 'Merevlemez');
INSERT INTO product_type (pdt_id, pdt_name) VALUES (9, 'Processzor');
INSERT INTO product_type (pdt_id, pdt_name) VALUES (10, 'Videókártya');

-- Gyártók (minden kategóriára legalább kettő)
INSERT INTO manufacturer (mf_id, mf_name, mf_telephone) VALUES (1, 'Gigabyte', "555-8080-321"); --alaplap, bill., egér
INSERT INTO manufacturer (mf_id, mf_name, mf_telephone) VALUES (2, 'MSI', "555-8080-321"); --alaplap, videókártya
INSERT INTO manufacturer (mf_id, mf_name, mf_telephone) VALUES (3, 'Logitech Inc.', "555-8080-321"); --bill, egér, joystick
INSERT INTO manufacturer (mf_id, mf_name, mf_telephone) VALUES (4, 'Genius', "555-8080-321"); --bill, egér, joystick
INSERT INTO manufacturer (mf_id, mf_name, mf_telephone) VALUES (5, 'Microsoft Corporation', "555-8080-321"); --joystick, bill, egér
INSERT INTO manufacturer (mf_id, mf_name, mf_telephone) VALUES (6, 'Canyon', "555-8080-321"); --hangsz.
INSERT INTO manufacturer (mf_id, mf_name, mf_telephone) VALUES (7, 'Sennheiser', "555-8080-321"); --hangsz.
INSERT INTO manufacturer (mf_id, mf_name, mf_telephone) VALUES (8, 'Corsair', "555-8080-321"); --mem., bill, egér, SSD
INSERT INTO manufacturer (mf_id, mf_name, mf_telephone) VALUES (9, 'OCZ', "555-8080-321"); --mem, SSD
INSERT INTO manufacturer (mf_id, mf_name, mf_telephone) VALUES (10, 'Kingstone', "555-8080-321"); --memóriák
INSERT INTO manufacturer (mf_id, mf_name, mf_telephone) VALUES (11, 'Intel Corporation', "555-8080-321"); --cpu
INSERT INTO manufacturer (mf_id, mf_name, mf_telephone) VALUES (12, 'AMD, Inc.', "555-8080-321"); -- cpu
INSERT INTO manufacturer (mf_id, mf_name, mf_telephone) VALUES (13, 'ASUSTec Computer Inc.', "555-8080-321"); -- videókártya

-- Beszállító termékei
-- hamarosan

-- Bolti áruk
-- hamarosan

-- Vásárlók (jelszó: password)
INSERT INTO customer (ctm_email, ctm_password, ctm_joined, ctm_lastname, ctm_firstname, ctm_address, ctm_telephone)
	VALUES ("admin@vbstudio.hu", "5f4dcc3b5aa765d61d8327deb882cf99", "2015-10-13", "Vecsey", "Balázs", "1234 Budapest, Balage u. 8", "0630-123-4567");


-- minták a maradék táblákhoz
--INSERT INTO storage (stg_id, stg_price, stg_quantity, stg_quantity_reserved) VALUES();
--INSERT INTO supplier (sup_id SERIAL, sup_product_type, sup_name, sup_description, sup_warranty, sup_price, spr_manufacturer_id, spr_shipping_days) VALUES();
