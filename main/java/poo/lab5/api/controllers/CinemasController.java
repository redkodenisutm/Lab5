package poo.lab5.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import poo.lab5.api.entities.Cinema;
import poo.lab5.api.repositories.CinemasRepository;

import java.util.List;

@RestController
@RequestMapping("/cinemas")

public class CinemasController {

    @Autowired
    private CinemasRepository  cinemasRepository;

    @GetMapping
    public List<Cinema> findAll() {
        List<Cinema> cinemasList = cinemasRepository.findAll();
        return cinemasList;
    }

    @GetMapping("/{id}")
    public Cinema findById(@PathVariable int id) {
        Cinema cinema = cinemasRepository.findById(id);
        return cinema;
    }

    @GetMapping("/create/params")
    public void create(@RequestParam String name, @RequestParam String address, @RequestParam String country, @RequestParam String region) {
        cinemasRepository.createFromParams(name, address, country, region);
    }

    @PostMapping("/create")
    public void create(@RequestBody Cinema cinema) {
        cinemasRepository.create(cinema);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable int id, @RequestBody Cinema cinema) {
        cinemasRepository.update(id, cinema);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        cinemasRepository.delete(id);
    }
}
