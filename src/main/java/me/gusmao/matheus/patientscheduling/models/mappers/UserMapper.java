package me.gusmao.matheus.patientscheduling.models.mappers;

import me.gusmao.matheus.patientscheduling.models.dtos.auth.RegisterDTO;
import me.gusmao.matheus.patientscheduling.models.entities.User;

public class UserMapper {

    public static User toRegisterDTO(RegisterDTO data) {
        User user = new User();

        user.setLogin(data.login());
        user.setPassword(data.password());
        user.setRole(data.role());

        return user;
    }
}
