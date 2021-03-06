package p03BuilderDesignPattern.domain.builders;

import p03BuilderDesignPattern.domain.cars.Car;
import p03BuilderDesignPattern.domain.components.Engine;
import p03BuilderDesignPattern.domain.components.Gps;

public class CarBuilder implements Buidler {

    private String type;
    private int seats;
    private Engine engine;
    private Gps gps;

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void setGPS(Gps gps) {
        this.gps = gps;
    }

    public Car build() {
        return new Car(this.type, this.seats, this.engine, this.gps);
    }

}
