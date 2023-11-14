package me.gusmao.matheus.patientscheduling.dto;

public record PatientDTO(
        String firstName,
        String lastName,
        String cpf,
        String email
) {
}
