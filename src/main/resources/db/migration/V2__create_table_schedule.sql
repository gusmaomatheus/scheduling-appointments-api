CREATE TABLE schedule(
    id varchar(50) PRIMARY KEY,
    description varchar(255),
    schedule_date timestamp,
    created_at timestamp,
    patient_id varchar(50),
    CONSTRAINT fk_schedule_patient FOREIGN KEY(patient_id) REFERENCES patient(id)
);