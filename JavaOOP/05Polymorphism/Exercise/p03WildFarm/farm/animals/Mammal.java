package p03WildFarm.farm.animals;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {

    private String livingRegion;

    public Mammal(
        String animalName,
        double animalWeight,
        String livingRegion
    ) {
        super(animalName, animalWeight);
        this.livingRegion = livingRegion;
    }

    public String getLivingRegion() {
        return this.livingRegion;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return String.format(
            "%s[%s, %s, %s, %d]",
            this.getClass().getSimpleName(),
            this.getAnimalName(),
            df.format(this.getAnimalWeight()),
            this.getLivingRegion(),
            this.getFoodEaten()
        );
    }

}
