import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

class SoftuniParty {

    public static void main (String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Set<String> regularGuests = new TreeSet<>();
        Set<String> vipGuests = new TreeSet<>();

        fillGuestLists(scanner, regularGuests, vipGuests);
        welcomeGuests(scanner, regularGuests, vipGuests);

        StringBuilder sb = new StringBuilder();
        formOutput(sb, regularGuests, vipGuests);

        System.out.println(sb);

    }

    private static void fillGuestLists (Scanner scanner, Set<String> regularGuests, Set<String> vipGuests) {
        String input = scanner.nextLine();

        while (!"PARTY".equals(input)) {
            char firstCh = input.charAt(0);

            if ((firstCh >= 48 && firstCh <= 57)) {
                vipGuests.add(input);
            } else {
                regularGuests.add(input);
            }

            input = scanner.nextLine();
        }
    }

    private static void welcomeGuests (Scanner scanner, Set<String> regularGuests, Set<String> vipGuests) {
        String input = scanner.nextLine();

        while (!"END".equals(input)) {
            regularGuests.remove(input);
            vipGuests.remove(input);

            input = scanner.nextLine();
        }
    }

    private static void formOutput (StringBuilder sb, Set<String> regularGuests, Set<String> vipGuests) {
        sb.append(regularGuests.size() + vipGuests.size());
        sb.append(System.lineSeparator());

        for (String guest : vipGuests) {
            sb.append(guest);
            sb.append(System.lineSeparator());
        }

        for (String guest : regularGuests) {
            sb.append(guest);
            sb.append(System.lineSeparator());
        }
    }

}
