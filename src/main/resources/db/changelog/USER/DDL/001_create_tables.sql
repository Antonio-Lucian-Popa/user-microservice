--liquibase formatted sql
--changeset Antonio Lucian:create-tables

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

create table if not exists users (
id uuid NOT NULL DEFAULT uuid_generate_v4() PRIMARY KEY,
profile_image_id VARCHAR(50) NOT NULL,
first_name VARCHAR(50) NOT NULL,
last_name VARCHAR(50) NOT NULL,
email VARCHAR(50),
password VARCHAR NOT NULL,
birthday DATE NOT NULL,
phone_number VARCHAR(50) NOT NULL,
created_at DATE NOT NULL,
);