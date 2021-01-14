package poo.lab5.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import poo.lab5.api.entities.Person;
import poo.lab5.api.repositories.PeopleRepository;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/people")

public class PeopleController {

    @Autowired
    private PeopleRepository  peopleRepository;

    @GetMapping
    public List<Person> findAll() {
        List<Person> personsList = peopleRepository.findAll();
        return personsList;
    }

    @GetMapping("/{id}")
    public Person findById(@PathVariable int id) {
        Person person = peopleRepository.findById(id);
        return person;
    }


    @PostMapping("/create")
    public void create(@RequestBody Person person) {
        peopleRepository.create(person);
    }


    @PutMapping("/update/{id}")
    public void update(@PathVariable int id, @RequestBody Person person) {
        peopleRepository.update(id, person);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        peopleRepository.delete(id);
    }
}
