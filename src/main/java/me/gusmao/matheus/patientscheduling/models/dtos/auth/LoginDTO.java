package me.gusmao.matheus.patientscheduling.models.dtos.auth;

import jakarta.validation.constraints.NotBlank;

public record LoginDTO(
        @NotBlank(message = "O campo 'login' não pode ser vazio.")
        String login,
        @NotBlank(message = "O campo 'password' não pode ser vazio.")
        String password
) {
}
