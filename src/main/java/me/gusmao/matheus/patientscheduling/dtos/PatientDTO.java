package me.gusmao.matheus.patientscheduling.dtos;

public record PatientDTO(
        String firstName,
        String lastName,
        String cpf,
        String email
) {
}
