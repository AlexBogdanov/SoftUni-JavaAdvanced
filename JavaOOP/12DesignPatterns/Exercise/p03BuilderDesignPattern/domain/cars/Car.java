package p03BuilderDesignPattern.domain.cars;

import p03BuilderDesignPattern.domain.components.Engine;
import p03BuilderDesignPattern.domain.components.Gps;

public class Car {

    private String type;
    private int seats;
    private Engine engine;
    private Gps gps;

    public Car(String type, int seats, Engine engine, Gps gps) {
        this.type = type;
        this.seats = seats;
        this.engine = engine;
        this.gps = gps;
    }

    public void changeGear() {
        System.out.println("Automatically changing gear");
    }

    public String getType() {
        return this.type;
    }

    public int getSeats() {
        return this.seats;
    }

    public Engine getEngine() {
        return this.engine;
    }

    public Gps getGps() {
        return this.gps;
    }

    @Override
    public String toString() {
        return String.format(
            "Type: %s; Seats: %d; Engine: %s; Gps: %s",
            this.type,
            this.seats,
            this.engine.toString(),
            this.gps.toString()
        );
    }

}
