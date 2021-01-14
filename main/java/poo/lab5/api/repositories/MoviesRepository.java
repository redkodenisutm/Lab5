package poo.lab5.api.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import poo.lab5.api.entities.Movie;
import poo.lab5.api.entities.Person;

import java.util.List;

@Repository
public class MoviesRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Movie> findAll(){
        List<Movie> moviesList = jdbcTemplate.query(
                "SELECT * FROM movies",
                (response, rowNumber) ->  new Movie(
                            response.getInt("id"),
                            response.getString("slug"),
                            response.getString("title"),
                            response.getString("genre"),
                            response.getString("description"),
                            response.getString("country"),
                            response.getInt("director"),
                            response.getFloat("buget"),
                            response.getInt("year")
                )
        );
        return moviesList;
    }

    public Movie findBySlug(String slug) {
        Movie movie = jdbcTemplate.queryForObject("SELECT * FROM movies WHERE slug = ? LIMIT 1",
                new Object[]{slug},
                (response, rowNumber) -> new Movie(
                        response.getInt("id"),
                        response.getString("slug"),
                        response.getString("title"),
                        response.getString("genre"),
                        response.getString("description"),
                        response.getString("country"),
                        response.getInt("director"),
                        response.getFloat("buget"),
                        response.getInt("year")
                )
        );
        return movie;
    }

    public void create(Movie movie) {
        jdbcTemplate.update("" +
                "INSERT INTO movies (slug, title, genre, description, country, director, buget, year) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
                movie.getSlug(),
                movie.getTitle(),
                movie.getGenre(),
                movie.getDescription(),
                movie.getCountry(),
                movie.getDirector(),
                movie.getBuget(),
                movie.getYear()
        );
    }

    public void update(String slug, Movie movie) {
        jdbcTemplate.update("" +
                "UPDATE movies SET slug = ?, title = ?, genre = ?, description = ?, country = ?, director = ?, buget = ?, year = ? WHERE slug = ?;",
                movie.getSlug(),
                movie.getTitle(),
                movie.getGenre(),
                movie.getDescription(),
                movie.getCountry(),
                movie.getDirector(),
                movie.getBuget(),
                movie.getYear(),
                slug
        );
    }

    public void delete(String slug) {
        jdbcTemplate.update("DELETE FROM movies WHERE slug = ?",slug);
    }

}
