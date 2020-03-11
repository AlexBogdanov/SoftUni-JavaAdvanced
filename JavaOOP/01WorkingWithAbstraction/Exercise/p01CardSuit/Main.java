package p01CardSuit;

import java.util.Scanner;

import p01CardSuit.enums.CardSuit.CardSuit;

public class Main {

    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        scanner.close();

        StringBuilder sb = new StringBuilder();
        sb.append("Card Suits:").append(System.lineSeparator());
        
        for (CardSuit suit : CardSuit.values()) {
            sb.append(String.format(
                "Ordinal value: %d; Name value: %s%n",
                suit.ordinal(), suit
            ));
        }

        System.out.println(sb.toString());

    }

}
