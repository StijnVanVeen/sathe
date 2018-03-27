package com.example.stijn.sath.domain;

import android.widget.ImageButton;

import java.io.Serializable;

/**
 * Created by stijn on 27-3-2018.
 */

public class Seat implements Serializable {
    private int seatNumber;
    private int hallNumber;
    private ImageButton seatObject;
    private boolean reserved;

    public Seat(int seatNumber, int hallNumber, ImageButton seatObject) {
        this.seatNumber = seatNumber;
        this.hallNumber = hallNumber;
        this.seatObject = seatObject;
        this.reserved = false;
    }

    public int getHallNumber() {
        return hallNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public ImageButton getSeatObject() {
        return seatObject;
    }

    public boolean getReserved() {
        return reserved;
    }

    public void toggleReservation() {
        if (!reserved) {
            reserved = true;
        } else {
            reserved = false;
        }
    }

    @Override
    public String toString() {
        return "Seat{" +
                "seatNumber=" + seatNumber +
                ", hallNumber=" + hallNumber +
                '}';
    }
}
