package p01Vehicles.vehicles;

public class Truck extends Vehicle {

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + 1.6);
    }

    @Override
    public void refuel(double fuel) {
        super.refuel(fuel * 0.95);
    }
}
