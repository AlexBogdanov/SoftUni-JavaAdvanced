package p05Restaurant.restaurant.products.foods;

import java.math.BigDecimal;

import p05Restaurant.restaurant.products.Product;

public class Food extends Product {

    private double grams;

    public Food(String name, BigDecimal price, double grams) {
        super(name, price);
        this.grams = grams;
    }

    public double getGrams() {
        return this.grams;
    }

}
