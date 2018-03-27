package com.example.stijn.sath.domain;

import java.util.ArrayList;

/**
 * Created by stijn on 27-3-2018.
 */

public class Film {
    private int id;
    private String name;
    private String genre;
    private String duration;
    private String desription;
    private int pegi;
    private Hall hall;
    private ArrayList<FilmReview> filmreviews = new ArrayList<>();

    public Film(int id, String name, String genre, String duration, String desription, int pegi, Hall hall, ArrayList<FilmReview> filmreviews) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.duration = duration;
        this.desription = desription;
        this.pegi = pegi;
        this.hall = hall;
        this.filmreviews = filmreviews;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public String getDuration() {
        return duration;
    }

    public String getDesription() {
        return desription;
    }

    public int getPegi() {
        return pegi;
    }

    public Hall getHall() {
        return hall;
    }

    public ArrayList<FilmReview> getFilmreviews() {
        return filmreviews;
    }

    public void addFilmReview(FilmReview filmReview){
        filmreviews.add(filmReview);
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", duration='" + duration + '\'' +
                ", desription='" + desription + '\'' +
                ", pegi=" + pegi +
                ", hall=" + hall +
                ", filmreviews=" + filmreviews +
                '}';
    }
}
