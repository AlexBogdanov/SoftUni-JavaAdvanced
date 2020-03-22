package p02VehiclesExtension;

import java.io.IOException;
import java.util.Scanner;

import p02VehiclesExtension.vehicles.Bus;
import p02VehiclesExtension.vehicles.Car;
import p02VehiclesExtension.vehicles.Truck;
import p02VehiclesExtension.vehicles.Vehicle;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        Vehicle car = createVehicle(scanner);
        Vehicle truck = createVehicle(scanner);
        Bus bus = (Bus) createVehicle(scanner);

        handleCommands(scanner, car, truck, bus);
        scanner.close();
        print(car, truck, bus);

    }

    private static void print(Vehicle car, Vehicle truck, Bus bus) {
        System.out.println(car.toString());
        System.out.println(truck.toString());
        System.out.println(bus.toString());
    }

    private static void handleCommands(Scanner scanner, Vehicle car, Vehicle truck, Bus bus) {
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            double distOrLt = Double.parseDouble(tokens[2]);

            switch(tokens[0]) {
                case "Drive":
                    driveVehicle(tokens[1], distOrLt, car, truck, bus);
                    break;
                case "DriveEmpty":
                    bus.driveWithoutPeople(distOrLt);
                    break;
                case "Refuel":
                    refuelVehicle(tokens[1], distOrLt, car, truck, bus);
                    break;
            }
        }
    }

    private static void refuelVehicle(String vehicleType, double fuel, Vehicle car, Vehicle truck, Bus bus) {
        switch(vehicleType) {
            case "Car":
                car.refuel(fuel);
                break;
            case "Truck":
                truck.refuel(fuel);
                break;
            case "Bus":
                bus.refuel(fuel);
                break;
        }
    }

    private static void driveVehicle(String vehicleType, double kilometers, Vehicle car, Vehicle truck, Bus bus) {
        switch(vehicleType) {
            case "Car":
                car.drive(kilometers);
                break;
            case "Truck":
                truck.drive(kilometers);
                break;
            case "Bus":
                bus.drive(kilometers);
                break;
        }
    }

    private static Vehicle createVehicle(Scanner scanner) throws IOException {
        Vehicle vehicle;
        String[] tokens = scanner.nextLine().split("\\s+");
        double fuelQuantity = Double.parseDouble(tokens[1]);
        double fuelConsumption = Double.parseDouble(tokens[2]);
        double tankCapacity = Double.parseDouble(tokens[3]);

        switch(tokens[0]) {
            case "Car":
                vehicle = new Car(fuelQuantity, fuelConsumption, tankCapacity);
                break;
            case "Truck":
                vehicle = new Truck(fuelQuantity, fuelConsumption, tankCapacity);
                break;
            case "Bus":
                vehicle = new Bus(fuelQuantity, fuelConsumption, tankCapacity);
                break;
            default:
                throw new IOException("Illegal argument");
        }

        return vehicle;
    }

}
