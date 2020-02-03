package p03SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String, Car> cars = createCars(scanner);
        driveCars(scanner, cars);
        printOutput(cars);

    }

    private static Map<String, Car> createCars(Scanner scanner) {
        Map<String, Car> cars = new LinkedHashMap<>();
        int carsNum = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < carsNum; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            Car car = createCar(tokens);
            cars.put(tokens[0], car);
        }

        return cars;
    }

    private static Car createCar(String[] tokens) {
        String model = tokens[0];
        double fuelAmount = Double.parseDouble(tokens[1]);
        double fuelCostPerKm = Double.parseDouble(tokens[2]);

        Car car = new Car(model, fuelAmount, fuelCostPerKm);
        return car;
    }

    private static void driveCars(Scanner scanner, Map<String, Car> cars) {
        for (String input = scanner.nextLine(); !"End".equals(input); input = scanner.nextLine()) {
            String[] tokens = input.split("\\s+");
            driveCar(tokens, cars);
        }
    }

    private static void driveCar(String[] tokens, Map<String, Car> cars) {
        String model = tokens[1];
        double distance = Double.parseDouble(tokens[2]);
        Car car = cars.get(model);
        car.drive(distance);
    }

    private static void printOutput(Map<String, Car> cars) {
        for (Map.Entry<String, Car> pair : cars.entrySet()) {
            pair.getValue().printInfo();
        }
    }

}
