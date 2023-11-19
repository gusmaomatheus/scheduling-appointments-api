package me.gusmao.matheus.patientscheduling.utils;

import me.gusmao.matheus.patientscheduling.models.entities.Patient;

public class PatientUtils {

    public static void formatCpf(Patient patient) {
        String cpf = patient.getCpf();
        String cpfFormatted = cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9);

        patient.setCpf(cpfFormatted);
    }
}
