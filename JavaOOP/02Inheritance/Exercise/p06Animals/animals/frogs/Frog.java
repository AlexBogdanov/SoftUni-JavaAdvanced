package p06Animals.animals.frogs;

import p06Animals.animals.Animal;

public class Frog extends Animal {

    private static final String SOUND = "Ribbit";

    public Frog(String name, int age, String gender) {
        super(name, age, gender);
    }

    public String produceSound() {
        return SOUND;
    }

}
