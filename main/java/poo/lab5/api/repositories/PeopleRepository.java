package poo.lab5.api.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import poo.lab5.api.entities.Person;

import java.util.Date;
import java.util.List;

@Repository
public class PeopleRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public List<Person> findAll(){
        List<Person> personList = jdbcTemplate.query(
                "SELECT * FROM people",
                (response, rowNumber) -> new Person(
                        response.getInt("id"),
                        response.getString("firstname"),
                        response.getString("lastname"),
                        response.getDate("birthdate"),
                        response.getString("country")
                )
        );
        return personList;
    }

    public Person findById(int id) {
        Person person = jdbcTemplate.queryForObject("SELECT * FROM people WHERE id = ? LIMIT 1",
                new Object[]{id},
                (response, rowNumber) -> new Person(
                        response.getInt("id"),
                        response.getString("firstname"),
                        response.getString("lastname"),
                        response.getDate("birthdate"),
                        response.getString("country")
                )
        );
        return person;
    }

    public void create(Person person) {
        jdbcTemplate.update("" +
                "INSERT INTO people (firstname, lastname, birthdate, country) " +
                "VALUES (?, ?, ?, ?)",
                person.getFirstname(),
                person.getLastname(),
                person.getBirthdate(),
                person.getCountry()
        );
    }


    public void update(int id, Person person) {
        jdbcTemplate.update("" +
                "UPDATE people SET firstname = ?, lastname = ?, birthdate = ?, country = ? WHERE id = ?;",
                person.getFirstname(),
                person.getLastname(),
                person.getBirthdate(),
                person.getCountry(),
                id
        );
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM people WHERE id = ?",id);
    }

}
