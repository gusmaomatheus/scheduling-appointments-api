package me.gusmao.matheus.patientscheduling.repositories;

import me.gusmao.matheus.patientscheduling.models.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    Optional<Patient> findByCpf(String cpf);

    Optional<Patient> findByEmail(String email);
}
