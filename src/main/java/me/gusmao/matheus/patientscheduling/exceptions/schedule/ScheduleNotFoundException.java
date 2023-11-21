package me.gusmao.matheus.patientscheduling.exceptions.schedule;

public class ScheduleNotFoundException extends RuntimeException {

    public ScheduleNotFoundException(String message) {
        super(message);
    }
}
