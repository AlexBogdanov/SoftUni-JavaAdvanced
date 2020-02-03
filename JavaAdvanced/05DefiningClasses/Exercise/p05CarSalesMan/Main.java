package p05CarSalesMan;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import p05CarSalesMan.classes.Car;
import p05CarSalesMan.classes.Engine;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String, Engine> engines = readEngines(scanner);
        Set<Car> cars = readCars(scanner, engines);
        printCars(cars);

    }

    private static Map<String, Engine> readEngines(Scanner scanner) {
        Map<String, Engine> engines = new HashMap<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            int power = Integer.parseInt(tokens[1]);
            Engine engine;

            if (tokens.length == 4) {
                int displacement = Integer.parseInt(tokens[2]);
                String efficiency = tokens[3];

                engine = new Engine(model, power, displacement, efficiency);
            } else if (tokens.length == 3) {
                if (tokens[2].matches("\\d+")) {
                    engine = new Engine(model, power, Integer.parseInt(tokens[2]));
                } else {
                    engine = new Engine(model, power, tokens[2]);
                }
            } else {
                engine = new Engine(model, power);
            }

            engines.put(model, engine);
        }

        return engines;
    }

    private static Set<Car> readCars(Scanner scanner, Map<String, Engine> engines) {
        Set<Car> cars = new LinkedHashSet<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            String engineModel = tokens[1];
            Engine engine = engines.get(engineModel);
            Car car;

            if (tokens.length == 4) {
                int weight = Integer.parseInt(tokens[2]);
                String color = tokens[3];

                car = new Car(model, engine, weight, color);
            } else if (tokens.length == 3) {
                if (tokens[2].matches("\\d+")) {
                    car = new Car(model, engine, Integer.parseInt(tokens[2]));
                } else {
                    car = new Car(model, engine, tokens[2]);
                }
            } else {
                car = new Car(model, engine);
            }

            cars.add(car);
        }

        return cars;
    }

    private static void printCars(Set<Car> cars) {
        for (Car car : cars) {
            car.printCar();
        }
    }

}
