package com.rado.helpdesk.dto;

import com.rado.helpdesk.model.Priority;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TicketDTO {
    private String title;
    private String description;
    private boolean status;
    private Priority priority;
}
