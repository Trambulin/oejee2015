-- Termék kategóriák (szándékosan kicsit kurtább a lista mint az életben)
INSERT INTO product_type (pdt_id, pdt_name) VALUES (0, U&'Billenty\0171zet');
INSERT INTO product_type (pdt_id, pdt_name) VALUES (1, U&'Eg\00E9r');
INSERT INTO product_type (pdt_id, pdt_name) VALUES (2, U&'Joystick');
INSERT INTO product_type (pdt_id, pdt_name) VALUES (3, U&'Mem\00F3ria - RAM');
INSERT INTO product_type (pdt_id, pdt_name) VALUES (4, U&'Mem\00F3ria k\00E1rtya, pendrive');
INSERT INTO product_type (pdt_id, pdt_name) VALUES (5, U&'Vide\00F3k\00E1rtya');

--INSERT INTO product_type (pdt_id, pdt_name) VALUES (6, 'Alaplap');
--INSERT INTO product_type (pdt_id, pdt_name) VALUES (7, 'Hangsz\00F3r\00F3, fejhallgat\00F3');
--INSERT INTO product_type (pdt_id, pdt_name) VALUES (8, 'Merevlemez');
--INSERT INTO product_type (pdt_id, pdt_name) VALUES (9, 'Processzor');


-- Gyártók (minden kategóriára legalább kettő)
INSERT INTO manufacturer (mf_id, mf_name, mf_telephone) VALUES (0, 'Gigabyte', '555-8080-321'); --alaplap, bill., egér
INSERT INTO manufacturer (mf_id, mf_name, mf_telephone) VALUES (1, 'MSI', '555-4463-111'); --alaplap, videókártya
INSERT INTO manufacturer (mf_id, mf_name, mf_telephone) VALUES (2, 'Logitech Inc.', '555-2245-556'); --bill, egér, joystick
INSERT INTO manufacturer (mf_id, mf_name, mf_telephone) VALUES (3, 'Genius', '555-8641-473'); --bill, egér, joystick
INSERT INTO manufacturer (mf_id, mf_name, mf_telephone) VALUES (4, 'Microsoft Corporation', '555-9974-446'); --joystick, bill, egér
INSERT INTO manufacturer (mf_id, mf_name, mf_telephone) VALUES (5, 'Canyon', '555-2135-231'); --hangsz.
INSERT INTO manufacturer (mf_id, mf_name, mf_telephone) VALUES (6, 'Sennheiser', '555-2323-249'); --hangsz.
INSERT INTO manufacturer (mf_id, mf_name, mf_telephone) VALUES (7, 'Corsair', '555-7755-135'); --mem., bill, eg\00E9r, SSD
INSERT INTO manufacturer (mf_id, mf_name, mf_telephone) VALUES (8, 'OCZ', '555-6454-554'); --mem, SSD
INSERT INTO manufacturer (mf_id, mf_name, mf_telephone) VALUES (9, 'Kingston', '555-4486-886'); --memóriák
INSERT INTO manufacturer (mf_id, mf_name, mf_telephone) VALUES (10, 'Intel Corporation', '555-2213-112'); --cpu
INSERT INTO manufacturer (mf_id, mf_name, mf_telephone) VALUES (11, 'AMD, Inc.', '555-2334-331'); -- cpu
INSERT INTO manufacturer (mf_id, mf_name, mf_telephone) VALUES (12, 'ASUSTec Computer Inc.', '555-3377-543'); -- videókártya


-- Bolti áruk
INSERT INTO supplier (sup_product_type, sup_name, sup_description, sup_warranty, sup_price, sup_manufacturer_id, sup_shipping_days)
	VALUES(0, U&'LOGITECH Keyboard K120 USB HUN fekete billenty\0171zet', '', 24, 3810, 2, 1);
INSERT INTO supplier (sup_product_type, sup_name, sup_description, sup_warranty, sup_price, sup_manufacturer_id, sup_shipping_days)
	VALUES(0, U&'GENIUS Imperator GX gamer USB HUN fekete billenty\0171zet', '', 24, 8941, 3, 1);
INSERT INTO supplier (sup_product_type, sup_name, sup_description, sup_warranty, sup_price, sup_manufacturer_id, sup_shipping_days)
	VALUES(0, U&'GIGABYTE GK-K6150 Slim HUN USB fekete billenty\0171zet', '', 24, 2540, 0, 1);
INSERT INTO supplier (sup_product_type, sup_name, sup_description, sup_warranty, sup_price, sup_manufacturer_id, sup_shipping_days)
	VALUES(0, U&'MICROSOFT Wired Keyboard 200 hun USB fekete billenty\0171zet', '', 36, 4318, 4, 1);
INSERT INTO supplier (sup_product_type, sup_name, sup_description, sup_warranty, sup_price, sup_manufacturer_id, sup_shipping_days)
	VALUES(1, U&'CORSAIR Raptor M30 optikai Gamer 4000DPI USB fekete eg\00E9r', '', 36, 12243, 7, 1);
