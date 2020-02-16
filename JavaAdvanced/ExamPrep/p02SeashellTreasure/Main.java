package p02SeashellTreasure;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        char[][] matrix = createMatrix(scanner);
        var collectedSeashells = new ArrayList<Character>();
        Integer[] seashells = createSeashells(scanner, matrix, collectedSeashells);
        
        scanner.close();

        StringBuilder sb = createOutput(seashells, collectedSeashells, matrix);

        System.out.println(sb);

    }

    private static StringBuilder createOutput(Integer[] seashells, List<Character> collectedSeashells, char[][] matrix) {
        StringBuilder sb = new StringBuilder();
        
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                sb.append(matrix[row][col] + " ");
            }

            sb.append(System.lineSeparator());
        }

        sb.append("Collected seashells: " + seashells[0]);

        if (seashells[0] > 0) {
            sb.append(" -> ");
            
            for (char seashell : collectedSeashells) {
                sb.append(seashell + ", ");
            }

            sb.replace(sb.length() - 2, sb.length() - 1, "");
        }

        sb.append(System.lineSeparator()).append("Stolen seashells: " + seashells[1]);

        return sb;
    }

    private static Integer[] createSeashells(Scanner scanner, char[][] matrix, List<Character> collectedSeashells) {
        var result = new Integer[2];
        result[0] = 0;
        result[1] = 0;

        for (String input = scanner.nextLine(); !input.equals("Sunset"); input = scanner.nextLine()) {
            String[] tokens = input.split("\\s+");
            
            switch (tokens[0]) {
                case "Collect":
                    collectSeashell(tokens, matrix, result, collectedSeashells);
                    break;
                case "Steal":
                    stealSeashell(tokens, matrix, result);
                    break;
            }
        }

        return result;
    }

    private static void stealSeashell(String[] tokens, char[][] matrix, Integer[] result) {
        var rowI = Integer.parseInt(tokens[1]);
        var colI = Integer.parseInt(tokens[2]);
        String direction = tokens[3];

        switch (direction) {
            case "up":
                handleUp(matrix, rowI, colI, result);
                break;
            case "down":
                handleDown(matrix, rowI, colI, result);
                break;
            case "left":
                handleLeft(matrix, rowI, colI, result);
                break;
            case "right":
                handleRight(matrix, rowI, colI, result);
                break;
        }
    }

    private static void handleRight(char[][] matrix, int rowI, int colI, Integer[] result) {
        if (rowI < 0 || rowI >= matrix.length ||
            colI < 0 || colI >= matrix[rowI].length) {
            return;
        }

        int endIndex = colI + 3 < matrix[rowI].length ? colI + 3 : matrix[rowI].length - 1;
        for (int col = colI; col <= endIndex; col++) {
            if (matrix[rowI][col] == '-') {
                continue;
            }

            matrix[rowI][col] = '-';
            result[1]++;
        }
    }

    private static void handleLeft(char[][] matrix, int rowI, int colI, Integer[] result) {
        if (rowI < 0 || rowI >= matrix.length ||
            colI < 0 || colI >= matrix[rowI].length) {
            return;
        }

        int endIndex = colI - 3 >= 0 ? colI - 3 : 0;
        for (int col = colI; col >= endIndex; col--) {
            if (matrix[rowI][col] == '-') {
                continue;
            }

            matrix[rowI][col] = '-';
            result[1]++;
        }
    }

    private static void handleDown(char[][] matrix, int rowI, int colI, Integer[] result) {
        if (rowI < 0 || rowI >= matrix.length ||
            colI < 0 || colI >= matrix[rowI].length) {
            return;
        }

        int endIndex = rowI + 3 < matrix.length ? rowI + 3 : matrix.length - 1;
        for (int row = rowI; row <= endIndex; row++) {
            if (matrix[row][colI] == '-') {
                continue;
            }

            matrix[row][colI] = '-';
            result[1]++;
        }
    }

    private static void handleUp(char[][] matrix, int rowI, int colI, Integer[] result) {
        if (rowI < 0 || rowI >= matrix.length ||
            colI < 0 || colI >= matrix[rowI].length) {
            return;
        }

        int endIndex = rowI - 3 >= 0 ? rowI - 3 : 0;
        for (int row = rowI; row >= endIndex; row--) {
            if (matrix[row][colI] == '-') {
                continue;
            }

            matrix[row][colI] = '-';
            result[1]++;
        }
    }

    private static void collectSeashell(String[] tokens, char[][] matrix, Integer[] result, List<Character> collectedSeashells) {
        var rowI = Integer.parseInt(tokens[1]);
        var colI = Integer.parseInt(tokens[2]);

        if (rowI >= matrix.length || rowI < 0) {
            return;
        }

        char[] row = matrix[rowI];

        if (colI >= row.length || matrix[rowI][colI] == '-' || colI < 0) {
            return;
        }

        char res = matrix[rowI][colI];
        matrix[rowI][colI] = '-';
        result[0]++;
        collectedSeashells.add(res);
    }

    private static char[][] createMatrix(Scanner scanner) {
        var n = Integer.parseInt(scanner.nextLine());
        var matrix = new char[n][];

        for (int row = 0; row < n; row++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            matrix[row] = new char[tokens.length];

            for (int col = 0; col < tokens.length; col++) {
                matrix[row][col] = tokens[col].charAt(0);                
            }
        }

        return matrix;
    }

}
