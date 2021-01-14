package poo.lab5.api.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import poo.lab5.api.entities.Cinema;

import java.util.Date;
import java.util.List;

@Repository
public class CinemasRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public List<Cinema> findAll(){
        List<Cinema> cinemasList = jdbcTemplate.query(
                "SELECT * FROM cinemas",
                (response, rowNumber) -> new Cinema(
                        response.getInt("id"),
                        response.getString("name"),
                        response.getString("address"),
                        response.getString("country"),
                        response.getString("region")
                )
        );
        return cinemasList;
    }

    public Cinema findById(int id) {
        Cinema cinema = jdbcTemplate.queryForObject("SELECT * FROM cinemas WHERE id = ? LIMIT 1",
                new Object[]{id},
                (response, rowNumber) -> new Cinema(
                        response.getInt("id"),
                        response.getString("name"),
                        response.getString("address"),
                        response.getString("country"),
                        response.getString("region")
                )
        );
        return cinema;
    }


    public void createFromParams(String name, String address, String country, String region) {
        jdbcTemplate.update("" +
                        "INSERT INTO cinemas (name, address, country, region) " +
                        "VALUES (?, ?, ?, ?)",
                name,
                address,
                country,
                region
        );

    }


    public void create(Cinema cinema) {
        jdbcTemplate.update("" +
                "INSERT INTO cinemas (name, address, country, region) " +
                "VALUES (?, ?, ?, ?)",
                cinema.getName(),
                cinema.getAddress(),
                cinema.getCountry(),
                cinema.getRegion()
        );
    }

    public void update(int id, Cinema cinema) {
        jdbcTemplate.update("" +
                        "UPDATE cinemas SET name = ?, address = ?, country = ?, region = ? WHERE id = ?;",
                cinema.getName(),
                cinema.getAddress(),
                cinema.getCountry(),
                cinema.getRegion(),
                id
        );
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM cinemas WHERE id = ?",id);
    }

}
