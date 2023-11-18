package me.gusmao.matheus.patientscheduling.services.auth;

import lombok.RequiredArgsConstructor;
import me.gusmao.matheus.patientscheduling.dtos.auth.LoginDTO;
import me.gusmao.matheus.patientscheduling.dtos.auth.RegisterDTO;
import me.gusmao.matheus.patientscheduling.entities.User;
import me.gusmao.matheus.patientscheduling.repositories.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService, UserDetailsService {

    private final UserRepository repository;
    private final AuthenticationManager authManager;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.repository.findByLogin(username);
    }

    @Override
    public void register(RegisterDTO data) {
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User user = new User(data.login(), encryptedPassword, data.role());

        this.repository.save(user);
    }

    @Override
    public void login(LoginDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authManager.authenticate(usernamePassword);
    }
}
