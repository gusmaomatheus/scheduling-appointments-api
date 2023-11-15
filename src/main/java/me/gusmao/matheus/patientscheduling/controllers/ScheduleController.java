package me.gusmao.matheus.patientscheduling.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import me.gusmao.matheus.patientscheduling.dtos.ScheduleDTO;
import me.gusmao.matheus.patientscheduling.entities.Schedule;
import me.gusmao.matheus.patientscheduling.services.schedule.ScheduleServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("api/schedule")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleServiceImpl service;

    @PostMapping
    public ResponseEntity<Schedule> save(@Valid @RequestBody ScheduleDTO data) {
        Schedule schedule = this.service.save(data);

        return ResponseEntity.status(201).body(schedule);
    }

    @GetMapping
    public ResponseEntity<Set<Schedule>> getAll() {
        Set<Schedule> schedules = this.service.getAll();

        return ResponseEntity.status(200).body(schedules);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Schedule> findById(@PathVariable Long id) {
        Schedule schedule = this.service.findById(id);

        return ResponseEntity.status(200).body(schedule);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @Valid @RequestBody ScheduleDTO data) {
        Schedule schedule = this.service.findById(id);

        this.service.update(id, data);

        return ResponseEntity.status(200).body(schedule);
    }
}
