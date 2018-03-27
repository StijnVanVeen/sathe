package com.example.stijn.sath.domain;

import java.util.ArrayList;

/**
 * Created by stijn on 27-3-2018.
 */

public class Hall {
    private int hallNumber;
    private ArrayList<Seat> seats = new ArrayList<Seat>();

    public Hall(int hallNumber, ArrayList seats) {
        this.hallNumber = hallNumber;
        this.seats = seats;
    }

    public Hall(int hallNumber) {
        this.hallNumber = hallNumber;
        this.seats = new ArrayList<>();
    }

    public int getHallNumber() {
        return hallNumber;
    }

    public ArrayList getSeats() {
        return seats;
    }

    public void addSeat(Seat seat){
        seats.add(seat);
    }

    @Override
    public String toString() {
        return "Hall{" +
                "hallNumber=" + hallNumber +
                ", seats=" + seats +
                '}';
    }
}
