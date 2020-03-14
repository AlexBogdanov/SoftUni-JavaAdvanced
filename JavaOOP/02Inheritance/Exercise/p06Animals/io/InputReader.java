package p06Animals.io;

import java.util.Scanner;

import p06Animals.animals.cats.Cat;
import p06Animals.animals.cats.Kitten;
import p06Animals.animals.cats.Tomcat;
import p06Animals.animals.dogs.Dog;
import p06Animals.animals.frogs.Frog;
import p06Animals.validators.InputValidator;

public class InputReader {

    private String animalType;
    private String[] animalArgs;

    public InputReader(Scanner scanner) throws Exception {
        readInput(scanner);
    }

    public String getInfo() {
        switch (this.animalType) {
            case "Dog":
                Dog dog = new Dog(
                    this.getAnimalName(),
                    this.getAnimalAge(),
                    this.getAnimalGender()
                );
                return String.format("%s%n%s%n%s", this.animalType, dog.toString(), dog.produceSound());
            case "Frog":
                Frog frog = new Frog(
                    this.getAnimalName(),
                    this.getAnimalAge(),
                    this.getAnimalGender()
                );
                return String.format("%s%n%s%n%s", this.animalType, frog.toString(), frog.produceSound());
            case "Cat":
                Cat cat = new Cat(
                    this.getAnimalName(),
                    this.getAnimalAge(),
                    this.getAnimalGender()
                );
                return String.format("%s%n%s%n%s", this.animalType, cat.toString(), cat.produceSound());
            case "Kitten":
                Kitten kitten = new Kitten(
                    this.getAnimalName(), 
                    this.getAnimalAge()
                );
                return String.format("%s%n%s%n%s", this.animalType, kitten.toString(), kitten.produceSound());
            default:
                Tomcat tomcat = new Tomcat(
                    this.getAnimalName(),
                    this.getAnimalAge()
                );
                return String.format("%s%n%s%n%s", this.animalType, tomcat.toString(), tomcat.produceSound());
        }
    }

    private String getAnimalName() {
        return this.animalArgs[0];
    }

    private int getAnimalAge() {
        return Integer.parseInt(this.animalArgs[1]);
    }

    private String getAnimalGender() {
        return this.animalArgs[2];
    }

    private void readInput(Scanner scanner) throws Exception {
        String animalType = scanner.nextLine();

        if (animalType.equals("Beast!")) {
            throw new Exception("No more animals");
        }

        String[] animalArgs = scanner.nextLine().split("\\s+");
        
        if (!isInputValid(animalType, animalArgs)) {
            throw new Exception("Invalid input!");
        }

        this.animalType = animalType;
        this.animalArgs = animalArgs;
    }

    private boolean isInputValid(String animalType, String[] animalArgs) {
        boolean isAnimalTypeValid = InputValidator.isValidType(animalType);
        boolean areArgsValid = InputValidator.areArgsValid(animalType, animalArgs);

        if (isAnimalTypeValid && areArgsValid) {
            return true;
        }

        return false;
    }

}
