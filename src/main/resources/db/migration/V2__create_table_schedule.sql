CREATE TABLE schedule(
    id serial PRIMARY KEY,
    description varchar(255),
    schedule_date timestamp,
    created_at timestamp,
    patient_id integer,
    CONSTRAINT fk_schedule_patient FOREIGN KEY(patient_id) REFERENCES patient(id)
);