package p04PizzaCalories.domain.Ingredient.Topping;

public enum ToppingType {

    MEAT(1.2),
    VEGGIES(0.8),
    CHEESE(1.1),
    SAUCE(0.9);

    private final double modifier;

    private ToppingType(double modifier) {
        this.modifier = modifier;
    }

    public double getModifier() {
        return this.modifier;
    }

    public static boolean isValid(String toppingType) {
        boolean isValid = false;

        for (ToppingType type : ToppingType.values()) {
            if (type.toString().equals(toppingType.toUpperCase())) {
                isValid = true;
                break;
            }
        }

        return isValid;
    }

}
