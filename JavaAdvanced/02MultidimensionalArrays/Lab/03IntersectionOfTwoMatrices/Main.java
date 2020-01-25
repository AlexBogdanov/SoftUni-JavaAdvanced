import java.util.Scanner;
import java.util.stream.Stream;

class Main {

    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        int r = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());
        char[][] firstMatrix = readMatrix(r, c, scanner);
        char[][] secondMatrix = readMatrix(r, c, scanner);
        char[][] thirdMatrix = makeMatrix(r, c, firstMatrix, secondMatrix);

        for (int row = 0; row < r; row++) {
            for (int col = 0; col < c; col++) {
                System.out.print(thirdMatrix[row][col] + " ");
            }

            System.out.println();
        }

    }

    private static char[][] readMatrix (int r, int c, Scanner scanner) {
        char[][] matrix = new char[r][c];

        for (int row = 0; row < r; row++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            
            for (int col = 0; col < c; col++) {
                matrix[row][col] = tokens[col].trim().charAt(0);
            }
        }

        return matrix;
    }

    private static char[][] makeMatrix (int r, int c, char[][] firstMatrix, char[][] secondMatrix) {
        char[][] matrix = new char[r][c];

        for (int row = 0; row < r; row++) {
            for (int col = 0; col < c; col++) {
                if (firstMatrix[row][col] == secondMatrix[row][col]) {
                    matrix[row][col] = firstMatrix[row][col];
                } else {
                    matrix[row][col] = '*';
                }
            }
        }

        return matrix;
    }

}
