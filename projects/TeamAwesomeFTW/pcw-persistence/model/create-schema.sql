-- Enum tábla a gyártókra
CREATE TABLE manufacturer (
	mf_id INTEGER NOT NULL,
	mf_name CHARACTER VARYING(64) NOT NULL,
	/*mf_address CHARACTER VARYING(128) NOT NULL,*/
	mf_telephone CHARACTER VARYING(16) NOT NULL,
	
	CONSTRAINT PK_MF_ID PRIMARY KEY (mf_id)
);
ALTER TABLE manufacturer OWNER TO postgres;


-- Enum tábla a termék kategórákra
CREATE TABLE product_type (
	pdt_id INTEGER NOT NULL,
	pdt_name CHARACTER VARYING(64) NOT NULL,
	
	CONSTRAINT PK_PDT_ID PRIMARY KEY (pdt_id)
);
ALTER TABLE product_type OWNER TO postgres;
CREATE UNIQUE INDEX UI_PDT_NAME ON product_type USING btree (pdt_name);


-- Beszállító készlete
CREATE TABLE supplier (
	sup_id SERIAL NOT NULL, --új terméket ha piacra dob az automatikusan új id-t kap
	sup_product_type INTEGER NOT NULL,
	sup_name CHARACTER VARYING(128) NOT NULL,
	sup_description TEXT, --szabadon bármilyen szöveg, akár html formázással
	sup_warranty SMALLINT NOT NULL DEFAULT 0, --hónapban
	sup_price INTEGER NOT NULL, --nagyker ár
	spr_manufacturer_id INTEGER NOT NULL,
	spr_shipping_days SMALLINT NOT NULL DEFAULT 2, --mennyi naptári nap alatt szállítják be
	
	CONSTRAINT PK_SUP_ID PRIMARY KEY (sup_id),
	CONSTRAINT FK_SUP_TYPE FOREIGN KEY (sup_product_type)
		REFERENCES product_type (pdt_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT,
	CONSTRAINT FK_SUP_MANUFACTURER FOREIGN KEY (spr_manufacturer_id)
		REFERENCES manufacturer (mf_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);
ALTER TABLE supplier OWNER TO postgres;


-- Helyi raktárkészlet
CREATE TABLE storage (
	stg_id INTEGER NOT NULL, --ugyanaz az id mint a beszállítónál, mivel úgyis egyedi
	stg_price INTEGER NOT NULL, --kisker ár
	stg_quantity SMALLINT NOT NULL, --teljes készlet
	stg_quantity_reserved SMALLINT NOT NULL DEFAULT 0, --rendelésre lefoglalt készlet
	
	CONSTRAINT PK_STG_ID PRIMARY KEY (stg_id),
	CONSTRAINT FK_STG_ID FOREIGN KEY (stg_id)
		REFERENCES supplier (sup_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);
ALTER TABLE storage OWNER TO postgres;


-- Vásárlók
CREATE TABLE customer (
	ctm_id SERIAL NOT NULL,
	ctm_email CHARACTER VARYING(64) NOT NULL, --mindig unique
	ctm_password CHARACTER VARYING(64) NOT NULL,
	ctm_joined DATE NOT NULL DEFAULT CURRENT_DATE,
	ctm_lastname CHARACTER VARYING(32) NOT NULL,
	ctm_firstname CHARACTER VARYING(32) NOT NULL,
	ctm_address CHARACTER VARYING(128) NOT NULL,
	ctm_telephone CHARACTER VARYING(16) NOT NULL,
	
	CONSTRAINT PK_CTM_ID PRIMARY KEY (ctm_id)
);
ALTER TABLE customer OWNER TO postgres;
CREATE UNIQUE INDEX UI_CTM_EMAIL ON customer USING btree (ctm_email);


-- Vásárlók rendelései. Ha átvette, utána is bentmarad a rendszerben.
CREATE TABLE orders (
	ord_id SERIAL NOT NULL,
	ord_pid INTEGER NOT NULL, --termék id
	ord_cid INTEGER NOT NULL, --vevő id
	ord_price INTEGER NOT NULL, --a megrendeléskor aktuális ár
	ord_shipped_on DATE NOT NULL, --ekkor lett elküldve
	ord_shipment_due DATE NOT NULL, --ekkor érkezik meg
	ord_delivered BOOLEAN NOT NULL DEFAULT FALSE, --vevő átvette
	
	CONSTRAINT PK_ORD_ID PRIMARY KEY (ord_id),
	CONSTRAINT FK_ORD_PID FOREIGN KEY (ord_pid)
		REFERENCES storage (stg_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT,
	CONSTRAINT FK_ORD_CID FOREIGN KEY (ord_cid)
		REFERENCES customer (ctm_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);
ALTER TABLE orders OWNER TO postgres;
