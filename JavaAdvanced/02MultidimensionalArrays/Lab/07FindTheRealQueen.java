import java.util.Scanner;

class Main {

    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);
        char[][] matrix = readMatrix(scanner);
        String validQueen = findValidQueen(matrix);
        System.out.println(validQueen);

    }

    private static char[][] readMatrix (Scanner scanner) {
        char[][] matrix = new char[8][8];

        for (int row = 0; row < 8; row++) {
            String[] tokens = scanner.nextLine().split(" +");

            for (int col = 0; col < 8; col++) {
                matrix[row][col] = tokens[col].trim().charAt(0);
            }
        }

        return matrix;
    }

    private static String findValidQueen (char[][] matrix) {
        String validQueen = "";
        
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                boolean isQueen = false;
                boolean isSafe = false;

                if (matrix[row][col] == 'q') {
                    isQueen = true;
                    boolean isRowSafe = checkRow(matrix, row, col);
                    boolean isColSafe = checkCol(matrix, col, row);

                    if (isRowSafe && isColSafe) {
                        isSafe = true;
                    }
                }

                if (isQueen && isSafe) {
                    validQueen = row + " " + col;                  
                    break;
                }
            }

            if (!"".equals(validQueen)) {
                break;
            }
        }

        return validQueen;
    }

    private static boolean checkRow (char[][] matrix, int r, int qC) {
        boolean isQueenSafe = true;
        
        for (int col = 0; col < matrix[r].length; col++) {
            if (col == qC) {
                continue;
            }

            if (matrix[r][col] == 'q') {
                isQueenSafe = false;
                break;
            }
        }

        return isQueenSafe;
    }

    private static boolean checkCol (char[][] matrix, int c, int qR) {
        boolean isQueenSafe = true;

        for (int row = 0; row < matrix.length; row++) {
            if (row == qR) {
                continue;
            }

            if (matrix[row][c] == 'q') {
                isQueenSafe = false;
                break;
            }
        }

        return isQueenSafe;
    }

}
