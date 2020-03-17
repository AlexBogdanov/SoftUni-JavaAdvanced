package p03Animals.domain;

public class Dog extends Animal {

    public Dog(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    public String explainSelf() {
        return this.explainBase() + "DJAAF";
    }

}
