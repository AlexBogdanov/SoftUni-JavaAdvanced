package p03CardsWithPower;

import java.util.Scanner;

import p03CardsWithPower.Card.Card;
import p03CardsWithPower.enums.CardRank.CardRank;
import p03CardsWithPower.enums.CardSuit.CardSuit;

public class Main {

    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);
        CardRank rank = new CardRank(scanner.nextLine());
        CardSuit suit = new CardSuit(scanner.nextLine());
        scanner.close();

        Card card = new Card(suit, rank);

        System.out.println(card.toString());

    }

}
