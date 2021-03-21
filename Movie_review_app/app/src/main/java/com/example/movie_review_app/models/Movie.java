package com.example.movie_review_app.models;

import com.example.movie_review_app.constants.Crew;
import com.example.movie_review_app.constants.Grade;
import com.example.movie_review_app.constants.Review;

import java.util.List;

public class Movie {

    private static int counter = 1;
    private final String name;
    private final int id;
    private final int yearOfPublish;
    private final Review review;
    private final Grade grade;
    private final Crew crew;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getYearOfPublish() {
        return yearOfPublish;
    }

    public Review getReview() {
        return review;
    }

    public Grade getGrade() {
        return grade;
    }

    public Crew getCrew() {
        return crew;
    }

    public Movie(String name, int yearOfPublish, Review review, Grade grade, Crew crew) {
        this.name = name;
        this.id = counter;
        this.yearOfPublish = yearOfPublish;
        this.review = review;
        this.grade = grade;
        this.crew = crew;
        counter++;
    }
}
