package p03WildFarm.farm.animals;

import p03WildFarm.farm.foods.Food;
import p03WildFarm.farm.foods.Meat;

public class Tiger extends Feline {

    public Tiger(
        String animalName,
        double animalWeight,
        String livingRegion
    ) {
        super(animalName, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Meat) {
            super.eat(food);
            return;
        }

        throw new IllegalArgumentException("Tigers are not eating that type of food!");
    }

}
