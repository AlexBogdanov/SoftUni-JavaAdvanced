package p02CarShopExtended.domain;

public class Audi extends CarImpl implements Rentable {

    private static final long serialVersionUID = 1L;
    
    private Integer minRentDay;
    private Double pricePerDay;

    public Audi(String model,
                String color,
                Integer horsePower,
                String country,
                Integer minRentDay,
                Double pricePerDay) {
        super(model, color, horsePower, country);
        this.minRentDay = minRentDay;
        this.pricePerDay = pricePerDay;
    }

    @Override
    public Integer getMinRentDay() {
        return this.minRentDay;
    }

    @Override
    public Double getPricePerDay() {
        return this.pricePerDay;
    }

    @Override
    public String toString() {
        return String.format(
            "%s%nMinimal rental period of %d days. Price per day %f",
            super.toString(),
            this.getMinRentDay(),
            this.getPricePerDay()
        );
    }

}
