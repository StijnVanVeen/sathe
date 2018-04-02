package com.example.stijn.sath.gui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.stijn.sath.dataAccess.FilmReviewAPI;
import com.example.stijn.sath.gui.adapters.FilmReviewAdapter;
import com.example.stijn.sath.R;
import com.example.stijn.sath.domain.FilmReview;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FilmDetailActivity extends AppCompatActivity implements View.OnClickListener, FilmReviewAPI.OnReviewAvailable {

    private ArrayList<FilmReview> filmReviews = new ArrayList<>();
    private FilmReviewAdapter filmReviewAdapter = null;

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
        int filmID = extras.getInt("filmID");

        fetchReviews(filmID);

        ListView reviewListView = findViewById(R.id.reviewsList);
        filmReviewAdapter = new FilmReviewAdapter(filmReviews, getLayoutInflater());
        reviewListView.setAdapter(filmReviewAdapter);
        filmReviewAdapter.notifyDataSetChanged();

        description.setText(filmDescription);
        description.setMovementMethod(new ScrollingMovementMethod());
        filmTitle.setText(filmName);
        Picasso.with(getApplicationContext()).load(imageURL).into(filmPoster);
        orderTickets.setOnClickListener(this);
    }

    private void fetchReviews(int filmID) {
        FilmReviewAPI task = new FilmReviewAPI(this);
        String url = "https://api.themoviedb.org/3/movie/" + filmID + "/reviews?api_key=6edfc04651891fd32f7c7b7a98565c08&language=en-US&page=1";
        task.execute(url);
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

    @Override
    public void onReviewAvailable(FilmReview filmReview) {
        filmReviews.add(filmReview);
        filmReviewAdapter.notifyDataSetChanged();
    }
}
