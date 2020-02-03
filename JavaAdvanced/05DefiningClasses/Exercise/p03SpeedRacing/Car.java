package p03SpeedRacing;

public class Car {

    private String model;
    private double fuelAmount;
    private double fuelCostPerKm;
    private double distanceTraveled = 0;

    public Car(String model, double fuelAmount, double fuelCostPerKm) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostPerKm = fuelCostPerKm;
    }

    public void drive(double distance) {
        double fuelNeeded = distance * this.fuelCostPerKm;

        if (fuelNeeded <= this.fuelAmount) {
            this.fuelAmount -= fuelNeeded;
            this.distanceTraveled += distance;
        } else {
            System.out.println("Insufficient fuel for the drive");
        }
    }

    public void printInfo() {
        System.out.println(String.format(
            "%s %.2f %.0f"
            , this.model, this.fuelAmount, this.distanceTraveled
        ));
    }

}
