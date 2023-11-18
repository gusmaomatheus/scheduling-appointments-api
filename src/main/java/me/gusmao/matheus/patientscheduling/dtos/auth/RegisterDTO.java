package me.gusmao.matheus.patientscheduling.dtos.auth;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import me.gusmao.matheus.patientscheduling.enums.UserRole;

public record RegisterDTO(
        @NotBlank(message = "O campo 'login' não pode ser vazio.")
        @Size(message = "O login deve ter entre 10 e 50 caracteres.", min = 5, max = 50)
        String login,
        @NotBlank(message = "O campo 'password' não pode ser vazio.")
        @Size(message = "A senha deve ter entre 6 e 16 caracteres.", min = 5, max = 16)
        String password,
        @NotNull(message = "O campo 'role' não pode ser nulo.")
        UserRole role
) {
}
