package com.example.stijn.sath;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.stijn.sath.domain.Film;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by kelly on 27-3-2018.
 */

public class FilmAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInflator;
    private ArrayList<Film> films;

    public FilmAdapter(Context mContext, LayoutInflater mInflator, ArrayList<Film> films) {
        this.mContext = mContext;
        this.mInflator = mInflator;
        this.films = films;
    }

    @Override
    public int getCount() {
        return films.size();
    }

    @Override
    public Object getItem(int i) {
        return films.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder;

        if (view == null){
            view = mInflator.inflate(R.layout.grd_film_row, null);

            viewHolder = new ViewHolder();

            viewHolder.filmPoster = view.findViewById(R.id.grdFilmPoster);
            viewHolder.filmTitle = view.findViewById(R.id.grdFilmTitle);

            view.setTag(viewHolder);
        } else{
            viewHolder = (ViewHolder) view.getTag();
        }

        Film film = films.get(i);
        String imageURL = film.getImageURL();
        String filmTitle = film.getName();

        viewHolder.filmTitle.setText(filmTitle);

        Picasso.with(mContext).load(imageURL).into(viewHolder.filmPoster);

        return view;
    }

    public static class ViewHolder{
        public ImageView filmPoster;
        public TextView filmTitle;
    }
}
