CREATE TABLE company (
   cp_id BIGINT PRIMARY KEY,
   cp_name VARCHAR(255) not null,
   cp_identifier VARCHAR(20) not null,
   cp_email VARCHAR(255) not null,
   cp_address_street VARCHAR(255) ,
   cp_address_number INTEGER,
   cp_address_neighborhood  VARCHAR(255),
   cp_ct_id BIGINT,

   FOREIGN KEY (cp_ct_id) REFERENCES city(ct_id)
);


