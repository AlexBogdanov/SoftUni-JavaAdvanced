import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

class UniqueUsernames {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Set<String> usernames = readInput(scanner);
        StringBuilder sb = new StringBuilder();
        formOutput(sb, usernames);

        System.out.println(sb);

    }

    private static Set<String> readInput(Scanner scanner) {
        Set<String> usernames = new LinkedHashSet<>();
        int n = Integer.parseInt(scanner.nextLine().trim());

        for (int i = 0; i < n; i++) {
            usernames.add(scanner.nextLine().trim());
        }

        return usernames;
    }

    private static void formOutput(StringBuilder sb, Set<String> usernames) {
        for (String user : usernames) {
            sb.append(user + "\n");
        }
    }

}
