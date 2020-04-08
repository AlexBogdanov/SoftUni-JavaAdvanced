package p03BuilderDesignPattern.domain.cars;

import p03BuilderDesignPattern.domain.components.Engine;
import p03BuilderDesignPattern.domain.components.Gps;

public class ManualCar {

    private String type;
    private int seats;
    private Engine engine;
    private Gps gps;

    public ManualCar(String type, int seats, Engine engine, Gps gps) {
        this.type = type;
        this.seats = seats;
        this.engine = engine;
        this.gps = gps;
    }

    public ManualCar(String type, int seats, Engine engine) {
        this.type = type;
        this.seats = seats;
        this.engine = engine;
    }

    public void changeGear() {
        System.out.println("Manually changing gear");
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
            "Type: %s; Seats: %d; Engine: %s;",
            this.type,
            this.seats,
            this.engine.toString()
        );
    }

}
