package me.gusmao.matheus.patientscheduling.controllers;

import lombok.RequiredArgsConstructor;
import me.gusmao.matheus.patientscheduling.services.schedule.ScheduleServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/schedule")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleServiceImpl service;

}
