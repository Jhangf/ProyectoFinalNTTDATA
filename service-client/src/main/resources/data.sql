INSERT INTO tbl_clients (id,type_client) VALUES (1,1);
INSERT INTO tbl_clients (id,type_client) VALUES (2,1);
INSERT INTO tbl_clients (id,type_client) VALUES (3,1);
INSERT INTO tbl_clients (id,type_client) VALUES (4,2);

INSERT INTO tbl_personals_clients (id,first_name,last_name,document_type,document_number,phone,birthday,created_at,client_id)
VALUES (1,'Jhan','Gutierrez',1,'76070593','922402398','1990-02-02',NOW(),1);
INSERT INTO tbl_personals_clients (id,first_name,last_name,document_type,document_number,phone,birthday,created_at,client_id)
VALUES (2,'Daniela','Palomares',2,'1234567','32145','1960-01-02',NOW(),2);

INSERT INTO tbl_personals_clients (id,first_name,last_name,document_type,document_number,phone,birthday,created_at,client_id)
VALUES (3,'Melissa','Aguirre',2,'98070598','32145','1960-01-02',NOW(),3);


INSERT INTO tbl_business_clients (id,business_name,ruc,created_at,client_id)
VALUES (1,'Jande SAC','2015468796',NOW(),4);


