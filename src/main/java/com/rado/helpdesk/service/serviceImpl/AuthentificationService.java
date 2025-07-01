package com.rado.helpdesk.service.serviceImpl;

import com.rado.helpdesk.dto.UserDTO;
import com.rado.helpdesk.model.User;
import com.rado.helpdesk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AuthentificationService {
    @Autowired
    private UserRepository userRepository;

     @Autowired
    private PasswordEncoder passwordEncoder;

     public boolean Authentication(String email, String password){
         Optional<User> user = userRepository.findByEmail(email);

         if(user.isPresent()){
             User user1 = user.get();
             if(passwordEncoder.matches(password,user1.getPassword())){
                 return true;
             }
         }return false;
     }
}
