package p07Google.classes;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private WorkInfo work = new WorkInfo();
    private Car car = new Car();
    private List<Pokemon> pokemons = new ArrayList<>();
    private List<Parent> parents = new ArrayList<>();
    private List<Child> children = new ArrayList<>();

    public Person(String name, String companyName, String departmentName, double salary) {
        this.name = name;
        WorkInfo work = new WorkInfo(companyName, departmentName, salary);
        this.work = work;
    }

    public Person(String name, String carModel, int carSpeed) {
        this.name = name;
        Car car = new Car(carModel, carSpeed);
        this.car = car;
    }

    public Person(String personName, String name, String elBirthday, String type) {
        this.name = personName;

        switch (type) {
            case "pokemon":
                Pokemon pokemon = new Pokemon(name, elBirthday);
                this.pokemons.add(pokemon);
                break;
            case "parents":
                Parent parent = new Parent(name, elBirthday);
                this.parents.add(parent);
                break;
            case "children":
                Child child = new Child(name, elBirthday);
                this.children.add(child);
                break;
        }
    }

    public void updateWork(String companyName, String departmentName, double salary) {
        WorkInfo work = new WorkInfo(companyName, departmentName, salary);
        this.work = work;
    }

    public void updateCar(String model, int speed) {
        Car car = new Car(model, speed);
        this.car = car;
    }

    public void addPokemon(String name, String element) {
        Pokemon pokemon = new Pokemon(name, element);
        this.pokemons.add(pokemon);
    }

    public void addParent(String name, String birthday) {
        Parent parent = new Parent(name, birthday);
        this.parents.add(parent);
    }

    public void addChild(String name, String birthday) {
        Child child = new Child(name, birthday);
        this.children.add(child);
    }

    public StringBuilder getInfo() {
        StringBuilder sb = new StringBuilder();

        sb.append(this.name);
        sb.append(System.lineSeparator());

        if (this.work.salary != -1) {
            sb.append(String.format(
                "Company:%n%s %s %.2f%n",
                this.work.companyName, this.work.departmentName, this.work.salary
            ));
        } else {
            sb.append("Company:");
            sb.append(System.lineSeparator());
        }

        if (this.car.speed != -1) {
            sb.append(String.format(
                "Car:%n%s %d%n",
                this.car.model, this.car.speed
            ));
        } else {
            sb.append("Car:");
            sb.append(System.lineSeparator());
        }
        
        sb.append("Pokemon:");
        sb.append(System.lineSeparator());
        if (this.pokemons.size() > 0) {
            for (Pokemon pokemon : this.pokemons) {
                sb.append(String.format(
                    "%s %s%n",
                    pokemon.getName(), pokemon.getElement()
                ));
            }
        }
        
        sb.append("Parents:");
        sb.append(System.lineSeparator());
        if (this.parents.size() > 0) {
            for (Parent parent : this.parents) {
                sb.append(String.format(
                    "%s %s%n",
                    parent.name, parent.birthday
                ));
            }
        }
        
        sb.append("Children:");
        sb.append(System.lineSeparator());
        if (this.children.size() > 0) {
            for (Child child : this.children) {
                sb.append(String.format(
                    "%s %s%n",
                    child.name, child.birthday
                ));
            }
        }

        return sb;
    }

}
