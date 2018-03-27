package com.example.stijn.sath.domain;

/**
 * Created by stijn on 27-3-2018.
 */

public class FilmReview {
    private int id;
    private String author;
    private String content;

    public FilmReview(int id, String author, String content) {
        this.id = id;
        this.author = author;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "FilmReview{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
