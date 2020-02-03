package p05CarSalesMan.classes;

public class Car {

    public String model;
    public Engine engine;
    public int weight;
    public String color;

    public Car(String model, Engine engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public Car(String model, Engine engine, int weight) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = "n/a";
    }

    public Car(String model, Engine engine, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = -1;
        this.color = color;
    }

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.weight = -1;
        this.color = "n/a";
    }

    public void printCar() {
        StringBuilder sb = new StringBuilder();

        sb.append(this.model + ":");
        sb.append(System.lineSeparator());
        sb.append(this.engine.model + ":");
        sb.append(System.lineSeparator());
        sb.append(String.format("Power: %d%n", this.engine.power));
        sb.append(String.format(
            "Displacement: %s%n", 
            this.engine.displacement > -1 ? this.engine.displacement : "n/a"
        ));
        sb.append(String.format("Efficiency: %s%n", this.engine.efficiency));
        sb.append(String.format(
            "Weight: %s%n",
            this.weight > -1 ? this.weight : "n/a"
        ));
        sb.append("Color: " + this.color);
        
        System.out.println(sb);
    }

}
