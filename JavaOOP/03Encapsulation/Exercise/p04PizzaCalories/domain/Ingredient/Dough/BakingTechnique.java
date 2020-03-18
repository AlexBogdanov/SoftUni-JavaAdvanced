package p04PizzaCalories.domain.Ingredient.Dough;

public enum BakingTechnique {

    CRISPY(0.9),
    CHEWY(1.1),
    HOMEMADE(1.0);

    private final double modifier;

    private BakingTechnique(double modifier) {
        this.modifier = modifier;
    }

    public double getModifier() {
        return this.modifier;
    }

    public static boolean isValid(String bakingTechnique) {
        boolean isValid = false;

        for (BakingTechnique technique : BakingTechnique.values()) {
            if (technique.toString().equals(bakingTechnique.toUpperCase())) {
                isValid = true;
                break;
            }
        }

        return isValid;
    }

}
