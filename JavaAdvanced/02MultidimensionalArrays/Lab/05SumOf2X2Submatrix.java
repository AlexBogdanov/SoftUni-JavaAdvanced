import java.util.Scanner;
import java.util.stream.Stream;

class Main {

    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrix(scanner);
        String[] result = getMaxSum(matrix);

        System.out.println(result[0]);
        System.out.println(result[1]);
        System.out.println(result[2]);

    }

    private static int[][] readMatrix (Scanner scanner) {
        int[] input = Stream.of(scanner.nextLine().split(", +"))
            .map(el -> el.trim())
            .mapToInt(n -> Integer.parseInt(n))
            .toArray();
        int r = input[0];
        int c = input[1];
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

    private static String[] getMaxSum (int[][] matrix) {
        String[] tokens = new String[3];
        tokens[2] = "" + 0;

        for (int currRow = 0; currRow < matrix.length - 1; currRow++) {
            int nextRow = currRow + 1;

            for (int currCol = 0; currCol < matrix[currRow].length - 1; currCol++) {
                int nextCol = currCol + 1;
                int sum = matrix[currRow][currCol] + matrix[currRow][nextCol] + matrix[nextRow][currCol] + matrix[nextRow][nextCol];

                if (sum > Integer.parseInt(tokens[2])) {
                    tokens[0] = matrix[currRow][currCol] + " " + matrix[currRow][nextCol];
                    tokens[1] = matrix[nextRow][currCol] + " " + matrix[nextRow][nextCol];
                    tokens[2] = "" + sum;
                }
            }
        }

        return tokens;
    }

}
