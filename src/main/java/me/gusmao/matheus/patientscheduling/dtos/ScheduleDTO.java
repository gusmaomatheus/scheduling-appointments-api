package me.gusmao.matheus.patientscheduling.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record ScheduleDTO(
        @NotBlank(message = "O campo 'description' não pode ser vazio.") @Size(min = 10, max = 255, message = "A descrição deve conter entre 10 e 255 caracteres.")
        String description,
        @NotBlank(message = "O campo 'date' não pode ser vazio.")
        LocalDateTime date
) {
}
