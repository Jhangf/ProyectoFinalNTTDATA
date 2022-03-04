-- Insertando datos en el tipo de cuenta bancaria
INSERT INTO tbl_type_bank_accounts (id,name,create_at) VALUES(1,'Ahorro','1990-02-02');
INSERT INTO tbl_type_bank_accounts (id,name,create_at) VALUES(2,'Cuenta Corriente','1990-02-02');
INSERT INTO tbl_type_bank_accounts (id,name,create_at) VALUES(3,'Plazo Fijo','1990-02-02');


INSERT INTO tbl_bank_accounts (id,account_number,maintenance_fee,maintenace_cost,movement_limit,number_moves,withdrawal_or_deposit,total_amount_in_account,create_at,type_bank_account_id,client_id)
VALUES(1,'45698752456987456987',false,0,true,30,false,0,'1990-02-02',1,1);
INSERT INTO tbl_bank_accounts (id,account_number,maintenance_fee,maintenace_cost,movement_limit,number_moves,withdrawal_or_deposit,total_amount_in_account,create_at,type_bank_account_id,client_id)
VALUES(2,'45231012356897412025',true,10,false,0,false,0,'1990-02-02',2,2);
INSERT INTO tbl_bank_accounts (id,account_number,maintenance_fee,maintenace_cost,movement_limit,number_moves,withdrawal_or_deposit,total_amount_in_account,create_at,type_bank_account_id,client_id)
VALUES(3,'659874569856320123650',false,0,true,30,true,0,'1990-02-02',3,3);

-- Insertando tipos de transacciones
INSERT INTO tbl_type_transactions (id,name,create_at) VALUES(1,'Deposito','1990-02-02');
INSERT INTO tbl_type_transactions (id,name,create_at) VALUES(2,'Retiro','1990-02-02');

INSERT INTO tbl_credits_cards (id,account_number,amount_spent,expiration_date,maximum_amount,create_at)
VALUES (1,'4569878963520125',122.3,'2024-02-02',1200.0,'1990-02-02');




