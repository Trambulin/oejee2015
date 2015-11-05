-- Termék kategóriák (szándékosan kicsit kurtább a lista mint az életben)
INSERT INTO product_type (pdt_id, pdt_name) VALUES (0, 'Billentyűzet');
INSERT INTO product_type (pdt_id, pdt_name) VALUES (1, 'Egér');
INSERT INTO product_type (pdt_id, pdt_name) VALUES (2, 'Joystick');
INSERT INTO product_type (pdt_id, pdt_name) VALUES (3, 'Memória - RAM');
INSERT INTO product_type (pdt_id, pdt_name) VALUES (4, 'Memória kártya, pendrive');
INSERT INTO product_type (pdt_id, pdt_name) VALUES (5, 'Videókártya');

--INSERT INTO product_type (pdt_id, pdt_name) VALUES (6, 'Alaplap');
--INSERT INTO product_type (pdt_id, pdt_name) VALUES (7, 'Hangszóró, fejhallgató');
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
INSERT INTO manufacturer (mf_id, mf_name, mf_telephone) VALUES (7, 'Corsair', '555-7755-135'); --mem., bill, egér, SSD
INSERT INTO manufacturer (mf_id, mf_name, mf_telephone) VALUES (8, 'OCZ', '555-6454-554'); --mem, SSD
INSERT INTO manufacturer (mf_id, mf_name, mf_telephone) VALUES (9, 'Kingston', '555-4486-886'); --memóriák
INSERT INTO manufacturer (mf_id, mf_name, mf_telephone) VALUES (10, 'Intel Corporation', '555-2213-112'); --cpu
INSERT INTO manufacturer (mf_id, mf_name, mf_telephone) VALUES (11, 'AMD, Inc.', '555-2334-331'); -- cpu
INSERT INTO manufacturer (mf_id, mf_name, mf_telephone) VALUES (12, 'ASUSTec Computer Inc.', '555-3377-543'); -- videókártya


-- Bolti áruk
INSERT INTO supplier (sup_product_type, sup_name, sup_description, sup_warranty, sup_price, spr_manufacturer_id, spr_shipping_days)
	VALUES(0, 'LOGITECH Keyboard K120 USB HUN fekete billentyűzet', '', 24, 3810, 2, 1);
INSERT INTO supplier (sup_product_type, sup_name, sup_description, sup_warranty, sup_price, spr_manufacturer_id, spr_shipping_days)
	VALUES(0, 'GENIUS Imperator GX gamer USB HUN fekete billentyűzet', '', 24, 8941, 3, 1);
INSERT INTO supplier (sup_product_type, sup_name, sup_description, sup_warranty, sup_price, spr_manufacturer_id, spr_shipping_days)
	VALUES(0, 'GIGABYTE GK-K6150 Slim HUN USB fekete billentyűzet', '', 24, 2540, 0, 1);
INSERT INTO supplier (sup_product_type, sup_name, sup_description, sup_warranty, sup_price, spr_manufacturer_id, spr_shipping_days)
	VALUES(0, 'MICROSOFT Wired Keyboard 200 hun USB fekete billentyűzet', '', 36, 4318, 4, 1);
INSERT INTO supplier (sup_product_type, sup_name, sup_description, sup_warranty, sup_price, spr_manufacturer_id, spr_shipping_days)
	VALUES(1, 'CORSAIR Raptor M30 optikai Gamer 4000DPI USB fekete egér', '', 36, 12243, 7, 1);
INSERT INTO supplier (sup_product_type, sup_name, sup_description, sup_warranty, sup_price, spr_manufacturer_id, spr_shipping_days)
	VALUES(1, 'LOGITECH G100S Gaming 2500dpi optikai USB egér', '', 26, 12040, 2, 1);
INSERT INTO supplier (sup_product_type, sup_name, sup_description, sup_warranty, sup_price, spr_manufacturer_id, spr_shipping_days)
	VALUES(1, 'GIGABYTE GM-M6880-V2 1600dpi gamer lézeres fekete USB egér', '', 26, 4115, 0, 1);
INSERT INTO supplier (sup_product_type, sup_name, sup_description, sup_warranty, sup_price, spr_manufacturer_id, spr_shipping_days)
	VALUES(2, 'LOGITECH F710 Rumblepad rádiós vibra feedback gamepad', '', 26, 13132, 2, 1);
INSERT INTO supplier (sup_product_type, sup_name, sup_description, sup_warranty, sup_price, spr_manufacturer_id, spr_shipping_days)
	VALUES(2, 'LOGITECH Driving Force GT Force Feedback kormány PC/Playstation3', '', 26, 42062, 2, 1);
