package p05FootballTeamGenerator.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Team {

    private String name;
    private List<Player> players;

    public Team(String name) {
        this.setName(name);
        this.players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(String name) {
        Player player = this.players.stream()
            .filter(p -> p.getName().equals(name))
            .findFirst()
            .orElse(null);

        if (player == null) {
            throw new NoSuchElementException(String.format(
                "Player %s is not in %s team.",
                name,
                this.getName()
            ));
        }

        this.players.remove(player);
    }

    public double getRating() {
        double rating = 0;

        for (Player player : this.players) {
            rating += player.overallSkillLevel();
        }

        return rating / this.players.size();
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }

        this.name = name;
    }

}
