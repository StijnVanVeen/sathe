package com.example.stijn.sath;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class FilmDetailActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_detail);

        Bundle extras = getIntent().getExtras();

        ImageView filmPoster = findViewById(R.id.filmPoster);
        TextView filmTitle = findViewById(R.id.filmTitle);
        TextView description = findViewById(R.id.filmDescription);
        Button orderTickets = findViewById(R.id.btnOrder);

        String imageURL = extras.getString(MainActivity.IMAGEURL);
        String filmName = extras.getString(MainActivity.FILMNAME);
        String filmDescription = extras.getString(MainActivity.FILMDESCRIPTION);

        description.setText(filmDescription);
        description.setMovementMethod(new ScrollingMovementMethod());
        filmTitle.setText(filmName);
        Picasso.with(getApplicationContext()).load(imageURL).into(filmPoster);
        orderTickets.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(getApplicationContext(), OrderOptionsActivity.class);
        startActivity(i);
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
        switch(id){
            case R.id.mnuMyTickets:
                i = new Intent(getApplicationContext(), ETicketActivity.class);
                startActivity(i);
                break;
            case R.id.mnuFilms:
                i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                break;
            case R.id.mnuContact:
                i = new Intent(getApplicationContext(), CinemaAbout.class);
                startActivity(i);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}