INSERT INTO supplier (sup_product_type, sup_name, sup_description, sup_warranty, sup_price, spr_manufacturer_id, spr_shipping_days)
	VALUES(3, 'CORSAIR DDR3 2048MB 1333MHz VS2GB1333D3 cl9 desktop ram', '', 60, 5055, 7, 1);
INSERT INTO supplier (sup_product_type, sup_name, sup_description, sup_warranty, sup_price, spr_manufacturer_id, spr_shipping_days)
	VALUES(3, 'KINGSTON DDR3L 8192MB 1600Mhz KTL-TC316L/8G 1,35V Select LENOVO desktop ram', '', 60, 14732, 9, 1);
INSERT INTO supplier (sup_product_type, sup_name, sup_description, sup_warranty, sup_price, spr_manufacturer_id, spr_shipping_days)
	VALUES(4, 'CORSAIR 16GB Flash Survivor Stealth CMFSS3-16GB fémtokos USB3.0 pendrive', '', 60, 10795, 7, 1);
INSERT INTO supplier (sup_product_type, sup_name, sup_description, sup_warranty, sup_price, spr_manufacturer_id, spr_shipping_days)
	VALUES(4, 'KINGSTON 1.0TB HyperX Predator DTHXP30/1TB USB3.0 pendrive', '', 60, 202413, 9, 2);
INSERT INTO supplier (sup_product_type, sup_name, sup_description, sup_warranty, sup_price, spr_manufacturer_id, spr_shipping_days)
	VALUES(4, 'KINGSTON 8GB DT100G3/8GB USB3.0 pendrive', '', 36, 2184, 9, 1);
INSERT INTO supplier (sup_product_type, sup_name, sup_description, sup_warranty, sup_price, spr_manufacturer_id, spr_shipping_days)
	VALUES(5, 'ASUS AMD Radeon R7 370 4096MB D5 STRIX-R7370-DC2OC-4GD5-GAMING PCI-E3.0 videokártya', '', 36, 57658, 12, 1);
INSERT INTO supplier (sup_product_type, sup_name, sup_description, sup_warranty, sup_price, spr_manufacturer_id, spr_shipping_days)
	VALUES(5, 'MSI AMD Radeon R9 FURY X 4096MB HBM R9 FURY X 4G PCI-E3.0 videokártya', '', 36, 230683, 1, 2);
INSERT INTO supplier (sup_product_type, sup_name, sup_description, sup_warranty, sup_price, spr_manufacturer_id, spr_shipping_days)
	VALUES(5, 'GIGABYTE AMD Radeon R9 270X 2048MB D5 GV-R927XOC-2GD PCI-E3.0 videokártya', '', 36, 55804, 0, 1);
INSERT INTO supplier (sup_product_type, sup_name, sup_description, sup_warranty, sup_price, spr_manufacturer_id, spr_shipping_days)
	VALUES(5, 'ASUS GeForce GTX TITAN X 12288MB D5 GTXTITANX-12GD5 PCI-E3.0 videokártya', '', 36, 345567, 12, 2);
INSERT INTO supplier (sup_product_type, sup_name, sup_description, sup_warranty, sup_price, spr_manufacturer_id, spr_shipping_days)
	VALUES(5, 'GIGABYTE GeForce GTX960 2048MB D5 GV-N960WF2OC-2GD PCI-E3.0 videokártya', '', 36, 62306, 0, 1);
INSERT INTO supplier (sup_product_type, sup_name, sup_description, sup_warranty, sup_price, spr_manufacturer_id, spr_shipping_days)
	VALUES(5, 'MSI GeForce GT730 2048MB D3 N730K-2GD3/OC PCI-E3.0 videokártya', '', 36, 20980, 1, 1);
-- Ezek valós árak, gyoran írjuk át egy olcsóbb nagykerárra
UPDATE supplier SET sup_price = sup_price / 1.25;


-- Vásárlók (jelszó: password)
INSERT INTO customer (ctm_email, ctm_password, ctm_joined, ctm_lastname, ctm_firstname, ctm_address, ctm_telephone)
	VALUES ('admin@vbstudio.hu', '5f4dcc3b5aa765d61d8327deb882cf99', '2015-10-13', 'Vecsey', 'Balázs', '1234 Budapest, Balage u. 8', '0630-123-4567');

	
-- Beszállító termékei
-- Az ID ugyanaz, az árat átszámolja kisekerárba, a lokális példányszám pedig ötletszerűen
INSERT INTO storage (stg_id, stg_price, stg_quantity)
SELECT sup_id as stg_id, (sup_price * 1.25) as stg_price, (random() * 4) as stg_quantity FROM supplier;

