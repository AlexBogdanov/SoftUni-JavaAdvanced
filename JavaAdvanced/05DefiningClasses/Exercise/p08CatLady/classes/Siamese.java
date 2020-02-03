package p08CatLady.classes;

public class Siamese extends Cat {

    public double earSize;

    public Siamese(String name, double earSize) {
        super(name, "Siamese");
        this.earSize = earSize;
    }

    public String toString() {
        return String.format(
            "%s %s %.2f",
            this.breed, this.name, this.earSize
        );
    }

}
