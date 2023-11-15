package me.gusmao.matheus.patientscheduling.services.schedule;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import me.gusmao.matheus.patientscheduling.dtos.ScheduleDTO;
import me.gusmao.matheus.patientscheduling.entities.Schedule;
import me.gusmao.matheus.patientscheduling.mappers.ScheduleMapper;
import me.gusmao.matheus.patientscheduling.repositories.ScheduleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository repository;
    private final ScheduleMapper mapper;

    @Override
    public Schedule save(ScheduleDTO data) {
        Schedule schedule = mapper.transform(data);

        return this.repository.save(schedule);
    }

    @Override
    public Schedule findById(Long id) {
        Schedule schedule = this.repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Não foi encontrado nenhuma consulta com o id '%s'.".formatted(id))
        );

        return schedule;
    }

    @Override
    public Set<Schedule> getAll() {
        Set<Schedule> schedules = new HashSet<>(this.repository.findAll());

        return schedules;
    }
}
