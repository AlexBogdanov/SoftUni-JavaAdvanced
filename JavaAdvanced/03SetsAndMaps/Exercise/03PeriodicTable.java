import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

class PeriodicTable {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Set<String> table = readInput(scanner);
        StringBuilder sb = new StringBuilder();
        formOutput(sb, table);

        System.out.println(sb);

    }

    private static Set<String> readInput(Scanner scanner) {
        Set<String> table = new TreeSet<>();
        int n = Integer.parseInt(scanner.nextLine().trim());

        for (int i = 0; i < n; i++) {
            String[] tokens = Stream.of(scanner.nextLine().split("\\s+"))
                .map(el -> el.trim())
                .toArray(s -> new String[s]);

            for (String str : tokens) {
                table.add(str);
            }
        }

        return table;
    }

    private static void formOutput(StringBuilder sb, Set<String> table) {
        for (String el : table) {
            sb.append(el + " ");
        }
    }

}
