package me.gusmao.matheus.patientscheduling.services.patient;

import lombok.RequiredArgsConstructor;
import me.gusmao.matheus.patientscheduling.dto.PatientDTO;
import me.gusmao.matheus.patientscheduling.entities.Patient;
import me.gusmao.matheus.patientscheduling.repositories.PatientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository repository;

    @Override
    public Patient save(PatientDTO data) {
        Patient patient = new Patient(data);

        return this.repository.save(patient);
    }
}
