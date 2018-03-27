package com.example.stijn.sath.domain;

/**
 * Created by stijn on 27-3-2018.
 */

public class CinemaReview {
    private int id;
    private String author;
    private String review;

    public CinemaReview(int id, String author, String review) {
        this.id = id;
        this.author = author;
        this.review = review;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getReview() {
        return review;
    }

    @Override
    public String toString() {
        return "CinemaReview{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", review='" + review + '\'' +
                '}';
    }
}
