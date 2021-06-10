package com.example.quizproject.models;

import com.example.quizproject.models.Game;
import com.example.quizproject.models.Player;

public class CurrentGame extends Game {


    private  static int numberOfMultipleChoiceQuestions;
    private  int numberOfMultipleChoiceAnswers;
    private  static int playersResponseTime;
    private  int booleanRoundAnswerTime;
    private static int playersInGameCount;

    public static int getNumberOfMultipleChoiceQuestions() {
        return numberOfMultipleChoiceQuestions;
    }

    public static void setNumberOfMultipleChoiceQuestions(int numberOfMultipleChoiceQuestions) {
        CurrentGame.numberOfMultipleChoiceQuestions = numberOfMultipleChoiceQuestions;
    }

    public int getNumberOfMultipleChoiceAnswers() {
        return numberOfMultipleChoiceAnswers;
    }

    public void setNumberOfMultipleChoiceAnswers(int numberOfMultipleChoiceAnswers) {
        this.numberOfMultipleChoiceAnswers = numberOfMultipleChoiceAnswers;
    }

    public static int getPlayersResponseTime() {
        return playersResponseTime;
    }

    public static void setPlayersResponseTime(int playersResponseTime) {
        CurrentGame.playersResponseTime = playersResponseTime;
    }

    public int getBooleanRoundAnswerTime() {
        return booleanRoundAnswerTime;
    }

    public void setBooleanRoundAnswerTime(int booleanRoundAnswerTime) {
        this.booleanRoundAnswerTime = booleanRoundAnswerTime;
    }

    public static int getPlayersInGameCount() {
        return playersInGameCount;
    }

    public static void setPlayersInGameCount(int playersInGameCount) {
        CurrentGame.playersInGameCount = playersInGameCount;
    }
}
