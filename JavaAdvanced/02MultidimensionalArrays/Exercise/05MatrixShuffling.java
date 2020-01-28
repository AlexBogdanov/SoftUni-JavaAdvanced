import java.util.Scanner;
import java.util.stream.Stream;

class Main {

    public static void main (String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int[] arrayDimensions = Stream.of(scanner.nextLine().split("\\s+"))
            .map(el -> el.trim())
            .mapToInt(n -> Integer.parseInt(n))
            .toArray();
        String[][] matrix = readMatrix(scanner, arrayDimensions);
        String command = scanner.nextLine();

        while (!"END".equals(command)) {
            String[] tokens = command.split("\\s+");
            boolean isCommandValid = checkCommandValidity(tokens, arrayDimensions);

            if (isCommandValid) {
                matrix = rearrangeMatrix(matrix, tokens);

                for (int row = 0; row < matrix.length; row++) {
                    for (int col = 0; col < matrix[row].length; col++) {
                        System.out.print(matrix[row][col] + " ");
                    }

                    System.out.println();
                }
            } else {
                System.out.println("Invalid input!");
            }

            command = scanner.nextLine();
        }

    }

    private static String[][] readMatrix (Scanner scanner, int[] arrayDimensions) {
        String[][] matrix = new String[arrayDimensions[0]][arrayDimensions[1]];
        
        for (int row = 0; row < arrayDimensions[0]; row++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            for (int col = 0; col < arrayDimensions[1]; col++) {
                matrix[row][col] = tokens[col];
            }
        }

        return matrix;
    }

    private static boolean checkCommandValidity (String[] tokens, int[] arrayDimensions) {
        boolean isValid = false;

        if ("swap".equals(tokens[0]) && tokens.length == 5) {
            int row = arrayDimensions[0];
            int col = arrayDimensions[0];
            int row1 = Integer.parseInt(tokens[1]);
            int col1 = Integer.parseInt(tokens[2]);
            int row2 = Integer.parseInt(tokens[3]);
            int col2 = Integer.parseInt(tokens[4]);

            if (row1 >= 0 && row1 <= row && row2 >= 0 && row2 <= row &&
                col1 >= 0 && col1 <= col && col2 >= 0 && col2 <= col) {
                isValid = true;
            }
        }

        return isValid;
    }

    private static String[][] rearrangeMatrix (String[][] matrix, String[] tokens) {
        String[][] newMatrix = matrix;
        int row1 = Integer.parseInt(tokens[1]);
        int col1 = Integer.parseInt(tokens[2]);
        int row2 = Integer.parseInt(tokens[3]);
        int col2 = Integer.parseInt(tokens[4]);

        String temp = newMatrix[row1][col1];
        newMatrix[row1][col1] = newMatrix[row2][col2];
        newMatrix[row2][col2] = temp;

        return newMatrix;
    }

}
