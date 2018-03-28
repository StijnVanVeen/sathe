package com.example.stijn.sath;

/**
 * Created by btaks on 27-3-2018.
 */

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.stijn.sath.domain.Cinema;
import com.example.stijn.sath.domain.Hall;
import com.example.stijn.sath.domain.Seat;

import java.util.ArrayList;

public class ChairActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chair);

        //Intent i = getIntent();
        //Cinema c = (Cinema) i.getSerializableExtra("cinema");
        //Hall h = c.getMainHall();
        Cinema c = new Cinema("Sathé", "Lovensdijkstraat 61", "Breda", "4818AJ");
        Hall h = new Hall(1);
        h.addSeat(new Seat(1, 1, (ImageButton) findViewById(R.id.R1S1)));
        h.addSeat(new Seat(2, 1, (ImageButton) findViewById(R.id.R1S2)));
        h.addSeat(new Seat(3, 1, (ImageButton) findViewById(R.id.R1S3)));
        h.addSeat(new Seat(4, 1, (ImageButton) findViewById(R.id.R1S4)));
        h.addSeat(new Seat(5, 1, (ImageButton) findViewById(R.id.R1S5)));
        h.addSeat(new Seat(6, 1, (ImageButton) findViewById(R.id.R1S6)));
        h.addSeat(new Seat(7, 1, (ImageButton) findViewById(R.id.R1S7)));
        h.addSeat(new Seat(8, 1, (ImageButton) findViewById(R.id.R1S8)));
        h.addSeat(new Seat(1, 1, (ImageButton) findViewById(R.id.R2S1)));
        h.addSeat(new Seat(2, 1, (ImageButton) findViewById(R.id.R2S2)));
        h.addSeat(new Seat(3, 1, (ImageButton) findViewById(R.id.R2S3)));
        h.addSeat(new Seat(4, 1, (ImageButton) findViewById(R.id.R2S4)));
        h.addSeat(new Seat(5, 1, (ImageButton) findViewById(R.id.R2S5)));
        h.addSeat(new Seat(6, 1, (ImageButton) findViewById(R.id.R2S6)));
        h.addSeat(new Seat(7, 1, (ImageButton) findViewById(R.id.R2S7)));
        h.addSeat(new Seat(8, 1, (ImageButton) findViewById(R.id.R2S8)));
        h.addSeat(new Seat(1, 1, (ImageButton) findViewById(R.id.R3S1)));
        h.addSeat(new Seat(2, 1, (ImageButton) findViewById(R.id.R3S2)));
        h.addSeat(new Seat(3, 1, (ImageButton) findViewById(R.id.R3S3)));
        h.addSeat(new Seat(4, 1, (ImageButton) findViewById(R.id.R3S4)));
        h.addSeat(new Seat(5, 1, (ImageButton) findViewById(R.id.R3S5)));
        h.addSeat(new Seat(6, 1, (ImageButton) findViewById(R.id.R3S6)));
        h.addSeat(new Seat(7, 1, (ImageButton) findViewById(R.id.R3S7)));
        h.addSeat(new Seat(8, 1, (ImageButton) findViewById(R.id.R3S8)));
        h.addSeat(new Seat(1, 1, (ImageButton) findViewById(R.id.R4S1)));
        h.addSeat(new Seat(2, 1, (ImageButton) findViewById(R.id.R4S2)));
        h.addSeat(new Seat(3, 1, (ImageButton) findViewById(R.id.R4S3)));
        h.addSeat(new Seat(4, 1, (ImageButton) findViewById(R.id.R4S4)));
        h.addSeat(new Seat(5, 1, (ImageButton) findViewById(R.id.R4S5)));
        h.addSeat(new Seat(6, 1, (ImageButton) findViewById(R.id.R4S6)));
        h.addSeat(new Seat(7, 1, (ImageButton) findViewById(R.id.R4S7)));
        h.addSeat(new Seat(8, 1, (ImageButton) findViewById(R.id.R4S8)));
        ArrayList<Seat> seats = h.getSeats();
        for (final Seat seat : seats) {
            final ImageButton seatObject = seat.getSeatObject();
            seatObject.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!seat.getReserved()) {
                        seatObject.setColorFilter(Color.parseColor("#12D559"));
                    } else {
                        seatObject.setColorFilter(Color.parseColor("#FFFFFF"));
                    }
                    seat.toggleReservation();
                }
            });
        }
    }
}

