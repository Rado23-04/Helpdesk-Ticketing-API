package com.rado.helpdesk.service.serviceImpl;

import com.rado.helpdesk.dto.UserDTO;
import com.rado.helpdesk.model.User;
import com.rado.helpdesk.repository.UserRepository;
import com.rado.helpdesk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDTO createUser(UserDTO userDTO) {
        String passWordHashage = passwordEncoder.encode(userDTO.getPassword());
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setPassword(passWordHashage);

        User savedUser = userRepository.save(user);
        return new UserDTO(savedUser.getEmail(),savedUser.getPassword());
    }
}
