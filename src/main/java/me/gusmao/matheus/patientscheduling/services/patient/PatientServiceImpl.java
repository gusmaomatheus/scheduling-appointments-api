package me.gusmao.matheus.patientscheduling.services.patient;

import me.gusmao.matheus.patientscheduling.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;
}
