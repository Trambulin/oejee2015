-- Teljes és limitált hozzáférés a táblákhoz
GRANT SELECT, INSERT, UPDATE, DELETE ON storage, customer, orders TO webshop_role;
GRANT SELECT ON supplier, manufacturer, product_type TO webshop_role;

-- Szekvenciák
GRANT USAGE, SELECT, UPDATE ON supplier_sup_id_seq TO webshop_role;
GRANT USAGE, SELECT, UPDATE ON customer_ctm_id_seq TO webshop_role;
GRANT USAGE, SELECT, UPDATE ON orders_ord_id_seq TO webshop_role;

-- storage      - teljes rendelkezés, a bolt admin frissíti
-- supplier     - fix, lényegében külső db
-- manufacturer - fix, ugyanaz mint az előző
-- product_type - dettó, a gyártók találják ki a termék típusokat, nem a bolt
-- customer     - teljes rendelkezés, a vevő regisztrál
-- orders       - teljes rendelkezés, a vevő hoz létre rendelést
