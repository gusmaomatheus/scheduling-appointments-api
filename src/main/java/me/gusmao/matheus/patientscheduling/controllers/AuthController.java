package me.gusmao.matheus.patientscheduling.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import me.gusmao.matheus.patientscheduling.dtos.auth.LoginDTO;
import me.gusmao.matheus.patientscheduling.dtos.auth.RegisterDTO;
import me.gusmao.matheus.patientscheduling.services.auth.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService service;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid LoginDTO data) throws Exception {
        this.service.login(data);

        return ResponseEntity.status(200).build();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data) {
        this.service.register(data);

        return ResponseEntity.status(200).build();
    }

}
