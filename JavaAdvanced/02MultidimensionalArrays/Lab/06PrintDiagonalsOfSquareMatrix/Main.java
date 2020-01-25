import java.util.Scanner;
import java.util.stream.Stream;

class Main {

    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrix(scanner);
        String[] result = findDiagonals(matrix);
        
        System.out.println(result[0]);
        System.out.println(result[1]);

    }

    private static int[][] readMatrix (Scanner scanner) {
        int s = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[s][s];

        for (int row = 0; row < s; row++) {
            int[] tokens = Stream.of(scanner.nextLine().split(" +"))
                .map(el -> el.trim())
                .mapToInt(n -> Integer.parseInt(n))
                .toArray();

            for (int col = 0; col < s; col++) {
                matrix[row][col] = tokens[col];
            }
        }

        return matrix;
    }

    private static String[] findDiagonals (int[][] matrix) {
        String leftDiagonal = "";
        String rightDiagonal = "";
        
        for (int i = 0; i < matrix.length; i++) {
            int j = matrix.length - 1 - i;
            leftDiagonal += matrix[i][i] + " ";
            rightDiagonal += matrix[j][i] + " ";
        }

        String[] result = { leftDiagonal, rightDiagonal };
        return result;
    }

}
