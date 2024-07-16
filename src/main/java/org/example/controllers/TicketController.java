package org.example.controllers;

import org.example.dto.PurchaseTicketDTO;
import org.example.services.impl.DomainTicketServiceImpl;
import org.example.services.impl.DomainTicketVoyageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    private final DomainTicketVoyageServiceImpl ticketVoyageService;
    private final DomainTicketServiceImpl ticketCustomerService;

    @Autowired
    public TicketController(DomainTicketVoyageServiceImpl ticketVoyageService, DomainTicketServiceImpl ticketCustomerService) {
        this.ticketVoyageService = ticketVoyageService;
        this.ticketCustomerService = ticketCustomerService;
    }

    @PostMapping("/refund/{ticketId}")
    public ResponseEntity<String> refundTicket(@PathVariable() Integer ticketId) {
        boolean isRefunded = ticketVoyageService.refundTicket(ticketId);
        if (isRefunded) {
            return ResponseEntity.ok("Билет успешно возвращен!");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Возврат билета невозможен");
        }
    }

    @PostMapping("/purchase")
    public ResponseEntity<PurchaseTicketDTO> purchaseTicket(PurchaseTicketDTO purchaseTicketDTO) {
        return ResponseEntity.ok(ticketCustomerService.purchaseTicket(purchaseTicketDTO));
    }
}
