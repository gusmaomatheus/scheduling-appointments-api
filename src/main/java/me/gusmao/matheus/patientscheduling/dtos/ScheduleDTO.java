package me.gusmao.matheus.patientscheduling.dtos;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public record ScheduleDTO(
        @NotBlank(message = "O campo 'description' não pode ser vazio.") @Size(min = 10, max = 255, message = "A descrição deve conter entre 10 e 255 caracteres.")
        String description,
        @Future
        @DateTimeFormat(pattern = "yy-MM-ddTHH:mm:ss")
        LocalDateTime date,
        @NotNull(message = "O campo 'patientId' não pode ser nulo.")
        Long patientId
) {
}
