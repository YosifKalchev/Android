package com.example.quizproject.repos;


import com.example.quizproject.models.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerRepository {

    private final List<Player> players;

    private static PlayerRepository instance;

    public static PlayerRepository getInstance() {
        if (instance == null) {
            instance = new PlayerRepository();
        }
        return instance;
    }

    private PlayerRepository() {
        players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);
    }

    Player player1 = new Player("Pesho", "yellow");
    Player player2 = new Player("Ivo", "blue");
    Player player3 = new Player("Gancho", "magenta");
    Player player4 = new Player("Stamat", "green");


    public List<Player> getPlayers() {
        return players;
    }

    public void addToPlayersRepo(Player player) {
        players.add(player);
    }

    public Player getPlayerByName(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }
}
