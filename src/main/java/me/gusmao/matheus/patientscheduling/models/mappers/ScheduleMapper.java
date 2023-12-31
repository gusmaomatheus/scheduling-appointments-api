package me.gusmao.matheus.patientscheduling.models.mappers;

import lombok.RequiredArgsConstructor;
import me.gusmao.matheus.patientscheduling.models.dtos.ScheduleDTO;
import me.gusmao.matheus.patientscheduling.models.entities.Patient;
import me.gusmao.matheus.patientscheduling.models.entities.Schedule;
import me.gusmao.matheus.patientscheduling.services.patient.PatientServiceImpl;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class ScheduleMapper {

    private final PatientServiceImpl service;

    public Schedule transform(ScheduleDTO data) {
        Schedule schedule = new Schedule();
        Patient patient = this.service.findById(data.patientId());

        schedule.setDescription(data.description());
        schedule.setDate(data.date());
        schedule.setCreatedAt(LocalDateTime.now());
        schedule.setPatient(patient);

        return schedule;
    }
}
