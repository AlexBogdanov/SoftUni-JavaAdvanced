package p01Person;

import java.util.Scanner;

import p01Person.Person.Child;

public class Main {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int age = scanner.nextInt();
        scanner.close();

        Child child = new Child(name, age);

        System.out.println(child.getName());
        System.out.println(child.getAge());

    }

}