-- Insertando datos en el tipo de cuenta bancaria
INSERT INTO tbl_type_bank_accounts (id,name,create_at) VALUES(1,'Ahorro','1990-02-02');
INSERT INTO tbl_type_bank_accounts (id,name,create_at) VALUES(2,'Cuenta Corriente','1990-02-02');
INSERT INTO tbl_type_bank_accounts (id,name,create_at) VALUES(3,'Plazo Fijo','1990-02-02');


INSERT INTO tbl_bank_accounts (id,account_number,maintenance_fee,maintenace_cost,movement_limit,number_moves,withdrawal_or_deposit,total_amount_in_account,create_at,type_bank_account_id)
VALUES(1,'123456',false,0,true,30,false,0,'1990-02-02',1);

-- Insertando tipos de transacciones
INSERT INTO tbl_type_transactions (id,name,create_at) VALUES(1,'Deposito','1990-02-02');
INSERT INTO tbl_type_transactions (id,name,create_at) VALUES(2,'Retiro','1990-02-02');

INSERT INTO tbl_credits_cards (id,account_number,amount_spent,expiration_date,maximum_amount,create_at)
VALUES (1,'123466',122.3,'1990-02-02',1200.0,'1990-02-02');



