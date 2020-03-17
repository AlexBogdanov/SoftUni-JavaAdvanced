package p03Animals.domain;

public abstract class Animal {

    private String name;
    private String favouriteFood;

    protected Animal(String name, String favouriteFood) {
        this.name = name;
        this.favouriteFood = favouriteFood;
    }

    public abstract String explainSelf();
    
    public String explainBase() {
        return String.format(
            "I am %s and my favourite food is %s%n",
            this.name,
            this.favouriteFood
        );
    }

}
