package p04FirstAndReserveTeam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import p04FirstAndReserveTeam.domain.Person;
import p04FirstAndReserveTeam.domain.Team;
import p04FirstAndReserveTeam.io.Printer;
import p04FirstAndReserveTeam.io.Reader;
import p04FirstAndReserveTeam.utils.PersonParser;

public class Main {

    public static void main(String[] args) throws IOException {

        int n = Reader.nextInt();
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            try {
                Person person = PersonParser.parseData(Reader.nextLine());
                people.add(person);
            } catch (IllegalArgumentException iae) {
                Printer.print(iae.getMessage());
            }
        }

        Team team = new Team("Black Eagles");
        for (Person player : people) {
            team.addPlayer(player);
        }

        Printer.print("First team have " + team.getFirstTeam().size() + " players");
        Printer.print("Reserve team have " + team.getReserveTeam().size() + " players");

    }

}
