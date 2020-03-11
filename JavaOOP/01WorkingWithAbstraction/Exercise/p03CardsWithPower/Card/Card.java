package p03CardsWithPower.Card;

import p03CardsWithPower.enums.CardRank.CardRank;
import p03CardsWithPower.enums.CardSuit.CardSuit;

public class Card {

    private CardSuit suit;
    private CardRank rank;

    public Card(CardSuit suit, CardRank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    private int getPower() {
        return this.suit.getVal() + this.rank.getVal();
    }

    @Override
    public String toString() {
        return String.format(
            "Card name: %s of %s; Card power: %d",
            this.rank.getRank(), this.suit.getSuit(), getPower()
        );
    }

}
