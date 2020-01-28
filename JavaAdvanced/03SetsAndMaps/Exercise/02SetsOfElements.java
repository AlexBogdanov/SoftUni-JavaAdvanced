import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

class SetsOfElements {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Set<Integer> setN = new LinkedHashSet<>();
        Set<Integer> setM = new LinkedHashSet<>();
        readInput(scanner, setN, setM);

        StringBuilder sb = new StringBuilder();
        formOutput(sb, setN, setM);

        System.out.println(sb);

    }

    private static void readInput(Scanner scanner, Set<Integer> setN,Set<Integer> setM) {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(scanner.nextLine().trim());
            setN.add(num);
        }

        for (int i = 1; i <= m; i++) {
            int num = Integer.parseInt(scanner.nextLine().trim());
            setM.add(num);
        }
    }

    private static void formOutput(StringBuilder sb, Set<Integer> setN, Set<Integer> setM) {
        for (int num : setN) {
            if (setM.contains(num)) {
                sb.append(num + " ");
            }
        }
    }

}
