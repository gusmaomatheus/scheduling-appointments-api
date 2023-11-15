package me.gusmao.matheus.patientscheduling.controllers;

import lombok.RequiredArgsConstructor;
import me.gusmao.matheus.patientscheduling.dtos.PatientDTO;
import me.gusmao.matheus.patientscheduling.entities.Patient;
import me.gusmao.matheus.patientscheduling.services.patient.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/patient")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService service;

    @PostMapping
    public ResponseEntity<Patient> save(@RequestBody PatientDTO data) {
        Patient patient = this.service.save(data);

        return ResponseEntity.status(201).body(patient);
    }

    @GetMapping
    public ResponseEntity<Set<Patient>> getAll() {
        Set<Patient> patients = this.service.getAll();

        return ResponseEntity.status(200).body(patients);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> findById(@PathVariable Long id) {
        Patient patient = this.service.findById(id);

        return ResponseEntity.status(200).body(patient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        this.service.delete(id);

        return ResponseEntity.status(204).build();
    }
}
