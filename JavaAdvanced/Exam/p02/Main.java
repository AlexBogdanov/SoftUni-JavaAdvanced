package p02;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        var n = Integer.parseInt(scanner.nextLine());
        var c = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];
        int[] playerPos = createMatrix(n, scanner, matrix);

        boolean hasFinished = handleCommands(c, scanner, matrix, playerPos);

        scanner.close();

        StringBuilder sb = createOutput(hasFinished, matrix);

        System.out.println(sb);

    }

    private static StringBuilder createOutput(boolean hasFinished, char[][] matrix) {
        StringBuilder sb = new StringBuilder();

        if (hasFinished) {
            sb.append("Player won!");
        } else {
            sb.append("Player lost!");
        }
        sb.append(System.lineSeparator());

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                sb.append(matrix[row][col]);
            }
            sb.append(System.lineSeparator());
        }

        return sb;
    }

    private static boolean handleCommands(int c, Scanner scanner, char[][] matrix, int[] playerPos) {
        boolean hasFinished = false;

        for (int i = 0; i < c; i++) {
            String command = scanner.nextLine();

            switch (command) {
                case "up":
                    hasFinished = handleUp(matrix, playerPos);
                    break;
                case "down":
                    hasFinished = handleDown(matrix, playerPos);
                    break;
                case "left":
                    hasFinished = handleLeft(matrix, playerPos);
                    break;
                case "right":
                    hasFinished = handleRight(matrix, playerPos);
                    break;
            }

            if (hasFinished) { break; }
        }

        return hasFinished;
    }

    private static boolean handleRight(char[][] matrix, int[] playerPos) {
        int row = playerPos[0];
        int col = playerPos[1];

        if (col + 1 >= matrix[row].length) {
            playerPos[1] = 0;
            boolean res = false;

            if (matrix[playerPos[0]][playerPos[1]] == 'F') {
                res = true;
            }

            matrix[row][col] = '-';
            matrix[playerPos[0]][playerPos[1]] = 'f';
            return res;
        }

        if (matrix[row][col + 1] == 'F') {
            playerPos[1] = col + 1;
            matrix[row][col] = '-';
            matrix[playerPos[0]][playerPos[1]] = 'f';
            return true;
        }

        if (matrix[row][col + 1] == 'B') {
            if (col + 2 >= matrix[row].length) {
                playerPos[1] = 0;
            } else {
                playerPos[1] = col + 2;
            }

            if (matrix[playerPos[0]][playerPos[1]] == 'F') {
                matrix[row][col] = '-';
                matrix[playerPos[0]][playerPos[1]] = 'f';
                return true;
            }
        }

        if (matrix[row][col + 1] == '-') {
            playerPos[1] = col + 1;
        }

        matrix[row][col] = '-';
        matrix[playerPos[0]][playerPos[1]] = 'f';
        return false;
    }

    private static boolean handleLeft(char[][] matrix, int[] playerPos) {
        int row = playerPos[0];
        int col = playerPos[1];

        if (col - 1 < 0) {
            playerPos[1] = matrix[row].length - 1;
            boolean res = false;

            if (matrix[playerPos[0]][playerPos[1]] == 'F') {
                res = true;
            }

            matrix[row][col] = '-';
            matrix[playerPos[0]][playerPos[1]] = 'f';
            return res;
        }

        if (matrix[row][col - 1] == 'F') {
            playerPos[1] = col - 1;
            matrix[row][col] = '-';
            matrix[playerPos[0]][playerPos[1]] = 'f';
            return true;
        }

        if (matrix[row][col - 1] == 'B') {
            if (col - 2 < 0) {
                playerPos[1] = matrix[row].length - 1;
            } else {
                playerPos[1] = col - 2;
            }

            if (matrix[playerPos[0]][playerPos[1]] == 'F') {
                matrix[row][col] = '-';
                matrix[playerPos[0]][playerPos[1]] = 'f';
                return true;
            }
        }

        if (matrix[row][col - 1] == '-') {
            playerPos[1] = col - 1;
        }

        matrix[row][col] = '-';
        matrix[playerPos[0]][playerPos[1]] = 'f';
        return false;
    }

    private static boolean handleDown(char[][] matrix, int[] playerPos) {
        int row = playerPos[0];
        int col = playerPos[1];

        if (row + 1 >= matrix.length) {
            playerPos[0] = 0;
            boolean res = false;

            if (matrix[playerPos[0]][playerPos[1]] == 'F') {
                res = true;
            }

            matrix[row][col] = '-';
            matrix[playerPos[0]][playerPos[1]] = 'f';
            return res;
        }

        if (matrix[row + 1][col] == 'F') {
            playerPos[0] = row + 1;
            matrix[row][col] = '-';
            matrix[playerPos[0]][playerPos[1]] = 'f';
            return true;
        }

        if (matrix[row + 1][col] == 'B') {
            if (row + 2 >= matrix.length) {
                playerPos[0] = 0;
            } else {
                playerPos[0] = row + 2;
            }

            if (matrix[playerPos[0]][playerPos[1]] == 'F') {
                matrix[row][col] = '-';
                matrix[playerPos[0]][playerPos[1]] = 'f';
                return true;
            }
        }

        if (matrix[row + 1][col] == '-') {
            playerPos[0] = row + 1;
        }

        matrix[row][col] = '-';
        matrix[playerPos[0]][playerPos[1]] = 'f';
        return false;
    }

    private static boolean handleUp(char[][] matrix, int[] playerPos) {
        int row = playerPos[0];
        int col = playerPos[1];

        if (row - 1 < 0) {
            playerPos[0] = matrix.length - 1;
            boolean res = false;

            if (matrix[playerPos[0]][playerPos[1]] == 'F') {
                res = true;
            }

            matrix[row][col] = '-';
            matrix[playerPos[0]][playerPos[1]] = 'f';
            return res;
        }

        if (matrix[row - 1][col] == 'F') {
            playerPos[0] = row - 1;
            matrix[row][col] = '-';
            matrix[playerPos[0]][playerPos[1]] = 'f';
            return true;
        }

        if (matrix[row - 1][col] == 'B') {
            if (row - 2 < 0) {
                playerPos[0] = matrix.length - 1;
            } else {
                playerPos[0] = row - 2;
            }

            if (matrix[playerPos[0]][playerPos[1]] == 'F') {
                matrix[row][col] = '-';
                matrix[playerPos[0]][playerPos[1]] = 'f';
                return true;
            }
        }

        if (matrix[row - 1][col] == '-') {
            playerPos[0] = row - 1;
        }

        matrix[row][col] = '-';
        matrix[playerPos[0]][playerPos[1]] = 'f';
        return false;
    }

    private static int[] createMatrix(int n, Scanner scanner, char[][] matrix) {
        var pos = new int[2];

        for (int row = 0; row < n; row++) {
            String[] tokens = scanner.nextLine().split("");
            matrix[row] = new char[tokens.length];

            for (int col = 0; col < tokens.length; col++) {
                char ch = tokens[col].charAt(0);
                matrix[row][col] = ch;
                
                if (ch == 'f') {
                    pos[0] = row;
                    pos[1] = col;
                }
            }
        }

        return pos;
    }

}
