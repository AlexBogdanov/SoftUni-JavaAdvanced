package p01FactoryDesignPattern.domain.factories;

import p01FactoryDesignPattern.domain.classes.LandTransport;
import p01FactoryDesignPattern.domain.classes.Transport;

public class LandTrasportFactory extends TransportFactory {

    @Override
    public Transport createTransport(String transportType) {
        return new LandTransport(transportType);
    }

}
