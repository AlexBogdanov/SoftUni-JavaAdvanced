package p03BuilderDesignPattern.domain.director;

import p03BuilderDesignPattern.domain.builders.Buidler;
import p03BuilderDesignPattern.domain.components.Engine;
import p03BuilderDesignPattern.domain.components.Gps;

public class Director {

    public void constructCityCar(Buidler builder) {
        builder.setType("City car");
        builder.setSeats(4);
        builder.setEngine(new Engine(1.6, 100000));
        builder.setGPS(new Gps("Default route"));
    }

    public void constructSUV(Buidler builder) {
        builder.setType("SUV");
        builder.setSeats(6);
        builder.setEngine(new Engine(2.4, 50000));
        builder.setGPS(new Gps("Default route"));
    }

    public void constructSportsCar(Buidler builder) {
        builder.setType("Sports car");
        builder.setSeats(2);
        builder.setEngine(new Engine(5, 0));
    }

}
