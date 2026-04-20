package com.ticketing.ticketapi.controller;

import com.ticketing.ticketapi.model.Ticket;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @PostMapping
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
        System.out.println(" ----------------- Ticket API Invoked ------------");
        ticket.setCreationDate(LocalDate.now().toString());
        ticket.setStatus("success");
        return ResponseEntity.ok(ticket);
    }
}
