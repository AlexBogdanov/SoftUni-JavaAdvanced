package p03CardsWithPower.enums.CardSuit;

enum CardSuitEnum {
    CLUBS,
    DIAMONDS,
    HEARTS,
    SPADES
}

public class CardSuit {

    private CardSuitEnum suit;

    public CardSuit(String suit) {
        this.suit = CardSuitEnum.valueOf(suit);
    }

    public CardSuitEnum getSuit() {
        return this.suit;
    }

    public int getVal() {
        switch (this.suit) {
            case CLUBS:
                return 0;
            case DIAMONDS:
                return 13;
            case HEARTS:
                return 26;
            default:
                return 39;
        }
    }

}
