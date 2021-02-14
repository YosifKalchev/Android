package com.example.recycle_view;

public class Task {

    private final String title;
    private final Difficulty difficulty;
    private boolean isDone;

    public Task(String title, Difficulty difficulty) {
        this.title = title;
        this.difficulty = difficulty;
        this.isDone = false;
    }

    public String getTitle() {
        return title;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }
}
