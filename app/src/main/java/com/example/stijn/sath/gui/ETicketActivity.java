package com.example.stijn.sath.gui;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.stijn.sath.dataAccess.ETicketDatabaseHelper;
import com.example.stijn.sath.gui.adapters.ETicketAdapter;
import com.example.stijn.sath.domain.ETicket;

import java.util.ArrayList;

import com.example.stijn.sath.R;

public class ETicketActivity extends AppCompatActivity {

    private ArrayList<ETicket> tickets = new ArrayList<>();
    private ETicketAdapter adapter;
    private SQLiteDatabase database;
    private Cursor cursor;
    private static final String TAG = ETicketActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eticket);

        ListView listView = findViewById(R.id.LV_etickets);
        adapter = new ETicketAdapter(tickets, getLayoutInflater());
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        ETicketDatabaseHelper eTicketDatabaseHelper = new ETicketDatabaseHelper(getApplicationContext());
        database = eTicketDatabaseHelper.getWritableDatabase();
        loadETicketsFromDatabase();
    }

    private boolean checkIfInDatabase(){
        Log.i(TAG, "checkIfInDatabase(): is checking..");
        try {
            cursor = database.rawQuery("SELECT * FROM ticket LIMIT 1", null);
        }catch (SQLException e){
            Log.e(TAG, "checkIfInDatabase(): Failed..");
            e.printStackTrace();
        }

        if(!cursor.moveToFirst()){
            Log.i(TAG, "checkIfInDatabase(): Cursor is empty.." );
            return false;
        }
        Log.i(TAG, "checkIfInDatabase(): cursor is filled, database not empty..");
        return true;
    }

    public void loadETicketsFromDatabase(){
        Log.i(TAG, "loadETicketsFromDatabase(): Loading all etickets from the database");
        tickets.clear();
        if(checkIfInDatabase()){
            cursor = database.rawQuery("SELECT * FROM ticket", null);
            try {
                while (cursor.moveToNext()){
                    String ticketNumber = String.valueOf(cursor.getInt(cursor.getColumnIndex("ticketNummer")));
                    String filmName = cursor.getString(cursor.getColumnIndex("filmName"));
                    int seat = cursor.getInt(cursor.getColumnIndex("seat"));
                    int hall = cursor.getInt(cursor.getColumnIndex("hall"));
                    ETicket ticket = new ETicket(Integer.valueOf(ticketNumber), seat, hall, filmName);
                    tickets.add(ticket);
                }
            }finally {
                cursor.close();
                adapter.notifyDataSetChanged();
            }
        }
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
