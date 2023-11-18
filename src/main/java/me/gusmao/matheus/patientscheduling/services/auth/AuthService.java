package me.gusmao.matheus.patientscheduling.services.auth;

import me.gusmao.matheus.patientscheduling.dtos.auth.LoginDTO;
import me.gusmao.matheus.patientscheduling.dtos.auth.RegisterDTO;

public interface AuthService {

    void register(RegisterDTO data);

    String login(LoginDTO data) throws Exception;
}
