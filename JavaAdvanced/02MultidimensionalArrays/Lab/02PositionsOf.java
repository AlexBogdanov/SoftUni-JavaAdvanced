import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class Main {

    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrix(scanner);
        int numToMatch = scanner.nextInt();
        Deque<String> queue = new ArrayDeque<>();
        
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == numToMatch) {
                    queue.offer(row + " " + col);
                }
            }
        }

        if (queue.size() > 0) {
            while (queue.size() > 0) {
                System.out.println(queue.poll());
            }
        } else {
            System.out.println("not found");
        }

    }

    private static int[][] readMatrix (Scanner scanner) {
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        scanner.nextLine();
        int[][] matrix = new int[r][c];

        for (int row = 0; row < r; row++) {
            for (int col = 0; col < c; col++) {
                matrix[row][col] = scanner.nextInt();
            }

            scanner.nextLine();
        }

        return matrix;
    }

}
