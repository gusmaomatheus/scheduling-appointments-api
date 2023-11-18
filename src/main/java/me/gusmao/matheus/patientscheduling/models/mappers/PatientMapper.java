package me.gusmao.matheus.patientscheduling.models.mappers;

import me.gusmao.matheus.patientscheduling.models.dtos.PatientDTO;
import me.gusmao.matheus.patientscheduling.models.entities.Patient;

public class PatientMapper {

    public static Patient transform(PatientDTO data) {
        Patient patient = new Patient();

        patient.setFirstName(data.firstName());
        patient.setLastName(data.lastName());
        patient.setEmail(data.email());
        patient.setCpf(data.cpf());

        return patient;
    }
}