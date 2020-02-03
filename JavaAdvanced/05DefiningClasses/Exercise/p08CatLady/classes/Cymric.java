package p08CatLady.classes;

public class Cymric extends Cat {

    public double furLength;

    public Cymric(String name, double furLength) {
        super(name, "Cymric");
        this.furLength = furLength;
    }

    public String toString() {
        return String.format(
            "%s %s %.2f",
            this.breed, this.name, this.furLength
        );
    }

}
