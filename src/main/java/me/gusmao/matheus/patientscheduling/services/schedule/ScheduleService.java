package me.gusmao.matheus.patientscheduling.services.schedule;

import me.gusmao.matheus.patientscheduling.models.dtos.ScheduleDTO;
import me.gusmao.matheus.patientscheduling.models.entities.Schedule;

import java.util.Set;

public interface ScheduleService {

    Schedule save(ScheduleDTO data);

    Schedule findById(Long id);

    Set<Schedule> getAll();

    void update(Long id, ScheduleDTO data);

    void delete(Long id);
}
