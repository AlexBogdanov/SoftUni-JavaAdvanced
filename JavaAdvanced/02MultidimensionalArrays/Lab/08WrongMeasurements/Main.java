import java.util.Scanner;
import java.util.stream.Stream;

class Main {

    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[][] matrix = readMatrix(scanner);
        int[] wrongValueTokens = Stream.of(scanner.nextLine().split(" +"))
            .map(el -> el.trim())
            .mapToInt(n -> Integer.parseInt(n))
            .toArray();
        int rWrong = wrongValueTokens[0];
        int cWrong = wrongValueTokens[1];
        int[][] repairedMatrix = repairMatrix(rWrong, cWrong, matrix);

        for (int row = 0; row < repairedMatrix.length; row++) {
            for (int col = 0; col < repairedMatrix[0].length; col++) {
                System.out.print(repairedMatrix[row][col] + " ");
            }

            System.out.println();
        }

    }

    private static int[][] readMatrix (Scanner scanner) {
        int s = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[s][];

        for (int row = 0; row < s; row++) {
            int[] tokens = Stream.of(scanner.nextLine().split(" +"))
                .map(el -> el.trim())
                .mapToInt(n -> Integer.parseInt(n))
                .toArray();
            matrix[row] = new int[tokens.length];

            for (int col = 0; col < tokens.length; col++) {
                matrix[row][col] = tokens[col];
            }
        }

        return matrix;
    }

    private static int[][] repairMatrix (int rWrong, int cWrong, int[][] matrix) {
        int[][] repairedMatrix = new int[matrix.length][matrix[0].length];
        int invalidVal = matrix[rWrong][cWrong];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == invalidVal) {
                    int up = getNum(matrix, "up", row, col, invalidVal);
                    int down = getNum(matrix, "down", row, col, invalidVal);
                    int left = getNum(matrix, "left", row, col, invalidVal);
                    int right = getNum(matrix, "right", row, col, invalidVal);
                    int newVal = up + down + left + right;

                    repairedMatrix[row][col] = newVal;
                } else {
                    repairedMatrix[row][col] = matrix[row][col];
                }
            }
        }

        return repairedMatrix;
    }

    private static int getNum (int[][] matrix, String direction, int r, int c, int invVal) {
        int result = 0;

        switch (direction) {
            case "up":
                int indexUp = r - 1 >= 0 ? r - 1 : -1;

                if (indexUp > -1) {
                    int val = matrix[indexUp][c];

                    if (val != invVal) {
                        result += matrix[indexUp][c];
                    }
                }
                break;
            case "down":
                int indexDown = r + 1 < matrix.length ? r + 1 : -1;

                if (indexDown > -1) {
                    int val = matrix[indexDown][c];

                    if (val != invVal) {
                        result += matrix[indexDown][c];
                    }
                }
                break;
            case "left":
                int indexLeft = c - 1 >= 0 ? c - 1 : -1;

                if (indexLeft > -1) {
                    int val = matrix[r][indexLeft];

                    if (val != invVal) {
                        result += matrix[r][indexLeft];
                    }
                }
                break;
            case "right":
                int indexRight = c + 1 < matrix[r].length ? c + 1 : -1;

                if (indexRight > -1) {
                    int val = matrix[r][indexRight];

                    if (val != invVal) {
                        result += matrix[r][indexRight];
                    }
                }
                break;
        }

        return result;
    }

}
