package com.example.stijn.sath.domain;

/**
 * Created by stijn on 27-3-2018.
 */

public class ETicket {
    private int ticketNumber;
    private int seatNumber;
    private int hallNumber;
    private String filmName;

    public ETicket(int ticketNumber, int seatNumber, int hallNumber, String filmName) {
        this.ticketNumber = ticketNumber;
        this.seatNumber = seatNumber;
        this.hallNumber = hallNumber;
        this.filmName = filmName;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public int getHallNumber() {
        return hallNumber;
    }

    public String getFilm() {
        return filmName;
    }

    @Override
    public String toString() {
        return "ETicket{" +
                "ticketNumber=" + ticketNumber +
                ", seatNumber=" + seatNumber +
                ", hallNumber=" + hallNumber +
                ", film=" + filmName +
                '}';
    }
}
