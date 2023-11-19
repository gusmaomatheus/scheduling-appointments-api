package me.gusmao.matheus.patientscheduling.exceptions.patient;

public class PatientNotFoundException extends RuntimeException {

    public PatientNotFoundException(String message) {
        super(message);
    }
}
