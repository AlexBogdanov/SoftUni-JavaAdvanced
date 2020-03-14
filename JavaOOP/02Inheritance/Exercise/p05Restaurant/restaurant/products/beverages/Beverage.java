package p05Restaurant.restaurant.products.beverages;
import java.math.BigDecimal;

import p05Restaurant.restaurant.products.Product;

public class Beverage extends Product {

    private double milliliters;

    public Beverage(String name, BigDecimal price, double milliliters) {
        super(name, price);
        this.milliliters = milliliters;
    }

    public double getMilliliters() {
        return this.milliliters;
    }

}
