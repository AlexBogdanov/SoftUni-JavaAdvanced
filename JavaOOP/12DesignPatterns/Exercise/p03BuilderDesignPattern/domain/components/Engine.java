package p03BuilderDesignPattern.domain.components;

public class Engine {

    private final double volume;
    private double kilometers;
    private boolean started;

    public Engine(double volume, double kilometers) {
        this.volume = volume;
        this.kilometers = kilometers;
        this.started = false;
    }

    public void on() {
        this.started = true;
    }

    public void off() {
        this.started = false;
    }

    public void go(double kilometers) {
        this.kilometers += kilometers;
    }

    public double getVolume() {
        return this.volume;
    }

    public double getKilometers() {
        return this.kilometers;
    }

    public boolean hasStarted() {
        return this.started;
    }

    @Override
    public String toString() {
        return String.format(
            "Engine with volume %.1f and travelled %.1f is %s",
            this.getVolume(),
            this.getKilometers(),
            this.started ? "ON" : "OFF"
        );
    }

}
