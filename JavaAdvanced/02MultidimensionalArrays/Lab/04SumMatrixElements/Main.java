import java.util.Scanner;
import java.util.stream.Stream;

class Main {

    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] tokens = Stream.of(scanner.nextLine().split(", +"))
            .map(el -> el.trim())
            .mapToInt(n -> Integer.parseInt(n))
            .toArray();
        int r = tokens[0];
        int c = tokens[1];
        int[][] matrix = readMatrix(r, c, scanner);
        int sum = calculateMatrix(matrix);

        System.out.println(r);
        System.out.println(c);
        System.out.println(sum);

    }

    private static int[][] readMatrix (int r, int c, Scanner scanner) {
        int[][] matrix = new int[r][c];

        for (int row = 0; row < r; row++) {
            int[] tokens = Stream.of(scanner.nextLine().split(", +"))
                .map(el -> el.trim())
                .mapToInt(n -> Integer.parseInt(n))
                .toArray();

            for (int col = 0; col < c; col++) {
                matrix[row][col] = tokens[col];
            }
        }

        return matrix;
    }

    private static int calculateMatrix (int[][] matrix) {
        int res = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                res += matrix[row][col];
            }
        }

        return res;
    }

}
