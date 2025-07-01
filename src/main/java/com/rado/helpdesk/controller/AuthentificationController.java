package com.rado.helpdesk.controller;

import com.rado.helpdesk.config.JwtUtil;
import com.rado.helpdesk.dto.UserDTO;
import com.rado.helpdesk.model.User;
import com.rado.helpdesk.service.serviceImpl.AuthentificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AuthentificationController {
    @Autowired
    private AuthentificationService authentificationService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/auth")
    public ResponseEntity<?> CheckAuthentification(@RequestBody User user){
        boolean isAuthentified = authentificationService.Authentication(user.getEmail(),user.getPassword());
        if(isAuthentified){
            String token = jwtUtil.generateToken(user.getEmail());
            return ResponseEntity.ok().body(Map.of("success",true,"token",token));
        }
        return ResponseEntity.ok().body(Map.of("failed",true,"message","Authentification failed"));
    }
}
