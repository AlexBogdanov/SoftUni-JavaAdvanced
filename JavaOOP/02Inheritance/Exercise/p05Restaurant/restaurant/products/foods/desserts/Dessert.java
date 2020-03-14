package p05Restaurant.restaurant.products.foods.desserts;

import java.math.BigDecimal;

import p05Restaurant.restaurant.products.foods.Food;

public class Dessert extends Food {

    private double calories;

    public Dessert(String name, BigDecimal price, double grams, double calories) {
        super(name, price, grams);
        this.calories = calories;
    }

    public double getCalories() {
        return this.calories;
    }

}
