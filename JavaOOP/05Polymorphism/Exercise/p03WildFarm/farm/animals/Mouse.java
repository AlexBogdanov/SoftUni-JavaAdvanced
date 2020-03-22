package p03WildFarm.farm.animals;

import p03WildFarm.farm.foods.Food;
import p03WildFarm.farm.foods.Vegetable;

public class Mouse extends Mammal {

    public Mouse(
        String animalName,
        double animalWeight,
        String livingRegion
    ) {
        super(animalName, animalWeight, livingRegion);
    }

	@Override
	public void makeSound() {
        System.out.println("SQUEEEAAAK!");
	}

	@Override
	public void eat(Food food) {
		if (food instanceof Vegetable) {
            super.eat(food);
            return;
        }

        throw new IllegalArgumentException("Mice are not eating that type of food!");
	}

}
