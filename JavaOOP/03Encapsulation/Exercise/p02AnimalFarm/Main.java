package p02AnimalFarm;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int age = scanner.nextInt();
        scanner.close();

        try {
            Chicken chicken = new Chicken(name, age);
            System.out.println(chicken);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }

    }

}
