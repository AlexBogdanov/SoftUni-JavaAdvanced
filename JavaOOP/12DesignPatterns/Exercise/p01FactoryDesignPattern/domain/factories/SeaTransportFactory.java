package p01FactoryDesignPattern.domain.factories;

import p01FactoryDesignPattern.domain.classes.SeaTransport;
import p01FactoryDesignPattern.domain.classes.Transport;

public class SeaTransportFactory extends TransportFactory {

    @Override
    public Transport createTransport(String transportType) {
        return new SeaTransport(transportType);
    }

}
