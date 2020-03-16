package p06Ferrari;

import java.util.Scanner;

import p06Ferrari.domain.Car;
import p06Ferrari.domain.Ferrari;

public class Main {

    public static void main(String[] args) {

        Car ferrari = createFerrari();
        print(ferrari);

    }

    private static void print(Car ferrari) {
        System.out.println(ferrari);
    }

    private static Car createFerrari() {
        Scanner scanner = new Scanner(System.in);
        String driverName = scanner.nextLine();
        scanner.close();

        return new Ferrari(driverName);
    }

}
