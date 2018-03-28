package com.example.stijn.sath;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.stijn.sath.domain.FilmReview;

import java.util.ArrayList;

/**
 * Created by stijn on 28-3-2018.
 */

public class FilmReviewAdapter extends BaseAdapter{
    private ArrayList filmReviewArray;
    private LayoutInflater inflater;

    public FilmReviewAdapter(ArrayList filmReviewArray, LayoutInflater inflater) {
        this.filmReviewArray = filmReviewArray;
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        int size = filmReviewArray.size();
        return size;
    }

    @Override
    public Object getItem(int i) {
        FilmReview fr = (FilmReview) filmReviewArray.get(i);
        return fr;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;

        if(view == null){
            view = inflater.inflate(R.layout.list_film_review_row, null);
            viewHolder = new ViewHolder();
            viewHolder.author = view.findViewById(R.id.TV_author_name);
            viewHolder.content = view.findViewById(R.id.TV_film_review_content);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        FilmReview fr = (FilmReview) filmReviewArray.get(i);
        viewHolder.author.setText(fr.getAuthor());
        viewHolder.content.setText(fr.getContent());
        return view;
    }

    private static class ViewHolder{
        TextView author;
        TextView content;
    }
}
