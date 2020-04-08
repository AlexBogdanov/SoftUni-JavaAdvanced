package p01FactoryDesignPattern.domain.factories;

import p01FactoryDesignPattern.domain.classes.Transport;

public abstract class TransportFactory {

    public Transport getTransport(String transportType) {
        Transport transport = createTransport(transportType);
        return transport;
    }

    public abstract Transport createTransport(String transportType);

}
