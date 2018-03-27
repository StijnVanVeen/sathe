package com.example.stijn.sath.domain;

/**
 * Created by stijn on 27-3-2018.
 */

public class Seat {
    private int seatNumber;
    private int hallNumber;

    public Seat(int seatNumber, int hallNumber) {
        this.seatNumber = seatNumber;
        this.hallNumber = hallNumber;
    }

    public int getHallNumber() {
        return hallNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "seatNumber=" + seatNumber +
                ", hallNumber=" + hallNumber +
                '}';
    }
}
