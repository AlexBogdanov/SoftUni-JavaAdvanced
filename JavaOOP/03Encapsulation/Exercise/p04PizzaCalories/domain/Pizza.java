package p04PizzaCalories.domain;

import java.util.ArrayList;
import java.util.List;

import p04PizzaCalories.domain.Ingredient.Dough.Dough;
import p04PizzaCalories.domain.Ingredient.Topping.Topping;

public class Pizza {

    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name, int numberOfToppings) {
        this.setName(name);
        this.setToppings(numberOfToppings);
    }

    public void addTopping(Topping topping) {
        this.toppings.add(topping);
    }

    public double getOverallCalories() {
        double doughCalories = this.dough.calculateCalories();
        double toppingCalories = 0;

        for (Topping topping : this.toppings) {
            toppingCalories += topping.calculateCalories();
        }

        return doughCalories + toppingCalories;
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name.trim().isEmpty() || name.length() < 1 ||name.length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }

        this.name = name;
    }

    private void setToppings(int numberOfToppings) {
        if (numberOfToppings < 0 || numberOfToppings > 10) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }

        this.toppings = new ArrayList<>();
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

}
