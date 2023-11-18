package me.gusmao.matheus.patientscheduling.adapters.mappers;

import me.gusmao.matheus.patientscheduling.domain.dtos.auth.RegisterDTO;
import me.gusmao.matheus.patientscheduling.domain.models.User;

public class UserMapper {

    public static User toRegisterDTO(RegisterDTO data) {
        User user = new User();

        user.setLogin(data.login());
        user.setPassword(data.password());
        user.setRole(data.role());

        return user;
    }
}
