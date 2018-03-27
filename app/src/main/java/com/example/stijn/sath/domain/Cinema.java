package com.example.stijn.sath.domain;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by stijn on 27-3-2018.
 */

public class Cinema implements Serializable {
    private String name;
    private String adress;
    private String city;
    private String zipcode;
    private ArrayList<CinemaReview> cinemaReviews = new ArrayList<>();
    private ArrayList<Hall> halls = new ArrayList<>();

    public Cinema(String name, String adress, String city, String zipcode, ArrayList<CinemaReview> cinemaReviews, ArrayList<Hall> halls) {
        this.name = name;
        this.adress = adress;
        this.city = city;
        this.zipcode = zipcode;
        this.cinemaReviews = cinemaReviews;
        this.halls = halls;
    }

    public Cinema(String name, String adress, String city, String zipcode) {
        this.name = name;
        this.adress = adress;
        this.city = city;
        this.zipcode = zipcode;
        this.cinemaReviews = new ArrayList<>();
        this.halls = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getAdress() {
        return adress;
    }

    public String getCity() {
        return city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public ArrayList getCinemaReviews() {
        return cinemaReviews;
    }

    public Hall getMainHall() {
        if (halls != null) {
            return halls.get(0);
        }
        return null;
    }

    public ArrayList getHalls() {
        return halls;
    }

    public void addHall(Hall hall){
        halls.add(hall);
    }

    public void addReview(CinemaReview cinemaReview){
        cinemaReviews.add(cinemaReview);
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", city='" + city + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", cinemaReviews=" + cinemaReviews +
                ", halls=" + halls +
                '}';
    }
}
