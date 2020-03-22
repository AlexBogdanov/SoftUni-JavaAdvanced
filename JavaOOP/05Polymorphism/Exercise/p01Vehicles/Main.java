
package p01Vehicles;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

import p01Vehicles.vehicles.Car;
import p01Vehicles.vehicles.Truck;
import p01Vehicles.vehicles.Vehicle;

public class Main {
    private static final DecimalFormat DF = new DecimalFormat("#.##");

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split(" ");
        double fuel = Double.parseDouble(tokens[1]);
        double consumption = Double.parseDouble(tokens[2]);
        Vehicle car = new Car(fuel, consumption);

        tokens = scanner.nextLine().split(" ");
        fuel = Double.parseDouble(tokens[1]);
        consumption = Double.parseDouble(tokens[2]);
        Vehicle truck = new Truck(fuel, consumption);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            tokens = scanner.nextLine().split(" ");
            String command = tokens[0];
            String vehicleType = tokens[1];
            switch (command) {
                case "Drive":
                    executeDriveCommand(tokens[2], car, truck, vehicleType);
                    break;
                case "Refuel":
                    executeRefuelCommand(tokens[2], car, truck, vehicleType);
                    break;
            }
        }
        scanner.close();
        System.out.println(car);
        System.out.println(truck);

    }

    private static void executeRefuelCommand(String token, Vehicle car, Vehicle truck, String vehicleType) {
        double quantity = Double.parseDouble(token);
        switch (vehicleType) {
            case "Car":
                car.refuel(quantity);
                break;
            case "Truck":
                truck.refuel(quantity);
                break;
        }
    }

    private static void executeDriveCommand(String token, Vehicle car, Vehicle truck, String vehicleType) {
        double distance = Double.parseDouble(token);
        switch (vehicleType) {
            case "Car":
                if (car.drive(distance)) {
                    System.out.println(String.format("Car travelled %s km", DF.format(distance)));
                } else {
                    System.out.println("Car needs refueling");
                }
                break;
            case "Truck":
                if (truck.drive(distance)) {
                    System.out.println(String.format("Truck travelled %s km", DF.format(distance)));
                } else {
                    System.out.println("Truck needs refueling");
                }
                break;
        }
    }
}