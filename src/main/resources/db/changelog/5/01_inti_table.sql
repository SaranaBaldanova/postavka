set search_path to def;

CREATE TABLE users (
    id bigserial PRIMARY KEY,
    username VARCHAR(255) ,
    password VARCHAR(255) ,
    is_admin BOOLEAN ,
    is_ban BOOLEAN,
    password_limit BOOLEAN
);
