CREATE TABLE state (
    st_id BIGSERIAL PRIMARY KEY,
    st_name VARCHAR(255) not null,
    st_abbreviation VARCHAR not null
);

CREATE TABLE city (
    ct_id BIGSERIAL PRIMARY KEY,
    ct_name VARCHAR(255) not null,
    ct_st_id BIGINT not null,
    FOREIGN KEY (ct_st_id) REFERENCES state(st_id)
);


CREATE TABLE user_login (
    us_id  BIGSERIAL PRIMARY KEY,
    us_email VARCHAR(255) not null
);

CREATE TABLE user_admin (
    usa_id BIGSERIAL PRIMARY KEY,
    usa_name VARCHAR(255) not null,
    usr_login_id BIGINT not null,
    FOREIGN KEY (usr_login_id) REFERENCES user_login(us_id)
);

CREATE TABLE "user" (
    usr_id BIGSERIAL PRIMARY KEY,
    usr_name VARCHAR(255) NOT NULL,
    usr_personal_tax_id VARCHAR(20) NOT NULL,
    usr_email VARCHAR(255) NOT NULL,
    usr_birthday Date NOT NULL,
    usr_city_id BIGINT not null,
    usr_login_id BIGINT not null,
    usr_cellphone BIGINT not null,
    asr_active BOOLEAN,
    FOREIGN KEY (usr_city_id) REFERENCES city(ct_id),
    FOREIGN KEY (usr_login_id) REFERENCES user_login(us_id)
);

CREATE TABLE contact (
    ctc_id BIGSERIAL PRIMARY KEY,
    ctc_name VARCHAR(255) NOT NULL,
    ctc_city_id BIGINT,
    ctc_cellphone Varchar(12),
    ctc_observation varchar(255),

    FOREIGN KEY (ctc_city_id) REFERENCES city(ct_id)
);

CREATE TABLE client (
    cli_id BIGSERIAL PRIMARY KEY,
    cli_name VARCHAR(255) NOT NULL,
    cli_city_id BIGINT,
    cli_cellphone Varchar(12),
    cli_email Varchar(50),
    cli_address_street Varchar(100),
    cli_address_number Varchar(10),
    cli_address_neighborhood Varchar(100),
    cli_address_complement Varchar(256),

    FOREIGN KEY (cli_city_id) REFERENCES city(ct_id)
);