INSERT INTO supplier (sup_product_type, sup_name, sup_description, sup_warranty, sup_price, sup_manufacturer_id, sup_shipping_days)
	VALUES(1, U&'LOGITECH G100S Gaming 2500dpi optikai USB eg\00E9r', '', 26, 12040, 2, 1);
INSERT INTO supplier (sup_product_type, sup_name, sup_description, sup_warranty, sup_price, sup_manufacturer_id, sup_shipping_days)
	VALUES(1, U&'GIGABYTE GM-M6880-V2 1600dpi gamer l\00E9zeres fekete USB eg\00E9r', '', 26, 4115, 0, 1);
INSERT INTO supplier (sup_product_type, sup_name, sup_description, sup_warranty, sup_price, sup_manufacturer_id, sup_shipping_days)
	VALUES(2, U&'LOGITECH F710 Rumblepad r\00E1di\00F3s vibra feedback gamepad', '', 26, 13132, 2, 1);
INSERT INTO supplier (sup_product_type, sup_name, sup_description, sup_warranty, sup_price, sup_manufacturer_id, sup_shipping_days)
	VALUES(2, U&'LOGITECH Driving Force GT Force Feedback korm\00E1ny PC/Playstation3', '', 26, 42062, 2, 1);
INSERT INTO supplier (sup_product_type, sup_name, sup_description, sup_warranty, sup_price, sup_manufacturer_id, sup_shipping_days)
	VALUES(3, U&'CORSAIR DDR3 2048MB 1333MHz VS2GB1333D3 cl9 desktop ram', '', 60, 5055, 7, 1);
INSERT INTO supplier (sup_product_type, sup_name, sup_description, sup_warranty, sup_price, sup_manufacturer_id, sup_shipping_days)
	VALUES(3, U&'KINGSTON DDR3L 8192MB 1600Mhz KTL-TC316L/8G 1,35V Select LENOVO desktop ram', '', 60, 14732, 9, 1);
INSERT INTO supplier (sup_product_type, sup_name, sup_description, sup_warranty, sup_price, sup_manufacturer_id, sup_shipping_days)
	VALUES(4, U&'CORSAIR 16GB Flash Survivor Stealth CMFSS3-16GB f\00E9mtokos USB3.0 pendrive', '', 60, 10795, 7, 1);
INSERT INTO supplier (sup_product_type, sup_name, sup_description, sup_warranty, sup_price, sup_manufacturer_id, sup_shipping_days)
	VALUES(4, U&'KINGSTON 1.0TB HyperX Predator DTHXP30/1TB USB3.0 pendrive', '', 60, 202413, 9, 3);
INSERT INTO supplier (sup_product_type, sup_name, sup_description, sup_warranty, sup_price, sup_manufacturer_id, sup_shipping_days)
	VALUES(4, U&'KINGSTON 8GB DT100G3/8GB USB3.0 pendrive', '', 36, 2184, 9, 1);
INSERT INTO supplier (sup_product_type, sup_name, sup_description, sup_warranty, sup_price, sup_manufacturer_id, sup_shipping_days)
	VALUES(5, U&'ASUS AMD Radeon R7 370 4096MB D5 STRIX-R7370-DC2OC-4GD5-GAMING PCI-E3.0 videok\00E1rtya', '', 36, 57658, 12, 1);
INSERT INTO supplier (sup_product_type, sup_name, sup_description, sup_warranty, sup_price, sup_manufacturer_id, sup_shipping_days)
	VALUES(5, U&'MSI AMD Radeon R9 FURY X 4096MB HBM R9 FURY X 4G PCI-E3.0 videok\00E1rtya', '', 36, 230683, 1, 2);
INSERT INTO supplier (sup_product_type, sup_name, sup_description, sup_warranty, sup_price, sup_manufacturer_id, sup_shipping_days)
	VALUES(5, U&'GIGABYTE AMD Radeon R9 270X 2048MB D5 GV-R927XOC-2GD PCI-E3.0 videok\00E1rtya', '', 36, 55804, 0, 1);
INSERT INTO supplier (sup_product_type, sup_name, sup_description, sup_warranty, sup_price, sup_manufacturer_id, sup_shipping_days)
	VALUES(5, U&'ASUS GeForce GTX TITAN X 12288MB D5 GTXTITANX-12GD5 PCI-E3.0 videok\00E1rtya', '', 36, 345567, 12, 2);
INSERT INTO supplier (sup_product_type, sup_name, sup_description, sup_warranty, sup_price, sup_manufacturer_id, sup_shipping_days)
	VALUES(5, U&'GIGABYTE GeForce GTX960 2048MB D5 GV-N960WF2OC-2GD PCI-E3.0 videok\00E1rtya', '', 36, 62306, 0, 1);
