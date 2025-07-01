package com.rado.helpdesk.controller;

import com.rado.helpdesk.dto.TicketDTO;
import com.rado.helpdesk.service.serviceImpl.TicketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketServiceImpl ticketService;

    @PostMapping
    public ResponseEntity<List<TicketDTO>> getAllTickets(){
        return ResponseEntity.ok(ticketService.getAllUsers());
    }
}
