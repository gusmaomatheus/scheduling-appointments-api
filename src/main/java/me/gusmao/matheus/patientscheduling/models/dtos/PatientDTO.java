package me.gusmao.matheus.patientscheduling.models.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

public record PatientDTO(

        @NotBlank(message = "campo 'firstName' não pode ser vazio.")
        @Size(min = 5, max = 30, message = "campo 'fristName' deve ter entre 5 e 30 caracteres.")
        String firstName,
        @NotBlank(message = "campo 'lastName' não pode ser vazio.")
        @Size(min = 5, max = 30, message = "campo 'lastName' deve ter entre 5 e 60 caracteres.")
        String lastName,
        @CPF(message = "formato inválido para o campo 'cpf'.")
        String cpf,
        @Email(message = "formato inválido para o campo 'email'.")
        String email
) {
}
