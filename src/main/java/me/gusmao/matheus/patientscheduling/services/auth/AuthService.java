package me.gusmao.matheus.patientscheduling.services.auth;

import me.gusmao.matheus.patientscheduling.dtos.auth.LoginDTO;

public interface AuthService {

    void login(LoginDTO data);
}
