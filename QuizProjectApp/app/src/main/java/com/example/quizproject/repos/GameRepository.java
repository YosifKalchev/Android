package com.example.quizproject.repos;

import com.example.quizproject.models.Game;

import java.util.ArrayList;
import java.util.List;

public class GameRepository {

    private final List<Game> games;
    private final List<Game> gamesPlayed;

    private static GameRepository instance;

    public static GameRepository getInstance() {
        if (instance == null) {
            instance = new GameRepository();
        }
        return instance;
    }

    private GameRepository() {
        games = new ArrayList<>();
        games.add(game1);
        games.add(game2);
        games.add(game3);
        games.add(game4);
        games.add(game5);
        games.add(game6);

        gamesPlayed = new ArrayList<>();
        }


    public List<Game> getGames() {
        return games;
    }

    public void addToGamesRepo(Game game) {
        games.add(game);
    }


    Game game1 = new Game("Super game", "hard", "Geography", "History");
    Game game2 = new Game("Yo ho ho", "medium", "English", "Sport");
    Game game3 = new Game("Easy one", "easy", "Programming", "Tennis");
    Game game4 = new Game("Super game", "hard", "Geography", "History");
    Game game5 = new Game("Yo ho ho", "medium", "English", "Sport");
    Game game6 = new Game("Easy one", "easy", "Programming", "Tennis");


    public Game getGameByName(String gameTitle) {
        for (Game game : games) {
            if (game.getTitle().equals(gameTitle)) {
                return game;
            }
        } return null;
    }


}
