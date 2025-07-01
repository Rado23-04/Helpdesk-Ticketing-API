package com.rado.helpdesk.service.serviceImpl;

import com.rado.helpdesk.dto.UserDTO;
import com.rado.helpdesk.model.User;
import com.rado.helpdesk.repository.UserRepository;
import com.rado.helpdesk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());

        User savedUser = userRepository.save(user);
        return new UserDTO(savedUser.getEmail(),savedUser.getPassword());
    }
}
