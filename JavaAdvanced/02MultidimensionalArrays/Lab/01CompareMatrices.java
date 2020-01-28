import java.util.Scanner;
import java.util.stream.Stream;

class Main {

    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);

        int rFirst = scanner.nextInt();
        int cFirst = scanner.nextInt();
        scanner.nextLine();
        int[][] firstMatrix = readMatrix(rFirst, cFirst, scanner);
    
        int rSecond = scanner.nextInt();
        int cSecond = scanner.nextInt();
        scanner.nextLine();
        int[][] secondMatrix = readMatrix(rSecond, cSecond, scanner);
        
        if (firstMatrix.length != secondMatrix.length ||
            firstMatrix[0].length != secondMatrix[0].length ||
            rFirst != rSecond || cFirst != cSecond) {
                System.out.println("not equal");
                return;
        }

        boolean areEqual = true;

        for (int row = 0; row < rFirst; row++) {
            for (int col = 0; col < cFirst; col++) {
                if (firstMatrix[row][col] != secondMatrix[row][col]) {
                    areEqual = false;
                    break;
                }
            }

            if (!areEqual) {
                break;
            }
        }

        if (areEqual) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }

    }

    private static int[][] readMatrix (int r, int c, Scanner scanner) {
        int[][] matrix = new int[r][c];

        for (int row = 0; row < r; row++) {
            int[] tokens = Stream.of(scanner.nextLine().split("\\s+"))
                .map(el -> el.trim())
                .mapToInt(n -> Integer.parseInt(n))
                .toArray();
            
            for (int col = 0; col < c; col++) {
                matrix[row][col] = tokens[col];
            }
        }

        return matrix;
    }

}
