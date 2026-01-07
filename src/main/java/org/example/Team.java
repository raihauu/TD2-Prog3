package org.example;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private int id;
    private String name;
    private ContinentEnum continent;
    private List<Player> players;

    public Team(int id, String name, ContinentEnum continent) {
        this.id = id;
        this.name = name;
        this.continent = continent;
        this.players = new ArrayList<>();
    }


    public Integer getPlayersCount() {
        return players.size();
    }


    public void addPlayer(Player player) {
        players.add(player);
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ContinentEnum getContinent() {
        return continent;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Integer getPlayersGoals() {
        int total = 0;
        for (Player p : players) {
            if (p.getGoalNb() == null) {
                throw new IllegalStateException(
                        "Le nombre de buts du joueur " + p.getName() + " est inconnu, impossible de calculer le total"
                );
            }
            total += p.getGoalNb();
        }
        return total;
    }
}
