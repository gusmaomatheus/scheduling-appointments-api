CREATE TABLE users(
    id serial PRIMARY KEY,
    login TEXT UNIQUE,
    password TEXT,
    role TEXT
);