package poo.lab5.api.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import poo.lab5.api.entities.Ticket;

import java.util.List;

@Repository
public class TicketsRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Ticket> findAll(){
        List<Ticket> ticketsList = jdbcTemplate.query(
                "SELECT * FROM tickets",
                (response, rowNumber) ->  new Ticket(
                        response.getInt("id"),
                        response.getInt("movie_id"),
                        response.getInt("cinema_id"),
                        response.getInt("session"),
                        response.getByte("hall"),
                        response.getShort("place_row"),
                        response.getShort("place_column"),
                        response.getDouble("price")
                )
        );
        return ticketsList;
    }

    public Ticket findById(int id) {
        Ticket ticket = jdbcTemplate.queryForObject("SELECT * FROM tickets WHERE id = ? LIMIT 1",
                new Object[]{id},
                (response, rowNumber) -> new Ticket(
                        response.getInt("id"),
                        response.getInt("movie_id"),
                        response.getInt("cinema_id"),
                        response.getInt("session"),
                        response.getByte("hall"),
                        response.getShort("place_row"),
                        response.getShort("place_column"),
                        response.getDouble("price")
                )
        );
        return ticket;
    }

    public void create(Ticket ticket) {
        jdbcTemplate.update("" +
                "INSERT INTO tickets (movie_id, cinema_id, session, hall, place_row, place_column, price) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)",
                ticket.getMovie_id(),
                ticket.getCinema_id(),
                ticket.getSession(),
                ticket.getHall(),
                ticket.getPlace_row(),
                ticket.getPlace_column(),
                ticket.getPrice()
        );
    }

    public void update(int id, Ticket ticket) {
        jdbcTemplate.update("" +
                "UPDATE tickets SET movie_id = ?, cinema_id = ?, session = ?, hall = ?, place_row = ?, place_column = ?, price = ? WHERE id = ?;",
                ticket.getMovie_id(),
                ticket.getCinema_id(),
                ticket.getSession(),
                ticket.getHall(),
                ticket.getPlace_row(),
                ticket.getPlace_column(),
                ticket.getPrice(),
                id
        );
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM tickets WHERE slug = ?",id);
    }

}
