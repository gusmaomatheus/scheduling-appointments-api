package me.gusmao.matheus.patientscheduling.exceptions.patient;

public class AlreadyCpfExistsException extends RuntimeException {

    public AlreadyCpfExistsException(String message) {
        super(message);
    }
}
