package me.gusmao.matheus.patientscheduling.services.schedule;

import me.gusmao.matheus.patientscheduling.dtos.ScheduleDTO;
import me.gusmao.matheus.patientscheduling.entities.Schedule;

public interface ScheduleService {

    Schedule save(ScheduleDTO data);

    Schedule findById(Long id);
}
