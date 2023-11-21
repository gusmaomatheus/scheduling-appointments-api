package me.gusmao.matheus.patientscheduling.repositories;

import me.gusmao.matheus.patientscheduling.models.entities.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    @Query("SELECT schedule FROM Schedule schedule WHERE schedule.date = :date")
    Optional<Schedule> findByDate(@Param("date") LocalDateTime date);
}
