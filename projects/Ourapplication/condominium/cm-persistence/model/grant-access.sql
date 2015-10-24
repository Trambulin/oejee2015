GRANT SELECT, INSERT, UPDATE, DELETE ON c_type, condominium, c_owner, repair,condominium_owner,c_user,notification,repair_notification TO condominium_role;
    
GRANT USAGE, SELECT, UPDATE ON c_type_c_type_id_seq TO condominium_role;
GRANT USAGE, SELECT, UPDATE ON condominium_condominium_id_seq TO condominium_role;
GRANT USAGE, SELECT, UPDATE ON c_owner_c_owner_id_seq TO condominium_role;
GRANT USAGE, SELECT, UPDATE ON repair_repair_id_seq TO condominium_role;