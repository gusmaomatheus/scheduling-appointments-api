CREATE TABLE patient(
    id serial PRIMARY KEY,
    first_name varchar(30),
    last_name  varchar(60),
    cpf varchar(14),
    email varchar(100)
);