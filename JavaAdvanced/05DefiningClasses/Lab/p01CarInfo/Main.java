package p01CarInfo;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Set<Car> cars = createCars(scanner);
        StringBuilder sb = formOutput(cars);

        System.out.println(sb);

    }

    private static Set<Car> createCars(Scanner scanner) {
        Set<Car> cars = new LinkedHashSet<>();
        int carsNum = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < carsNum; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            Car car;

            if (tokens.length > 1) {
                String brand = tokens[0];
                String model = tokens[1];
                int horsepower = Integer.parseInt(tokens[2]);

                car = new Car(brand, model, horsepower);
            } else {
                String brand = tokens[0];
                car = new Car(brand);
            }

            cars.add(car);
        }

        scanner.close();
        return cars;
    }

    private static StringBuilder formOutput(Set<Car> cars) {
        StringBuilder sb = new StringBuilder();

        for (Car car : cars) {
            sb.append(car.carInfo());
            sb.append(System.lineSeparator());
        }
        
        return sb;
    }

}
