import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Phonebook {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String, String> phonebook = readInput(scanner);
        StringBuilder sb = new StringBuilder();
        searchPhonebook(scanner, sb, phonebook);

        System.out.println(sb);

    }

    private static Map<String, String> readInput(Scanner scanner) {
        Map<String, String> phonebook = new HashMap<>();
        String input = scanner.nextLine();

        while (!"search".equals(input)) {
            String[] tokens = input.split("-");
            phonebook.put(tokens[0], tokens[1]);

            input = scanner.nextLine();
        }

        return phonebook;
    }

    private static void searchPhonebook(Scanner scanner, StringBuilder sb, Map<String, String> phonebook) {
        String name = scanner.nextLine();

        while (!"stop".equals(name)) {
            if (phonebook.containsKey(name)) {
                sb.append(String.format("%s -> %s\n", name, phonebook.get(name)));
            } else {
                sb.append(String.format("Contact %s does not exist.\n", name));
            }

            name = scanner.nextLine();
        }
    }

}
