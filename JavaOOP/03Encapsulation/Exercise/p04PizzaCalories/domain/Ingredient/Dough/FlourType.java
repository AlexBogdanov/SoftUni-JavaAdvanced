package p04PizzaCalories.domain.Ingredient.Dough;

public enum FlourType {

    WHITE(1.5),
    WHOLEGRAIN(1.0);
    
    private final double modifier;

    private FlourType(double modifier) {
        this.modifier = modifier;
    }

    public double getModifier() {
        return this.modifier;
    }

    public static boolean isValid(String flourType) {
        boolean isValid = false;

        for (FlourType type : FlourType.values()) {
            if (type.toString().equals(flourType.toUpperCase())) {
                isValid = true;
                break;
            }
        }

        return isValid;
    }

}
