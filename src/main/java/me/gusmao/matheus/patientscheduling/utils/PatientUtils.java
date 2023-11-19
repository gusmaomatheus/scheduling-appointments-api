package me.gusmao.matheus.patientscheduling.utils;

import me.gusmao.matheus.patientscheduling.models.entities.Patient;

public class PatientUtils {

    public static String formattedCpf(Patient patient) {
        String cpf = patient.getCpf();

        return cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9);
    }
}
