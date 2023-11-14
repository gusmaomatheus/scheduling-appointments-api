package me.gusmao.matheus.patientscheduling.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.gusmao.matheus.patientscheduling.dto.PatientDTO;

import java.util.UUID;

@Entity
@Table(name = "patient")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String firstName;
    private String lastName;
    private String cpf;
    private String email;

    public Patient(PatientDTO data) {
        this.firstName = data.firstName();
        this.lastName = data.lastName();
        this.cpf = data.cpf();
        this.email = data.email();
    }
}
