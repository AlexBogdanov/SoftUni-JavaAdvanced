package p02CarShopExtended.domain;

public class Seat extends CarImpl implements Sellable {

    private static final long serialVersionUID = 1L;
    
    private Double price;

    public Seat(String model, String color, Integer horsePower, String country, Double price) {
        super(model, color, horsePower, country);
        this.price = price;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }

    @Override
    public String toString(){
        return String.format(
            "%s%n%s sells for %f",
            super.toString(),
            this.getModel(),
            this.getPrice()
        );
    }

}
