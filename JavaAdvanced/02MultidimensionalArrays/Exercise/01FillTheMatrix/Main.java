import java.util.Scanner;

class Main {

    public static void main (String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split(", +");
        int size = Integer.parseInt(tokens[0]);
        String pattern = tokens[1];
        int[][] matrix = new int[size][size];

        switch (pattern) {
            case "A":
                matrix = createPatternA(size);
                break;
            case "B":
                matrix = createPatternB(size);
                break;
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            
            System.out.println();
        }
    }

    private static int[][] createPatternA (int s) {
        int[][] matrix = new int[s][s];
        int counter = 1;

        for (int col = 0; col < s; col++) {
            for (int row = 0; row < s; row++) {
                matrix[row][col] = counter++;
            }
        }

        return matrix;
    }

    private static int[][] createPatternB (int s) {
        int[][] matrix = new int[s][s];
        int counter = 1;

        for (int col = 0; col < s; col++) {
            if (col == 0 || col % 2 == 0) {
                for (int row = 0; row < s; row++) {
                    matrix[row][col] = counter++;
                }
            } else {
                for (int row = s - 1; row >= 0; row--) {
                    matrix[row][col] = counter++;
                }
            }
        }

        return matrix;
    }

}
