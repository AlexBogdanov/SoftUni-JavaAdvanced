package p05FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import p05FootballTeamGenerator.domain.Player;
import p05FootballTeamGenerator.domain.Team;

public class Main {

    public static void main(String[] args) {

        handleCommands();

    }

    private static void handleCommands() {
        Scanner scanner = new Scanner(System.in);
        List<Team> teams = new ArrayList<>();

        for (String input = scanner.nextLine(); !input.equals("END"); input = scanner.nextLine()) {
            String[] tokens = input.split(";");
            String command = tokens[0];

            switch(command) {
                case "Team":
                    createTeam(tokens[1], teams);
                    break;
                case "Add":
                    addPlayerToTeam(tokens, teams);
                    break;
                case "Remove":
                    try {
                        removePlayerFromTeam(tokens[1], tokens[2], teams);
                    } catch (NoSuchElementException nse) {
                        System.out.println(nse.getMessage());
                    }
                    break;
                default:
                    printRating(tokens[1], teams);
            }
        }

        scanner.close();
    }

    private static void printRating(String teamName, List<Team> teams) {
        Team team = teams.stream()
            .filter(t -> t.getName().equals(teamName))
            .findFirst()
            .orElse(null);

        if (team == null) {
            throw new NoSuchElementException("Team " + teamName + " does not exist.");       
        }

        System.out.println(String.format(
            "%s - %d",
            team.getName(),
            (int) Math.rint(team.getRating())
        ));
    }

    private static void removePlayerFromTeam(String teamName, String playerName, List<Team> teams) {
        Team team = teams.stream()
            .filter(t -> t.getName().equals(teamName))
            .findFirst()
            .orElse(null);

        if (team == null) {
            throw new NoSuchElementException("Team " + teamName + " does not exist.");       
        }

        team.removePlayer(playerName);
    }

    private static void addPlayerToTeam(String[] tokens, List<Team> teams) {
        String teamName = tokens[1];
        String playerName = tokens[2];
        int endurance = Integer.parseInt(tokens[3]);
        int sprint = Integer.parseInt(tokens[4]);
        int dribble = Integer.parseInt(tokens[5]);
        int passing = Integer.parseInt(tokens[6]);
        int shooting = Integer.parseInt(tokens[7]);

        Team team = teams.stream()
            .filter(t -> t.getName().equals(teamName))
            .findFirst()
            .orElse(null);

        if (team == null) {
            throw new NoSuchElementException("Team " + teamName + " does not exist.");       
        }

        try {
            Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);
            team.addPlayer(player);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }

    private static void createTeam(String name, List<Team> teams) {
        try {
            Team team = new Team(name);
            teams.add(team);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }

}
