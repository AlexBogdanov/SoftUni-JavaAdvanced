package p06Animals.animals.cats;

import p06Animals.animals.Animal;

public class Cat extends Animal {

    private static final String SOUND = "Meow meow";

    public Cat(String name, int age, String gender) {
        super(name, age, gender);
    }
    
    public String produceSound() {
        return SOUND;
    }

}
