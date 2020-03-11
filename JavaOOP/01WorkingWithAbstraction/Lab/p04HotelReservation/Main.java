package p04HotelReservation;

import java.util.Scanner;

import p04HotelReservation.PriceCalculator.PriceCalculator;

public class Main {

    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split("\\s+");
        scanner.close();

        double pricePerDay = Double.parseDouble(tokens[0]);
        int numberOfDays = Integer.parseInt(tokens[1]);
        PriceCalculator priceCalculator = new PriceCalculator(pricePerDay, numberOfDays, tokens[2], tokens[3]);

        System.out.println(priceCalculator.toString());

    }

}
