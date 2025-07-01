package com.rado.helpdesk.service.serviceImpl;

import com.rado.helpdesk.dto.UserDTO;
import com.rado.helpdesk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

public class AuthentificationService {
    @Autowired
    private UserRepository userRepository;

     @Autowired
    private PasswordEncoder passwordEncoder;

     public boolean Authentication(String email, String password){
         Optional<UserDTO> userDTOOptional = userRepository.findByEmail(email);

         if(userDTOOptional.isPresent()){
             UserDTO userDTO = userDTOOptional.get();
             if(passwordEncoder.matches(password,userDTO.getPassword())){
                 return true;
             }
         }return false;
     }
}
