package com.example.quizproject.models;

public class Game {


    String title;
    String difficulty;
    String firstTopic;
    String secondTopic;
    String dateLastPlayed;
    String topPlayer;


    public Game() {

    }

    public Game(String title, String difficulty, String firstTopic, String secondTopic) {
        this.title = title;
        this.difficulty = difficulty;
        this.firstTopic = firstTopic;
        this.secondTopic = secondTopic;
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

    public String getFirstTopic() {
        return firstTopic;
    }

    public void setFirstTopic(String firstTopic) {
        this.firstTopic = firstTopic;
    }

    public String getSecondTopic() {
        return secondTopic;
    }

    public void setSecondTopic(String secondTopic) {
        this.secondTopic = secondTopic;
    }

    public String getDateLastPlayed() {
        return dateLastPlayed;
    }

    public void setDateLastPlayed(String dateLastPlayed) {
        this.dateLastPlayed = dateLastPlayed;
    }

    public String getTopPlayer() {
        return topPlayer;
    }

    public void setTopPlayer(String topPlayer) {
        this.topPlayer = topPlayer;
    }
}
