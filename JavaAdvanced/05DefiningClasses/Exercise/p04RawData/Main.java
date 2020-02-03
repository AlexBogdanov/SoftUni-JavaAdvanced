package p04RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import p04RawData.classes.Car;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Car> cars = readCars(scanner);
        StringBuilder sb = handleCommand(scanner.nextLine(), cars);

        System.out.println(sb);

    }

    private static List<Car> readCars(Scanner scanner) {
        List<Car> cars = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];
            double tire1Pressure = Double.parseDouble(tokens[5]);
            int tire1Age = Integer.parseInt(tokens[6]);
            double tire2Pressure = Double.parseDouble(tokens[7]);
            int tire2Age = Integer.parseInt(tokens[8]);
            double tire3Pressure = Double.parseDouble(tokens[9]);
            int tire3Age = Integer.parseInt(tokens[10]);
            double tire4Pressure = Double.parseDouble(tokens[11]);
            int tire4Age = Integer.parseInt(tokens[12]);
            
            Car car = new Car(
                model,
                engineSpeed, enginePower,
                cargoWeight, cargoType,
                tire1Pressure, tire1Age,
                tire2Pressure, tire2Age,
                tire3Pressure, tire3Age,
                tire4Pressure, tire4Age);
            cars.add(car);
        }

        return cars;
    }

    private static StringBuilder handleCommand(String command, List<Car> cars) {
        StringBuilder sb = new StringBuilder();
        List<Car> filteredCars;

        switch (command) {
            case "fragile":
                filteredCars = handleFragile(cars);
                break;
            default:
                filteredCars = handleFlamable(cars);
        }

        for (Car car : filteredCars) {
            sb.append(car.model);
            sb.append(System.lineSeparator());
        }

        return sb;
    }

    private static List<Car> handleFragile(List<Car> cars) {
        List<Car> filteredCars = cars.stream()
            .filter(c -> "fragile".equals(c.cargo.type))
            .filter(c -> {
                boolean areTyresInCondition = false;

                for (int i = 0; i < c.tires.length; i++) {
                    if (c.tires[i].pressure < 1) {
                        areTyresInCondition = true;
                        break;
                    }
                }

                return areTyresInCondition;
            }).collect(Collectors.toList());

        return filteredCars;
    }

    private static List<Car> handleFlamable(List<Car> cars) {
        List<Car> filteredCars = cars.stream()
            .filter(c -> "flamable".equals(c.cargo.type) && c.engine.power > 250)
            .collect(Collectors.toList());
        
        return filteredCars;
    }

}
