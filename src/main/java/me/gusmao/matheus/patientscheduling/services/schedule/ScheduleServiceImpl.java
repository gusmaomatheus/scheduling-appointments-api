package me.gusmao.matheus.patientscheduling.services.schedule;

import lombok.RequiredArgsConstructor;
import me.gusmao.matheus.patientscheduling.exceptions.schedule.AlreadyScheduleDateRegisteredException;
import me.gusmao.matheus.patientscheduling.exceptions.schedule.ScheduleNotFoundException;
import me.gusmao.matheus.patientscheduling.models.dtos.ScheduleDTO;
import me.gusmao.matheus.patientscheduling.models.entities.Schedule;
import me.gusmao.matheus.patientscheduling.models.mappers.ScheduleMapper;
import me.gusmao.matheus.patientscheduling.repositories.ScheduleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.FeatureDescriptor;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
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

        if (this.alreadyScheduleRegisteredDate(schedule.getDate())) {
            throw new AlreadyScheduleDateRegisteredException("Já existe uma consulta agendada nessa data.");
        }

        return this.repository.save(schedule);
    }

    @Override
    public Schedule findById(Long id) {
        Schedule schedule = this.repository.findById(id).orElseThrow(
                () -> new ScheduleNotFoundException("Não foi encontrado nenhuma consulta com o id '%s'.".formatted(id))
        );

        return schedule;
    }

    @Override
    public Set<Schedule> getAll() {
        Set<Schedule> schedules = new HashSet<>(this.repository.findAll());

        return schedules;
    }

    @Override
    public void update(Long id, ScheduleDTO data) {
        final BeanWrapper beanWrapper = new BeanWrapperImpl(data);
        Schedule schedule = this.repository.findById(id).orElseThrow(
                () -> new ScheduleNotFoundException("Não foi encontrado nenhuma consulta com o id '%s'.".formatted(id))
        );

        String[] nullProperties = Arrays.stream(beanWrapper.getPropertyDescriptors())
                .map(FeatureDescriptor::getName)
                .filter(propertyName -> beanWrapper.getPropertyValue(propertyName) == null)
                .toArray(String[]::new);

        BeanUtils.copyProperties(data, schedule, nullProperties);

        if (this.alreadyScheduleRegisteredDate(schedule.getDate())) {
            throw new AlreadyScheduleDateRegisteredException("Já existe uma consulta agendada nessa data.");
        }

        this.repository.save(schedule);
    }

    @Override
    public void delete(Long id) {
        Schedule schedule = this.repository.findById(id).orElseThrow(
                () -> new ScheduleNotFoundException("Não foi encontrado nenhuma consulta com o id '%s'.".formatted(id))
        );

        this.repository.delete(schedule);
    }

    public boolean alreadyScheduleRegisteredDate(LocalDateTime date) {
        Optional<Schedule> schedule = this.repository.findByDate(date);

        return schedule.isPresent();
    }
}
