package p06Animals.animals.dogs;

import p06Animals.animals.Animal;

public class Dog extends Animal {

    private static final String SOUND = "Woof!";

    public Dog(String name, int age, String gender) {
        super(name, age, gender);
    }

    public String produceSound() {
        return SOUND;
    }

}
