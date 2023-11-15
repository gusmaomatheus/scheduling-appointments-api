package me.gusmao.matheus.patientscheduling.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

public record PatientDTO(

        @NotBlank(message = "campo 'firstName' não pode ser vazio.")
        String firstName,
        @NotBlank(message = "campo 'lastName' não pode ser vazio.")
        String lastName,
        @CPF(message = "formato inválido para o campo 'cpf'.")
        String cpf,
        @Email(message = "formato inválido para o campo 'email'.")
        String email
) {
}
