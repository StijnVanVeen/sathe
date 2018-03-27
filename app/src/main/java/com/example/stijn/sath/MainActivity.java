package com.example.stijn.sath;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.stijn.sath.domain.Cinema;
import com.example.stijn.sath.domain.Film;
import com.example.stijn.sath.domain.Hall;
import com.example.stijn.sath.domain.Seat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Film> films = new ArrayList<>();
    private final static String TAG = MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Cinema c = new Cinema("Sathé", "lovensdijkstraatjtfytcgc 112", "breda", "idk");
        Hall h = new Hall(1);
        Seat s1 = new Seat(1, h.getHallNumber());
        h.addSeat(s1);
        Seat s2 = new Seat(2, h.getHallNumber());
        h.addSeat(s2);
        Seat s3 = new Seat(3, h.getHallNumber());
        h.addSeat(s3);
        Seat s4 = new Seat(4, h.getHallNumber());
        h.addSeat(s4);
        c.addHall(h);


        Film f = new Film(1, "the hangover", "comedy", "3:00", "doet aan kim denken", 12, h, null);

        Log.i("fuck you", f.toString());

    }
}
