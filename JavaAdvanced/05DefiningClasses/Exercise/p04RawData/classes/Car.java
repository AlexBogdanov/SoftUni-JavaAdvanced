package p04RawData.classes;

public class Car {

    public String model;
    public Engine engine;
    public Cargo cargo;
    public Tire[] tires = new Tire[4];

    public Car(
        String model,
        int engineSpeed,
        int enginePower,
        int cargoWeight,
        String cargoType,
        double tire1Pressure,
        int tire1Age,
        double tire2Pressure,
        int tire2Age,
        double tire3Pressure,
        int tire3Age,
        double tire4Pressure,
        int tire4Age) {
        this.model = model;
        this.engine = createEngine(engineSpeed, enginePower);
        this.cargo = createCargo(cargoWeight, cargoType);
        this.tires[0] = createTire(tire1Pressure, tire1Age);
        this.tires[1] = createTire(tire2Pressure, tire2Age);
        this.tires[2] = createTire(tire3Pressure, tire3Age);
        this.tires[3] = createTire(tire4Pressure, tire4Age);
    }
    
    private Engine createEngine(int engineSpeed, int enginePower) {
        return new Engine(engineSpeed, enginePower);
    }

    private Cargo createCargo(int cargoWeight, String cargoType) {
        return new Cargo(cargoWeight, cargoType);
    }

    private Tire createTire(double tirePressure, int tireAge) {
        return new Tire(tirePressure, tireAge);
    }

}
