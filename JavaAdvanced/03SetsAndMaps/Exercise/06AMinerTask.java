import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

class AMinerTask {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String, Long> resources = readInput(scanner);
        StringBuilder sb = new StringBuilder();
        formOutput(sb, resources);

        System.out.println(sb);

    }

    private static Map<String, Long> readInput(Scanner scanner) {
        Map<String, Long> resources = new LinkedHashMap<>();
        String resource = scanner.nextLine();

        while (!"stop".equals(resource)) {
            long quantity = Long.parseLong(scanner.nextLine());

            if (resources.containsKey(resource)) {
                long oldVal = resources.get(resource);
                resources.put(resource, oldVal + quantity);
            } else {
                resources.put(resource, quantity);
            }

            resource = scanner.nextLine();
        }

        return resources;
    }

    private static void formOutput(StringBuilder sb, Map<String, Long> resources) {
        for (String resource : resources.keySet()) {
            sb.append(resource + " -> " + resources.get(resource));
            sb.append(System.lineSeparator());
        }
    }

}
