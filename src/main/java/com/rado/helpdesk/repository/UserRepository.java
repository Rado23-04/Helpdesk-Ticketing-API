package com.rado.helpdesk.repository;

import com.rado.helpdesk.dto.UserDTO;
import com.rado.helpdesk.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
}
