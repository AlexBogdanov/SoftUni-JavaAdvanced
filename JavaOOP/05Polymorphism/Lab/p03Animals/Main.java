package p03Animals;

import p03Animals.domain.Animal;
import p03Animals.domain.Cat;
import p03Animals.domain.Dog;

public class Main {

    public static void main(String[] args) {

        Animal cat = new Cat("Oscar", "Whiskas");
        Animal dog = new Dog("Rocky", "Meat");
        
        System.out.println(cat.explainSelf());
        System.out.println(dog.explainSelf());


    }

}