INSERT INTO supplier (sup_product_type, sup_name, sup_description, sup_warranty, sup_price, sup_manufacturer_id, sup_shipping_days)
	VALUES(5, U&'MSI GeForce GT730 2048MB D3 N730K-2GD3/OC PCI-E3.0 videok\00E1rtya', '', 36, 20980, 1, 1);
-- Ezek valós árak, gyoran írjuk át egy olcsóbb nagykerárra
UPDATE supplier SET sup_price = sup_price / 1.25;


-- Vásárlók (jelszó: password)
INSERT INTO customer (ctm_email, ctm_password, ctm_joined, ctm_lastname, ctm_firstname, ctm_address, ctm_telephone)
	VALUES ('balazs@vbstudio.hu', '5f4dcc3b5aa765d61d8327deb882cf99', '2015-10-13', U&'Vecsey', U&'Bal\00E1zs', '1234 Budapest, Balage u. 8', '0630-123-4567');
INSERT INTO customer (ctm_email, ctm_password, ctm_joined, ctm_lastname, ctm_firstname, ctm_address, ctm_telephone)
	VALUES ('david@vbstudio.hu', '5f4dcc3b5aa765d61d8327deb882cf99', '2015-12-03', U&'N\00E9meth', U&'D\00E1vid', '1234 Budapest, David street 10', '0630-123-4567');
INSERT INTO customer (ctm_email, ctm_password, ctm_joined, ctm_lastname, ctm_firstname, ctm_address, ctm_telephone)
	VALUES ('randomguy@vbstudio.hu', '5f4dcc3b5aa765d61d8327deb882cf99', '2015-11-11', U&'H\00E1t', U&'Izs\00E1k', '1234 Budapest, Isaac street 12', '0630-123-4567');
INSERT INTO customer (ctm_email, ctm_password, ctm_joined, ctm_lastname, ctm_firstname, ctm_address, ctm_telephone)
	VALUES ('dr.isex@vbstudio.hu', '5f4dcc3b5aa765d61d8327deb882cf99', '2015-09-20', U&'Dr', U&'Isaacs', '1234 Budapest, Red street 14', '0630-123-4567');

	
-- Beszállító termékei
-- Az ID ugyanaz, az árat átszámolja kisekerárba, a lokális példányszám pedig ötletszerűen.
INSERT INTO storage (stg_pid, stg_price, stg_quantity)
SELECT sup_id as stg_pid, (sup_price * 1.25) as stg_price, (random() * 4) as stg_quantity FROM supplier;


-- Vásárlások
-- Kezdeti adatok tesztelésre. A vásárló és termék ID hardcode-olva, de magát az árat meg a megérkezést automatikusan húzza be.
INSERT INTO orders (ord_pid, ord_cid, ord_price, ord_shipped_on, ord_shipment_due)
SELECT g.stg_id as ord_pid, 2 as ord_cid, g.stg_price as ord_price, CURRENT_DATE as ord_shipped_on, CURRENT_DATE + s.sup_shipping_days as ord_shipment_due
FROM storage g LEFT JOIN supplier s ON g.stg_id=s.sup_id WHERE g.stg_id = 1;

INSERT INTO orders (ord_pid, ord_cid, ord_price, ord_shipped_on, ord_shipment_due)
SELECT g.stg_id as ord_pid, 2 as ord_cid, g.stg_price as ord_price, CURRENT_DATE as ord_shipped_on, CURRENT_DATE + s.sup_shipping_days as ord_shipment_due
FROM storage g LEFT JOIN supplier s ON g.stg_id=s.sup_id WHERE g.stg_id = 6;

INSERT INTO orders (ord_pid, ord_cid, ord_price, ord_shipped_on, ord_shipment_due)
SELECT g.stg_id as ord_pid, 3 as ord_cid, g.stg_price as ord_price, CURRENT_DATE as ord_shipped_on, CURRENT_DATE + s.sup_shipping_days as ord_shipment_due
FROM storage g LEFT JOIN supplier s ON g.stg_id=s.sup_id WHERE g.stg_id = 10;

INSERT INTO orders (ord_pid, ord_cid, ord_price, ord_shipped_on, ord_shipment_due)
SELECT g.stg_id as ord_pid, 3 as ord_cid, g.stg_price as ord_price, CURRENT_DATE as ord_shipped_on, CURRENT_DATE + s.sup_shipping_days as ord_shipment_due
FROM storage g LEFT JOIN supplier s ON g.stg_id=s.sup_id WHERE g.stg_id = 13;

INSERT INTO orders (ord_pid, ord_cid, ord_price, ord_shipped_on, ord_shipment_due)
SELECT g.stg_id as ord_pid, 4 as ord_cid, g.stg_price as ord_price, CURRENT_DATE as ord_shipped_on, CURRENT_DATE + s.sup_shipping_days as ord_shipment_due
FROM storage g LEFT JOIN supplier s ON g.stg_id=s.sup_id WHERE g.stg_id = 18;