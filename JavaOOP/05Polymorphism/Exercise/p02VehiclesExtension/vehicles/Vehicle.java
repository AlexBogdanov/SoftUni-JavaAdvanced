package p02VehiclesExtension.vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {
        
    protected static final DecimalFormat DF = new DecimalFormat("#.##");

    protected double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;

    protected Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
    }

    public void drive(double kilometers) {
        double neededFuel = kilometers * this.fuelConsumption;
        if (neededFuel > this.fuelQuantity) {
            System.out.println(String.format(
                "%s needs refueling",
                this.getClass().getSimpleName()
            ));
            return;
        }
        this.fuelQuantity -= neededFuel;
        System.out.println(String.format(
            "%s travelled %s km",
            this.getClass().getSimpleName(),
            DF.format(kilometers)
        ));
    }

    public void refuel(double fuel) {
        if (fuel <= 0) {
            System.out.println("Fuel must be a positive number");
            return;
        }

        double totalFuel = this.fuelQuantity + fuel;
        
        if (totalFuel > this.tankCapacity) {
            System.out.println("Cannot fit fuel in tank");
            return;
        }

        this.fuelQuantity = totalFuel;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", getClass().getSimpleName(), this.fuelQuantity);
    }

}
