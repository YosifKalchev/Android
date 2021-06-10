package com.example.quizproject.repos;


import com.example.quizproject.models.Player;

import java.util.List;

public class PlayerRepository {

    private List<Player> players;

    private static PlayerRepository instance;

    public static PlayerRepository getInstance() {
        if (instance == null) {
            instance = new PlayerRepository();
        }
        return instance;
    }

    private PlayerRepository() {
    }

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
