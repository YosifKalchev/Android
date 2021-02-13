package com.example.recycle_view;

public class Task {

    private String title;
    private Difficulty difficulty;

    public Task(String title, Difficulty difficulty) {
        this.title = title;
        this.difficulty = difficulty;
    }

    public String getTitle() {
        return title;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }
}
