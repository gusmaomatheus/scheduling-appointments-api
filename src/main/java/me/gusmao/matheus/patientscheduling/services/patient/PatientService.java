package me.gusmao.matheus.patientscheduling.services.patient;

import me.gusmao.matheus.patientscheduling.dto.PatientDTO;
import me.gusmao.matheus.patientscheduling.entities.Patient;

public interface PatientService {

    Patient save(PatientDTO data);
}
