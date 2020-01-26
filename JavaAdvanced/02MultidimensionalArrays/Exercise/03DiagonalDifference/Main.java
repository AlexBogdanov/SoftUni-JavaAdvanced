import java.util.Scanner;
import java.util.stream.Stream;

class Main {

    public static void main (String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrix(scanner);
        int difference = getDifference(matrix);

        System.out.println(difference);

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

    private static int getDifference (int[][] matrix) {
        int primaryDiagonal = 0;
        int secondaryDiagonal = 0;

        for (int i = 0; i < matrix.length; i++) {
            int j = matrix.length - 1 - i;

            primaryDiagonal += matrix[i][i];
            secondaryDiagonal += matrix[i][j];
        }

        int difference = Math.abs(primaryDiagonal - secondaryDiagonal);
        return difference;
    }

}
