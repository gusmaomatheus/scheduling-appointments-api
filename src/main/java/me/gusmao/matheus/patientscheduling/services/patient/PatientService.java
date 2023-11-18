package me.gusmao.matheus.patientscheduling.services.patient;

import me.gusmao.matheus.patientscheduling.models.dtos.PatientDTO;
import me.gusmao.matheus.patientscheduling.models.entities.Patient;

import java.util.Set;

public interface PatientService {

    Patient save(PatientDTO data);

    Patient findById(Long id);

    Set<Patient> getAll();

    void update(Long id, PatientDTO data);

    void delete(Long id);
}
