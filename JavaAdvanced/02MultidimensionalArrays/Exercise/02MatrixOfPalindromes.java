import java.util.Scanner;
import java.util.stream.Stream;

class Main {

    public static void main (String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int[] tokens = Stream.of(scanner.nextLine().split("\\s+"))
            .map(el -> el.trim())
            .mapToInt(n -> Integer.parseInt(n))
            .toArray();
        int rows = tokens[0];
        int cols = tokens[1];
        String[][] matrix = createMatrix(rows, cols);

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }

            System.out.println();
        }

    }

    private static String[][] createMatrix (int rows, int cols) {
        String[][] matrix = new String[rows][cols];
        
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                char firstLastChar = (char) (97 + row);
                char midChar = (char) (97 + row + col);
                matrix[row][col] = "" + firstLastChar + midChar + firstLastChar;
            }
        }
        
        return matrix;
    }

}
