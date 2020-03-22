package p03WildFarm.farm.animals;

import java.text.DecimalFormat;

public class Cat extends Feline {

    private String breed;

    public Cat(
        String animalName,
        double animalWeight,
        String livingRegion,
        String breed
    ) {
        super(animalName, animalWeight, livingRegion);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return String.format(
            "%s[%s, %s, %s, %s, %d]",
            this.getClass().getSimpleName(),
            this.getAnimalName(),
            this.breed,
            df.format(this.getAnimalWeight()),
            this.getLivingRegion(),
            this.getFoodEaten()
        );
    }

}