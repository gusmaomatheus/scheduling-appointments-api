package me.gusmao.matheus.patientscheduling.mappers;

import me.gusmao.matheus.patientscheduling.dtos.PatientDTO;
import me.gusmao.matheus.patientscheduling.entities.Patient;

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
