package p04PizzaCalories.domain.Ingredient.Dough;

import p04PizzaCalories.domain.Ingredient.Ingredient;

public class Dough implements Ingredient {

    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    @Override
    public double calculateCalories() {
        FlourType flourTypeEn = FlourType.valueOf(this.flourType.toUpperCase());
        BakingTechnique bakingTechniqueEn = BakingTechnique.valueOf(this.bakingTechnique.toUpperCase());
        return 2 * this.weight * flourTypeEn.getModifier() * bakingTechniqueEn.getModifier();
    }
    
    private void setFlourType(String flourType) {
        if (!FlourType.isValid(flourType)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }

        this.flourType = flourType;
    }
    
    private void setBakingTechnique(String bakingTechnique) {
        if (!BakingTechnique.isValid(bakingTechnique)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }

        this.bakingTechnique = bakingTechnique;
    }
    
    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }

        this.weight = weight;
    }

}
