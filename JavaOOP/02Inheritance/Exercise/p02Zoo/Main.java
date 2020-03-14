package p02Zoo;

import p02Zoo.zoo.Animal;
import p02Zoo.zoo.Bear;
import p02Zoo.zoo.Gorilla;
import p02Zoo.zoo.Lizard;
import p02Zoo.zoo.Mammal;
import p02Zoo.zoo.Reptile;
import p02Zoo.zoo.Snake;

public class Main {

    public static void main(String[] args) {
        
        Animal animal = new Animal("animal");

        Mammal mammal = new Mammal("mammal");
        Gorilla gorilla = new Gorilla("gorilla");
        Bear bear = new Bear("bear");

        Reptile reptile = new Reptile("reptile");
        Lizard lizard = new Lizard("lizard");
        Snake snake = new Snake("snake");

        System.out.println(animal.getName());

        System.out.println(mammal.getName());
        System.out.println(gorilla.getName());
        System.out.println(bear.getName());

        System.out.println(reptile.getName());
        System.out.println(lizard.getName());
        System.out.println(snake.getName());

    }

}