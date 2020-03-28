package p01SquareRoot;

public class Calculator {

    public static double calcSquareRoot(String num) {

        try {
            int n = Integer.parseInt(num);
            return Math.sqrt(n);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("Invalid number");
        }

    }

}
