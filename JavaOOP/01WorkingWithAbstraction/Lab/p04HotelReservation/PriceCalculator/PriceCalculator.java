package p04HotelReservation.PriceCalculator;

enum Season {
    Autumn,
    Spring,
    Winter,
    Summer
}

enum Discount {
    VIP,
    SecondVisit,
    None
}

public class PriceCalculator {

    private double pricePerDay;
    private int numberOfDays;
    private Season season;
    private Discount discount;

    public PriceCalculator(double pricePerDay, int numberOfDays, String season, String discount) {
        this.pricePerDay = pricePerDay;
        this.numberOfDays = numberOfDays;
        this.season = createSeasonEnum(season);
        this.discount = createDiscountEnum(discount);
    }
    
    private Discount createDiscountEnum(String discount) {
        switch (discount) {
            case "VIP":
                return Discount.VIP;
            case "SecondVisit":
                return Discount.SecondVisit;
            default:
                return Discount.None;
        }
    }

    private Season createSeasonEnum(String season) {
        switch (season) {
            case "Autumn":
                return Season.Autumn;
            case "Winter":
                return Season.Winter;
            case "Spring":
                return Season.Spring;
            default:
                return Season.Summer;
        }
    }

    @Override
    public String toString() {
        double totalPrice = (this.pricePerDay * getSeasonVal()) * this.numberOfDays;
        double finalPrice = totalPrice - (totalPrice * getDiscountVal());

        return String.format("%.2f", finalPrice);
    }

    private double getDiscountVal() {
        switch (this.discount) {
            case VIP:
                return 0.2;
            case SecondVisit:
                return 0.1;
            default:
                return 0;
        }
    }

    private int getSeasonVal() {
        switch (this.season) {
            case Autumn:
                return 1;
            case Spring:
                return 2;
            case Winter:
                return 3;
            default:
                return 4;
        }
    }

}
