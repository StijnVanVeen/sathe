package com.example.stijn.sath.gui;

/**
 * Created by btaks on 27-3-2018.
 */

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.stijn.sath.R;
import com.example.stijn.sath.domain.Cinema;
import com.example.stijn.sath.domain.Hall;
import com.example.stijn.sath.domain.Seat;

import java.util.ArrayList;

public class ChairActivity extends AppCompatActivity {
    private ArrayList<Seat> seats;
    private String filmName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chair);

        Intent i = getIntent();
        filmName = i.getStringExtra("filmName");
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
        h.addSeat(new Seat(9, 1, (ImageButton) findViewById(R.id.R2S1)));
        h.addSeat(new Seat(10, 1, (ImageButton) findViewById(R.id.R2S2)));
        h.addSeat(new Seat(11, 1, (ImageButton) findViewById(R.id.R2S3)));
        h.addSeat(new Seat(12, 1, (ImageButton) findViewById(R.id.R2S4)));
        h.addSeat(new Seat(13, 1, (ImageButton) findViewById(R.id.R2S5)));
        h.addSeat(new Seat(14, 1, (ImageButton) findViewById(R.id.R2S6)));
        h.addSeat(new Seat(15, 1, (ImageButton) findViewById(R.id.R2S7)));
        h.addSeat(new Seat(16, 1, (ImageButton) findViewById(R.id.R2S8)));
        h.addSeat(new Seat(17, 1, (ImageButton) findViewById(R.id.R3S1)));
        h.addSeat(new Seat(18, 1, (ImageButton) findViewById(R.id.R3S2)));
        h.addSeat(new Seat(19, 1, (ImageButton) findViewById(R.id.R3S3)));
        h.addSeat(new Seat(20, 1, (ImageButton) findViewById(R.id.R3S4)));
        h.addSeat(new Seat(21, 1, (ImageButton) findViewById(R.id.R3S5)));
        h.addSeat(new Seat(22, 1, (ImageButton) findViewById(R.id.R3S6)));
        h.addSeat(new Seat(23, 1, (ImageButton) findViewById(R.id.R3S7)));
        h.addSeat(new Seat(24, 1, (ImageButton) findViewById(R.id.R3S8)));
        h.addSeat(new Seat(25, 1, (ImageButton) findViewById(R.id.R4S1)));
        h.addSeat(new Seat(26, 1, (ImageButton) findViewById(R.id.R4S2)));
        h.addSeat(new Seat(27, 1, (ImageButton) findViewById(R.id.R4S3)));
        h.addSeat(new Seat(28, 1, (ImageButton) findViewById(R.id.R4S4)));
        h.addSeat(new Seat(29, 1, (ImageButton) findViewById(R.id.R4S5)));
        h.addSeat(new Seat(30, 1, (ImageButton) findViewById(R.id.R4S6)));
        h.addSeat(new Seat(31, 1, (ImageButton) findViewById(R.id.R4S7)));
        h.addSeat(new Seat(32, 1, (ImageButton) findViewById(R.id.R4S8)));
        seats = h.getSeats();
        for (final Seat seat : seats) {
            final ImageButton seatObject = seat.getSeatObject();
            seatObject.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!seat.getReserved()) {
                        seatObject.setColorFilter(Color.parseColor("#12D559"));
                    } else {
                        seatObject.setColorFilter(Color.parseColor("#000000"));
                    }
                    seat.toggleReservation();
                }
            });
        }

        Button btnConfirm = (Button) findViewById(R.id.btnConfirm);
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList seatss = new ArrayList<>();
                int seatsTaken = 0;
                for (Seat seat : seats) {
                    if (seat.getReserved()) {
                        seatsTaken++;
                        seatss.add(seat.getSeatNumber());
                    }
                }
                Intent i = new Intent(getApplicationContext(), PaymentActivity.class);
                i.putExtra("seatsTaken", seatsTaken);
                i.putExtra("seatList", seatss);
                i.putExtra("filmName" , filmName);
                startActivity(i);
            }
        });
    }

    //adds custom menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.available_activities, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        Intent i;
        switch(id){
            case R.id.mnuMyTickets:
                i = new Intent(getApplicationContext(), ETicketActivity.class);
                startActivity(i);
                break;
            case R.id.mnuFilms:
                break;
            case R.id.mnuContact:
                i = new Intent(getApplicationContext(), CinemaAboutActivity.class);
                startActivity(i);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}

