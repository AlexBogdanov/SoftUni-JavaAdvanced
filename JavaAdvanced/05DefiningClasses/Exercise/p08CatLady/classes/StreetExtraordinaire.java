package p08CatLady.classes;

public class StreetExtraordinaire extends Cat {

    public double decibelsOfMeows;

    public StreetExtraordinaire(String name, double decibelsOfMeows) {
        super(name, "StreetExtraordinaire");
        this.decibelsOfMeows = decibelsOfMeows;
    }

    public String toString() {
        return String.format(
            "%s %s %.2f",
            this.breed, this.name, this.decibelsOfMeows
        );
    }

}
