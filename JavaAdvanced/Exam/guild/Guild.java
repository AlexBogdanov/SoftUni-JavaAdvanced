package guild;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Guild {

    private String name;
    private int capacity;
    private List<Player> roster;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    // Might need boolean instead of void
    public void addPlayer(Player player) {
        if (this.roster.size() < this.capacity) {
            this.roster.add(player);
        }
    }

    public boolean removePlayer(String name) {
        int index = -1;

        for (Player player : this.roster) {
            if (player.getName().equals(name)) {
                index = this.roster.indexOf(player);
            }
        }

        if (index > -1) {
            this.roster.remove(index);
            return true;
        }

        return false;
    }

    public void promotePlayer(String name) {
        int index = -1;

        for (Player player : this.roster) {
            if (player.getName().equals(name)) {
                index = this.roster.indexOf(player);
                break;
            }
        }

        if (index > -1) {
            Player player = this.roster.get(index);
            player.setRank("Member");
            this.roster.add(index, player);
        }
    }

    public void demotePlayer(String name) {
        int index = -1;

        for (Player player : this.roster) {
            if (player.getName().equals(name)) {
                index = this.roster.indexOf(player);
                break;
            }
        }

        if (index > -1) {
            Player player = this.roster.get(index);
            player.setRank("Trial");
            this.roster.add(index, player);
        }
    }

    public Player[] kickPlayersByClass(String clazz) {
        List<Player> players = this.roster.stream()
            .filter(p -> p.getClazz().equals(clazz))
            .collect(Collectors.toList());
            
        for (Player player : players) {
            int index = this.roster.indexOf(player);
            this.roster.remove(index);
        }

        return players.toArray(new Player[players.size()]);
    }

    public int count() {
        return this.roster.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();

        sb.append("Players in the guild: " + this.name + ":").append(System.lineSeparator());

        for (Player player : this.roster) {
            sb.append(player.toString()).append(System.lineSeparator());
        }

        return sb.toString();
    }

}
