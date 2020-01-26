import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class CountRealNumbers {

    public static void main (String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        String[] tokens = readInput(scanner);
        Map<Double, Integer> map = createMap(tokens);
        
        StringBuilder sb = new StringBuilder();
        formOutput(sb, map);
        System.out.println(sb);

    }

    private static String[] readInput (Scanner scanner) {
        String[] tokens = scanner.nextLine().split("\\s+");
        return tokens;
    }

    private static Map<Double, Integer> createMap (String[] tokens) {
        Map<Double, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < tokens.length; i++) {
            double key = Double.parseDouble(tokens[i].trim());

            if (map.containsKey(key)) {
                int val = map.get(key);
                map.put(key, val + 1);
            } else {
                map.put(key, 1);
            }
        }

        return map;
    }

    private static void formOutput (StringBuilder sb, Map<Double, Integer> map) {
        Set<Double> keys = map.keySet();

        for (double key : keys) {
            sb.append(String.format("%.1f -> %d", key, map.get(key)));
            sb.append(System.lineSeparator());
        }
    }

}
