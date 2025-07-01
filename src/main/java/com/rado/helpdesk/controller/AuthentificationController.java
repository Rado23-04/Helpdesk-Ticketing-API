package com.rado.helpdesk.controller;

import com.rado.helpdesk.config.JwtUtil;
import com.rado.helpdesk.dto.UserDTO;
import com.rado.helpdesk.service.serviceImpl.AuthentificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/connexion")
public class AuthentificationController {
    @Autowired
    private AuthentificationService authentificationService;

    @Autowired
    private JwtUtil jwtUtil;

    public ResponseEntity<?> CheckAuthentification(@RequestBody UserDTO userDTO){
        boolean isAuthentified = authentificationService.Authentication(userDTO.getEmail(),userDTO.getPassword());
        if(isAuthentified){
            String token = jwtUtil.generateToken(userDTO.getEmail());
            return ResponseEntity.ok().body(Map.of("success",true,"token",token));
        }
        return ResponseEntity.ok().body(Map.of("failed",true,"message","Authentification failed"));
    }
}
