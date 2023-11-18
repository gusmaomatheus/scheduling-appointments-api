package me.gusmao.matheus.patientscheduling.domain.services.auth;

import lombok.RequiredArgsConstructor;
import me.gusmao.matheus.patientscheduling.adapters.mappers.UserMapper;
import me.gusmao.matheus.patientscheduling.config.SecurityConfig;
import me.gusmao.matheus.patientscheduling.domain.dtos.auth.LoginDTO;
import me.gusmao.matheus.patientscheduling.domain.dtos.auth.RegisterDTO;
import me.gusmao.matheus.patientscheduling.domain.models.User;
import me.gusmao.matheus.patientscheduling.domain.repositories.UserRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService, UserDetailsService {

    private final UserRepository repository;
    private final SecurityConfig securityConfig;
    private final AuthTokenService tokenService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.repository.findByLogin(username);
    }

    @Override
    public void register(RegisterDTO data) {
        String encryptedPassword = this.securityConfig.passwordEncoder().encode(data.password());
        User user = UserMapper.toRegisterDTO(data);

        user.setPassword(encryptedPassword);

        this.repository.save(user);
    }

    @Override
    public String login(LoginDTO data) throws Exception {
        UsernamePasswordAuthenticationToken usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        Authentication auth = this.securityConfig.authenticationManager(new AuthenticationConfiguration()).authenticate(usernamePassword);

        String token = tokenService.generateToken((User) auth.getPrincipal());

        return token;
    }
}
