package com.rado.helpdesk.service.serviceImpl;

import com.rado.helpdesk.dto.TicketDTO;
import com.rado.helpdesk.repository.TicketRepository;
import com.rado.helpdesk.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public List<TicketDTO> getAllUsers() {
        return ticketRepository.findAll().stream()
                .map(ticket -> new TicketDTO(ticket.getTitle(),ticket.getDescription(),ticket.isStatus(),ticket.getPriority()))
                .collect(Collectors.toList());
    }
}
