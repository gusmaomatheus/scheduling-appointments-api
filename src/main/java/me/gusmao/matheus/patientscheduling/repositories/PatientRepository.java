package me.gusmao.matheus.patientscheduling.repositories;

import me.gusmao.matheus.patientscheduling.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PatientRepository extends JpaRepository<Patient, UUID> {}
