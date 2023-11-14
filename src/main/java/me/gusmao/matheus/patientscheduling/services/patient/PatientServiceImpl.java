package me.gusmao.matheus.patientscheduling.services.patient;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import me.gusmao.matheus.patientscheduling.dto.PatientDTO;
import me.gusmao.matheus.patientscheduling.entities.Patient;
import me.gusmao.matheus.patientscheduling.repositories.PatientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

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

    @Override
    public Patient findById(UUID id) {
        Patient patient = this.repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Não foi encontrado nenhum paciente com o id '%s'.".formatted(id))
        );

        return patient;
    }

    @Override
    public Set<Patient> getAll() {
        Set<Patient> patients = new HashSet<>(this.repository.findAll());

        return patients;
    }
}
