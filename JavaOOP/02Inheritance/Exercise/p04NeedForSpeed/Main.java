package p04NeedForSpeed;

import p04NeedForSpeed.vehicle.Vehicle;
import p04NeedForSpeed.vehicle.car.Car;
import p04NeedForSpeed.vehicle.car.FamilyCar;
import p04NeedForSpeed.vehicle.car.SportCar;
import p04NeedForSpeed.vehicle.motorcycle.CrossMotorcycle;
import p04NeedForSpeed.vehicle.motorcycle.Motorcycle;
import p04NeedForSpeed.vehicle.motorcycle.RaceMotorcycle;

public class Main {

    public static void main(String[] args) {
        
        Vehicle vehicle = new Vehicle(1, 1);

        Car car = new Car(2, 2);
        FamilyCar familyCar = new FamilyCar(3, 3);
        SportCar sportCar = new SportCar(3, 3);

        Motorcycle motorcycle = new Motorcycle(2, 2);
        CrossMotorcycle crossMotorcycle = new CrossMotorcycle(3, 3);
        RaceMotorcycle raceMotorcycle = new RaceMotorcycle(3, 3);

        System.out.println(vehicle.getFuelConsumption());
        System.out.println(vehicle.getHorsePower());

        System.out.println(car.getFuelConsumption());
        System.out.println(car.getHorsePower());
        System.out.println(familyCar.getFuelConsumption());
        System.out.println(familyCar.getHorsePower());
        System.out.println(sportCar.getFuelConsumption());
        System.out.println(sportCar.getHorsePower());

        System.out.println(motorcycle.getFuelConsumption());
        System.out.println(motorcycle.getHorsePower());
        System.out.println(crossMotorcycle.getFuelConsumption());
        System.out.println(crossMotorcycle.getHorsePower());
        System.out.println(raceMotorcycle.getFuelConsumption());
        System.out.println(raceMotorcycle.getHorsePower());

    }

}