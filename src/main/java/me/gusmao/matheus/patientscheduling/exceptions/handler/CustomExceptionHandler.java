package me.gusmao.matheus.patientscheduling.exceptions.handler;

import me.gusmao.matheus.patientscheduling.exceptions.AlreadyCpfExistsException;
import me.gusmao.matheus.patientscheduling.exceptions.model.ExceptionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(AlreadyCpfExistsException.class)
    public ResponseEntity<ExceptionResponse> alreadyExistsCpf(AlreadyCpfExistsException exception) {
        String message = exception.getMessage();
        int status = 400;
        LocalDateTime dateOccurrence = LocalDateTime.now();

        ExceptionResponse response = new ExceptionResponse(message, status, dateOccurrence);

        return ResponseEntity.status(response.getStatus()).body(response);
    }

}
