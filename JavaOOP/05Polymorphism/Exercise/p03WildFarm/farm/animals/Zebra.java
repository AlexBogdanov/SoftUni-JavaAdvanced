package p03WildFarm.farm.animals;

import p03WildFarm.farm.foods.Food;
import p03WildFarm.farm.foods.Vegetable;

public class Zebra extends Mammal {

    public Zebra(String animalName, double animalWeight, String livingRegion) {
        super(animalName, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Vegetable) {
            super.eat(food);
            return;
        }

        throw new IllegalArgumentException("Zebras are not eating that type of food!");
    }

}