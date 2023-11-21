package me.gusmao.matheus.patientscheduling.exceptions.schedule;

public class AlreadyScheduleDateRegisteredException extends RuntimeException {

    public AlreadyScheduleDateRegisteredException(String message) {
        super(message);
    }
}
