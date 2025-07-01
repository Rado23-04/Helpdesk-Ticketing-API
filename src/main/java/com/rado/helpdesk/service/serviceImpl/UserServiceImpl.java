package com.rado.helpdesk.service.serviceImpl;

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
    public User createUser(User user) {
        String passWordHashage = passwordEncoder.encode(user.getPassword());
        user.setPassword(passWordHashage);

        return userRepository.save(user);
    }
}
