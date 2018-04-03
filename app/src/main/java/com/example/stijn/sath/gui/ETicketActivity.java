package com.example.stijn.sath.gui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.stijn.sath.gui.adapters.ETicketAdapter;
import com.example.stijn.sath.domain.ETicket;

import java.util.ArrayList;

import com.example.stijn.sath.R;

public class ETicketActivity extends AppCompatActivity {

    private ArrayList<ETicket> tickets = new ArrayList<>();
    private ETicketAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eticket);

        ListView listView = findViewById(R.id.LV_etickets);
        adapter = new ETicketAdapter(tickets, getLayoutInflater());
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        ETicket tic = new ETicket(1234, 2, 1, "Avenger");
        tickets.add(tic);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.available_activities, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        Intent i;
        switch (id) {
            case R.id.mnuMyTickets:
                break;
            case R.id.mnuFilms:
                i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
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
