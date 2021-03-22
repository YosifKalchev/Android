package com.example.movie_review_app.models;

import com.example.movie_review_app.constants.Crew;
import com.example.movie_review_app.constants.Grade;
import com.example.movie_review_app.constants.Review;

public class Movie {

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

    public Movie(String name, int yearOfPublish, int id, Review review, Grade grade, Crew crew) {
        this.name = name;
        this.yearOfPublish = yearOfPublish;
        this.review = review;
        this.grade = grade;
        this.crew = crew;
        this.id = id;
    }
}
