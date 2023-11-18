package me.gusmao.matheus.patientscheduling.services.auth;

import me.gusmao.matheus.patientscheduling.dtos.auth.LoginDTO;
import me.gusmao.matheus.patientscheduling.dtos.auth.RegisterDTO;

public interface AuthService {

    void register(RegisterDTO data);

    void login(LoginDTO data);
}
