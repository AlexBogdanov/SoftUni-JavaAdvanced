package p02VehiclesExtension.vehicles;

import java.text.DecimalFormat;

public class Bus extends Vehicle {
        
    private static final DecimalFormat DF = new DecimalFormat("#.##");
    
    private double fuelConsumption;

    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + 1.4, tankCapacity);
        this.fuelConsumption = fuelConsumption;
    }

    public void driveWithoutPeople(double kilometers) {
        double neededFuel = kilometers * this.fuelConsumption;

        if (neededFuel > this.fuelQuantity) {
            System.out.println("Bus needs refueling");
            return;
        }

        this.fuelQuantity -= neededFuel;
        System.out.println(String.format("Bus travelled %s km", DF.format(kilometers)));
    }

}
