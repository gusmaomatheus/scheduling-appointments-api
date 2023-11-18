package me.gusmao.matheus.patientscheduling.controllers;

import lombok.RequiredArgsConstructor;
import me.gusmao.matheus.patientscheduling.services.auth.AuthService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService service;


}
