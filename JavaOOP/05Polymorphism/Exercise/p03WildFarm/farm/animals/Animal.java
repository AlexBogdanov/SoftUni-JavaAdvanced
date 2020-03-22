package p03WildFarm.farm.animals;

import p03WildFarm.farm.foods.Food;

public abstract class Animal {

    private String animalName;
    private double animalWeight;
    private Integer foodEaten = 0;

    protected Animal(
        String animalName,
        double animalWeight
    ) {
        this.animalName = animalName;
        this.animalWeight = animalWeight;
    }

    public abstract void makeSound();

    public void eat(Food food) {
        this.foodEaten += food.getQuantity();
    };

    public String getAnimalName() {
        return this.animalName;
    }

    protected void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public double getAnimalWeight() {
        return this.animalWeight;
    }

    protected void setAnimalWeight(double animalWeight) {
        this.animalWeight = animalWeight;
    }

    public Integer getFoodEaten() {
        return this.foodEaten;
    }

}
