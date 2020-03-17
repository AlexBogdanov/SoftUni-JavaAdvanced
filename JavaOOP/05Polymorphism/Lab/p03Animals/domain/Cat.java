package p03Animals.domain;

public class Cat extends Animal {

    public Cat(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    public String explainSelf() {
        return this.explainBase() + "MEEOW";
    }

}
