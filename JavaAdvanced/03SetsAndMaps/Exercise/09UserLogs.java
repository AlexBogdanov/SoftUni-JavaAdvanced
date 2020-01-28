import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class UserLogs {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Integer>> users = readInput(scanner);
        StringBuilder sb = formOutput(users);

        System.out.println(sb);

    }

    private static Map<String, Map<String, Integer>> readInput(Scanner scanner) {
        Map<String, Map<String, Integer>> users = new TreeMap<>();

        for (String input = scanner.nextLine(); !"end".equals(input); input = scanner.nextLine()) {
            String[] tokens = input.split("\\s+");
            String ip = tokens[0].split("=")[1];
            String user = tokens[2].split("=")[1];

            if (users.containsKey(user)) {
                Map<String, Integer> ips = users.get(user);

                if (ips.containsKey(ip)) {
                    int oldVal = ips.get(ip);
                    ips.put(ip, oldVal + 1);
                } else {
                    ips.put(ip, 1);
                }

                users.put(user, ips);
            } else {
                Map<String, Integer> ips = new LinkedHashMap<>();
                ips.put(ip, 1);
                users.put(user, ips);
            }
        }

        return users;
    }

    private static StringBuilder formOutput(Map<String, Map<String, Integer>> users) {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, Map<String, Integer>> user : users.entrySet()) {
            sb.append(user.getKey() + ":\n");
            Map<String, Integer> ips = user.getValue();
            int i = 1;
            int n = user.getValue().size();

            for (String ip : ips.keySet()) {
                sb.append(String.format("%s => %d", ip, ips.get(ip)));

                if (i == n) {
                    sb.append(".\n");
                } else {
                    sb.append(", ");
                }

                i++;
            }
        }

        return sb;
    }

}
