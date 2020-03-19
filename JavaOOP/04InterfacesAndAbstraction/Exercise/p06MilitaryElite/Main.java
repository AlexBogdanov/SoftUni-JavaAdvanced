package p06MilitaryElite;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import p06MilitaryElite.domain.Corps;
import p06MilitaryElite.domain.State;
import p06MilitaryElite.domain.Commando.Commando;
import p06MilitaryElite.domain.Engineer.Engineer;
import p06MilitaryElite.domain.LieutenantGeneral.LieutenantGeneral;
import p06MilitaryElite.domain.Mission.Mission;
import p06MilitaryElite.domain.Private.Private;
import p06MilitaryElite.domain.Repair.Repair;
import p06MilitaryElite.domain.Soldier.Soldier;
import p06MilitaryElite.domain.Spy.Spy;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Soldier> soldiers = createSoldiers(scanner);
        scanner.close();

        StringBuilder sb = formOutput(soldiers);
        System.out.println(sb);

    }

    private static StringBuilder formOutput(List<Soldier> soldiers) {
        StringBuilder sb = new StringBuilder();

        for (Soldier soldier : soldiers) {
            sb.append(soldier.toString()).append(System.lineSeparator());
        }

        return sb;
    }

    private static List<Soldier> createSoldiers(Scanner scanner) {
        var soldiers = new ArrayList<Soldier>();

        for (String input = scanner.nextLine(); !input.equals("End"); input = scanner.nextLine()) {
            String[] tokens = input.split("\\s+");
            String title = tokens[0];

            switch(title) {
                case "Private":
                    Soldier privatee = createPrivate(tokens);
                    soldiers.add(privatee);
                    break;
                case "LeutenantGeneral":
                    Soldier lieutGen = createLieutGen(tokens, soldiers);
                    soldiers.add(lieutGen);
                    break;
                case "Engineer":
                    Soldier engineer = createEngineer(tokens);
                    soldiers.add(engineer);
                    break;
                case "Commando":
                    Soldier commando = createCommando(tokens);
                    soldiers.add(commando);
                    break;
                case "Spy":
                    Soldier spy = createSpy(tokens);
                    soldiers.add(spy);
                    break;
            }
        }

        return soldiers;
    }

    private static Soldier createSpy(String[] tokens) {
        var id = Integer.parseInt(tokens[1]);
        String firstName = tokens[2];
        String lastName = tokens[3];
        String codeNumber = tokens[4];

        return new Spy(id, firstName, lastName, codeNumber);
    }

    private static Soldier createCommando(String[] tokens) {
        var id = Integer.parseInt(tokens[1]);
        String firstName = tokens[2];
        String lastName = tokens[3];
        var salary = Double.parseDouble(tokens[4]);
        String corps = tokens[5];
        var commando = new Commando(id, firstName, lastName, salary, Corps.valueOf(corps.toUpperCase()));

        for (int i = 6; i < tokens.length; i+=2) {
            String codeName = tokens[i];
            String state = tokens[i+1];
            var mission = new Mission(codeName, State.valueOf(state.toUpperCase()));

            commando.addMission(mission);
        }

        return commando;
    }

    private static Soldier createEngineer(String[] tokens) {
        var id = Integer.parseInt(tokens[1]);
        String firstName = tokens[2];
        String lastName = tokens[3];
        var salary = Double.parseDouble(tokens[4]);
        String corps = tokens[5];
        var engineer = new Engineer(id, firstName, lastName, salary, Corps.valueOf(corps.toUpperCase()));

        for (int i = 6; i < tokens.length; i+=2) {
            String partName = tokens[i];
            var hoursWorked = Integer.parseInt(tokens[i+1]);
            var repair = new Repair(partName, hoursWorked);

            engineer.addRepair(repair);
        }

        return engineer;
    }

    private static Soldier createLieutGen(String[] tokens, List<Soldier> soldiers) {
        var id = Integer.parseInt(tokens[1]);
        String firstName = tokens[2];
        String lastName = tokens[3];
        var salary = Double.parseDouble(tokens[4]);
        var lieutGen = new LieutenantGeneral(id, firstName, lastName, salary);

        for (int i = 5; i < tokens.length; i++) {
            var privateId = Integer.parseInt(tokens[i]);
            var privatee = (Private) soldiers.stream()
                .filter(s -> s.getId() == privateId)
                .findFirst()
                .orElse(null);

            lieutGen.addPrivate(privatee);
        }

        return lieutGen;
    }

    private static Soldier createPrivate(String[] tokens) {
        var id = Integer.parseInt(tokens[1]);
        String firstName = tokens[2];
        String lastName = tokens[3];
        var salary = Double.parseDouble(tokens[4]);

        return new Private(id, firstName, lastName, salary);
    }

}
