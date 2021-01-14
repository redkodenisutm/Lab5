package poo.lab5.api.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter

public class Ticket {
    private int id;
    private int movie_id;
    private int cinema_id;
    private int session;
    private byte hall;
    private short place_row;
    private short place_column;
    private double price;


    public Ticket(int id, int movie_id, int cinema_id, int session, byte hall, short place_row, short place_column, double price) {
        this.id = id;
        this.movie_id = movie_id;
        this.cinema_id = cinema_id;
        this.session = session;
        this.hall = hall;
        this.place_row = place_row;
        this.place_column = place_column;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public int getCinema_id() {
        return cinema_id;
    }

    public void setCinema_id(int cinema_id) {
        this.cinema_id = cinema_id;
    }

    public int getSession() {
        return session;
    }

    public void setSession(int session) {
        this.session = session;
    }

    public byte getHall() {
        return hall;
    }

    public void setHall(byte hall) {
        this.hall = hall;
    }

    public short getPlace_row() {
        return place_row;
    }

    public void setPlace_row(short place_row) {
        this.place_row = place_row;
    }

    public short getPlace_column() {
        return place_column;
    }

    public void setPlace_column(short place_column) {
        this.place_column = place_column;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
