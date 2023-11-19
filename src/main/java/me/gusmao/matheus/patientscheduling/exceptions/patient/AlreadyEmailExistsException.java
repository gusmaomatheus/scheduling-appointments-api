package me.gusmao.matheus.patientscheduling.exceptions.patient;

public class AlreadyEmailExistsException extends RuntimeException {

    public AlreadyEmailExistsException(String message) {
        super(message);
    }
}
