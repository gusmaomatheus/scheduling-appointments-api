package me.gusmao.matheus.patientscheduling.services.patient;

import me.gusmao.matheus.patientscheduling.dto.PatientDTO;
import me.gusmao.matheus.patientscheduling.entities.Patient;

import java.util.Set;
import java.util.UUID;

public interface PatientService {

    Patient save(PatientDTO data);

    Patient findById(UUID id);

    Set<Patient> getAll();

    void delete(UUID id);
}
