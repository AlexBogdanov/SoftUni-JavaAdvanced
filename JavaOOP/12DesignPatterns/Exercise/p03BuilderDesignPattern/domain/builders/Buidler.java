package p03BuilderDesignPattern.domain.builders;

import p03BuilderDesignPattern.domain.components.Engine;
import p03BuilderDesignPattern.domain.components.Gps;

public interface Buidler {

    void setType(String type);
    void setSeats(int seats);
    void setEngine(Engine engine);
    void setGPS(Gps gps);

}
