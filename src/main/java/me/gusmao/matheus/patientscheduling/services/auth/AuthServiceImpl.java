package me.gusmao.matheus.patientscheduling.services.auth;

import lombok.RequiredArgsConstructor;
import me.gusmao.matheus.patientscheduling.config.SecurityConfig;
import me.gusmao.matheus.patientscheduling.dtos.auth.LoginDTO;
import me.gusmao.matheus.patientscheduling.dtos.auth.RegisterDTO;
import me.gusmao.matheus.patientscheduling.entities.User;
import me.gusmao.matheus.patientscheduling.repositories.UserRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService, UserDetailsService {

    private final UserRepository repository;
    private final SecurityConfig securityConfig;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.repository.findByLogin(username);
    }

    @Override
    public void register(RegisterDTO data) {
        String encryptedPassword = this.securityConfig.passwordEncoder().encode(data.password());
        User user = new User(data.login(), encryptedPassword, data.role());

        this.repository.save(user);
    }

    @Override
    public void login(LoginDTO data) throws Exception {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.securityConfig.authenticationManager(new AuthenticationConfiguration()).authenticate(usernamePassword);
    }
}
