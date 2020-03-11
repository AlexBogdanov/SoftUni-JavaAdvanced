package p03CardsWithPower.enums.CardRank;

enum CardRankEnum {
    ACE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN,
    JACK,
    QUEEN,
    KING
}

public class CardRank {

    private CardRankEnum rank;

    public CardRank(String rank) {
        this.rank = CardRankEnum.valueOf(rank);
    }

    public CardRankEnum getRank() {
        return this.rank;
    }

    public int getVal() {
        switch (this.rank) {
            case ACE:
                return 14;
            case TWO:
                return 2;
            case THREE:
                return 3;
            case FOUR:
                return 4;
            case FIVE:
                return 5;
            case SIX:
                return 6;
            case SEVEN:
                return 7;
            case EIGHT:
                return 8;
            case NINE:
                return 9;
            case TEN:
                return 10;
            case JACK:
                return 11;
            case QUEEN:
                return 12;
            default:
                return 1;
        }
    }

}
