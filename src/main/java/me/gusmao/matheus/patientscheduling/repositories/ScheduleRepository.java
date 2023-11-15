package me.gusmao.matheus.patientscheduling.repositories;

import me.gusmao.matheus.patientscheduling.entities.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
