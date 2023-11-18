CREATE TABLE users(
    id serial PRIMARY KEY,
    login varchar(50) UNIQUE,
    password varchar(16),
    role TEXT
);