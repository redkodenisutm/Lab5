package poo.lab5.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import poo.lab5.api.entities.Ticket;
import poo.lab5.api.repositories.TicketsRepository;

import java.util.List;

@RestController
@RequestMapping("/tickets")

public class TicketsController {

    @Autowired
    private TicketsRepository ticketsRepository;

    @GetMapping
    public List<Ticket> findAll() {
        List<Ticket> ticketsList = ticketsRepository.findAll();
        return ticketsList;
    }

    @GetMapping("/{id}")
    public Ticket findById(@PathVariable int id) {
        Ticket ticket = ticketsRepository.findById(id);
        return ticket;
    }


    @PostMapping("/create")
    public void create(@RequestBody Ticket ticket) {
        ticketsRepository.create(ticket);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable int id, @RequestBody Ticket ticket) {
        ticketsRepository.update(id, ticket);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        ticketsRepository.delete(id);
    }
}
