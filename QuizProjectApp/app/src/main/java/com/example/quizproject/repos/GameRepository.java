package com.example.quizproject.repos;

import com.example.quizproject.models.Game;

import java.util.List;

public class GameRepository {

    private List<Game> games;

    private static GameRepository instance;

    public static GameRepository getInstance() {
        if (instance == null) {
            instance = new GameRepository();
        }
        return instance;
    }

    private GameRepository() {
    }

    public List<Game> getGames() {
        return games;
    }

    public void addToGamesRepo(Game game) {
        games.add(game);
    }
}
