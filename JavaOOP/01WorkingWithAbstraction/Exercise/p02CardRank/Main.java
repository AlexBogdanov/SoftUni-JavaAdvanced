package p02CardRank;

import java.util.Scanner;

import p02CardRank.enums.CardRank.CardRank;

public class Main {

    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        scanner.close();

        StringBuilder sb = new StringBuilder();
        sb.append("Card Ranks:").append(System.lineSeparator());

        for (CardRank rank : CardRank.values()) {
            sb.append(String.format(
                "Ordinal value: %d; Name value: %s%n",
                rank.ordinal(), rank
            ));
        }

        System.out.println(sb.toString());

    }

}
