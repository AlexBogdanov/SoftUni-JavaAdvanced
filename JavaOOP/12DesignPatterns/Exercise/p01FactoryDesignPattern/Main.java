package p01FactoryDesignPattern;

import java.util.Scanner;

import p01FactoryDesignPattern.domain.classes.Transport;
import p01FactoryDesignPattern.domain.factories.LandTrasportFactory;
import p01FactoryDesignPattern.domain.factories.SeaTransportFactory;
import p01FactoryDesignPattern.domain.factories.TransportFactory;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        TransportFactory factory = createFactory(scanner);
        Transport transport = createTransport(scanner, factory);

        scanner.close();

        printTransport(transport);

    }

    private static void printTransport(Transport transport) {
        transport.transport("box");
    }

    private static Transport createTransport(Scanner scanner, TransportFactory factory) {
        String transportType = scanner.nextLine();
        return factory.getTransport(transportType);
    }

    private static TransportFactory createFactory(Scanner scanner) {
        String factoryType = scanner.nextLine();

        switch (factoryType) {
            case "land":
                return new LandTrasportFactory();
            case "sea":
                return new SeaTransportFactory();
            default:
                return null;
        }
    }

}
