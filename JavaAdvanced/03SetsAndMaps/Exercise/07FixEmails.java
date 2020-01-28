import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

class FixEmails {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String, String> map = readInput(scanner);
        StringBuilder sb = formOutput(map);

        System.out.println(sb);

    }

    private static Map<String, String> readInput(Scanner scanner) {
        Map<String, String> map = new LinkedHashMap<>();
        String pattern = ".+\\.(us|uk|com)$";
        String name = scanner.nextLine();

        while (!"stop".equals(name)) {
            String email = scanner.nextLine();
            
            if (!email.matches(pattern)) {
                map.put(name, email);
            }

            name = scanner.nextLine();
        }


        return map;
    }

    private static StringBuilder formOutput(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();

        for (String name : map.keySet()) {
            sb.append(String.format("%s -> %s\n", name, map.get(name)));
        }

        return sb;
    }

}
