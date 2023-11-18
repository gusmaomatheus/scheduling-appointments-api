package me.gusmao.matheus.patientscheduling.repositories;

import me.gusmao.matheus.patientscheduling.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    UserDetails findByLogin(String login);
}
