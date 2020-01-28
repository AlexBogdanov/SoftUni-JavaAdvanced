import java.util.Scanner;
import java.util.stream.Stream;

class Main {

    public static void main (String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrix(scanner);
        calculateMatrix(matrix);

    }

    private static int[][] readMatrix (Scanner scanner) {
        int[] inputTokens = Stream.of(scanner.nextLine().split("\\s+"))
            .map(el -> el.trim())
            .mapToInt(n -> Integer.parseInt(n))
            .toArray();
        int rows = inputTokens[0];
        int cols = inputTokens[1];
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            int[] tokens = Stream.of(scanner.nextLine().split(" +"))
                .map(el -> el.trim())
                .mapToInt(n -> Integer.parseInt(n))
                .toArray();

            for (int col = 0; col < cols; col++) {
                matrix[row][col] = tokens[col];
            }
        }

        return matrix;
    }

    private static void calculateMatrix (int[][] matrix) {
        int biggestSum = Integer.MIN_VALUE;
        int[][] biggestMatrix = new int[3][3];
        
        for (int leftRowStPt = 0; leftRowStPt < matrix.length - 2; leftRowStPt++) {
            for (int leftCowStPt = 0; leftCowStPt < matrix[leftRowStPt].length - 2; leftCowStPt++) {
                int[][] currMatrix = new int[3][3];

                for (int row = 0; row < 3; row++) {
                    for (int col = 0; col < 3; col++) {
                        currMatrix[row][col] = matrix[leftRowStPt + row][leftCowStPt + col];
                    }
                }

                int currSum = calculateSum(currMatrix);

                if (currSum > biggestSum) {
                    biggestSum = currSum;
                    biggestMatrix = currMatrix;
                }
            }
        }

        System.out.println("Sum = " + biggestSum);

        for (int row = 0; row < biggestMatrix.length; row++) {
            for (int col = 0; col < biggestMatrix[row].length; col++) {
                System.out.print(biggestMatrix[row][col] + " ");
            }

            System.out.println();
        }
    }

    private static int calculateSum (int[][] matrix) {
        int sum = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                sum += matrix[row][col];
            }
        }

        return sum;
    }

}
