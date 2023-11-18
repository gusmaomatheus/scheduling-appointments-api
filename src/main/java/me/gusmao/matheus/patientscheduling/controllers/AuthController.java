package me.gusmao.matheus.patientscheduling.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import me.gusmao.matheus.patientscheduling.models.dtos.auth.LoginDTO;
import me.gusmao.matheus.patientscheduling.models.dtos.auth.LoginResponseDTO;
import me.gusmao.matheus.patientscheduling.models.dtos.auth.RegisterDTO;
import me.gusmao.matheus.patientscheduling.services.auth.AuthServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthServiceImpl service;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid LoginDTO data) throws Exception {
        String token = this.service.login(data);
        LoginResponseDTO responseDTO = new LoginResponseDTO(token);

        return ResponseEntity.status(200).body(responseDTO);
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data) {
        this.service.register(data);

        return ResponseEntity.status(200).build();
    }

}
