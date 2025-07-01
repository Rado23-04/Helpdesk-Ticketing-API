package com.rado.helpdesk.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false, unique = true)
    private String description;

    @Column(nullable = false)
    private boolean status;

    @Column(nullable = false)
    private Priority priority;

    @ManyToOne
    @JoinColumn(name = "assigned_user_id")
    private User assignedUser;
}
