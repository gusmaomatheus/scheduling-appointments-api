package me.gusmao.matheus.patientscheduling.services.schedule;

import lombok.RequiredArgsConstructor;
import me.gusmao.matheus.patientscheduling.mappers.ScheduleMapper;
import me.gusmao.matheus.patientscheduling.repositories.ScheduleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository repository;
    private final ScheduleMapper mapper;

}
