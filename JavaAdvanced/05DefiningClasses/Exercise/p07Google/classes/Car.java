package p07Google.classes;

public class Car {

    public String model;
    public int speed;

    public Car(String model, int speed) {
        this.model = model;
        this.speed = speed;
    }

    public Car() {
        this.model = "n/a";
        this.speed = -1;
    }

}
