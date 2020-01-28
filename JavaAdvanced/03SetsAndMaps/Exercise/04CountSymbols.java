import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class CountSymbols {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<Character, Integer> map = readInput(scanner);
        StringBuilder sb = new StringBuilder();
        formOutput(sb, map);

        System.out.println(sb);

    }

    private static Map<Character, Integer> readInput(Scanner scanner) {
        Map<Character, Integer> map = new TreeMap<>();
        char[] tokens = scanner.nextLine().toCharArray();

        for (char ch : tokens) {
            if (map.containsKey(ch)) {
                int oldVal = map.get(ch);
                map.put(ch, oldVal + 1);
            } else {
                map.put(ch, 1);
            }
        }

        return map;
    }

    private static void formOutput(StringBuilder sb, Map<Character, Integer> map) {
        for (char key : map.keySet()) {
            sb.append(String.format("%s: %d time/s", key, map.get(key)));
            sb.append(System.lineSeparator());
        }
    }

}
