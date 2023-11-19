package me.gusmao.matheus.patientscheduling.exceptions;

public class AlreadyCpfExistsException extends RuntimeException {

    public AlreadyCpfExistsException(String message) {
        super(message);
    }
}
