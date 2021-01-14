package poo.lab5.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import poo.lab5.api.entities.Movie;
import poo.lab5.api.repositories.MoviesRepository;

import java.util.List;

@RestController
@RequestMapping("/movies")

public class MoviesController {

    @Autowired
    private MoviesRepository moviesRepository;

    @GetMapping
    public List<Movie> findAll() {
        List<Movie> moviesList = moviesRepository.findAll();
        return moviesList;
    }

    @GetMapping("/{slug}")
    public Movie findBySlug(@PathVariable String slug) {
        Movie movie = moviesRepository.findBySlug(slug);
        return movie;
    }


    @PostMapping("/create")
    public void create(@RequestBody Movie movie) {
        moviesRepository.create(movie);
    }

    @PutMapping("/update/{slug}")
    public void update(@PathVariable String slug, @RequestBody Movie movie) {
        moviesRepository.update(slug, movie);
    }

    @DeleteMapping("/delete/{slug}")
    public void delete(@PathVariable String slug) {
        moviesRepository.delete(slug);
    }
}
