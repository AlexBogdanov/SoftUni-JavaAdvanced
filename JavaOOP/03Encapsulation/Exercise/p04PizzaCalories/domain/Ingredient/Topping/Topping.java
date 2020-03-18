package p04PizzaCalories.domain.Ingredient.Topping;

import p04PizzaCalories.domain.Ingredient.Ingredient;

public class Topping implements Ingredient {

    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    @Override
    public double calculateCalories() {
        ToppingType toppingTypeEn = ToppingType.valueOf(toppingType.toUpperCase());
        return 2 * this.weight * toppingTypeEn.getModifier();
    }

    private void setToppingType(String toppingType) {
        if (!ToppingType.isValid(toppingType)) {
            throw new IllegalArgumentException(String.format(
                "Cannot place %s on top of your pizza.",
                toppingType
            ));
        }

        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(String.format(
                "%s weight should be in the range [1..50].",
                this.toppingType
            ));
        }

        this.weight = weight;
    }

}
