package com.example.quizproject.models;

public class Game {

    String icon;
    String title;
    String difficulty;
    String firstCategory;
    String secondCategory;
    String dateLastPlayed;
    Player topPlayer;


    public Game() {

    }

    public Game(String title, String difficulty, String firstTopic, String secondTopic) {
        this.title = title;
        this.difficulty = difficulty;
        this.firstCategory = firstTopic;
        this.secondCategory = secondTopic;
        this.dateLastPlayed = "TestDate: 12.04.2021";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getFirstCategory() {
        return firstCategory;
    }

    public void setFirstCategory(String firstCategory) {
        this.firstCategory = firstCategory;
    }

    public String getSecondCategory() {
        return secondCategory;
    }

    public void setSecondCategory(String secondCategory) {
        this.secondCategory = secondCategory;
    }

    public String getDateLastPlayed() {
        return dateLastPlayed;
    }

    public void setDateLastPlayed(String dateLastPlayed) {
        this.dateLastPlayed = dateLastPlayed;
    }

    public Player getTopPlayer() {
        return topPlayer;
    }

    public void setTopPlayer(Player topPlayer) {
        this.topPlayer = topPlayer;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
