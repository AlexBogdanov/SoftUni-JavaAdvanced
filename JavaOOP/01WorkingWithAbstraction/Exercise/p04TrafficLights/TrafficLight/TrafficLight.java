package p04TrafficLights.TrafficLight;

enum Signal {
    RED,
    YELLOW,
    GREEN
}

public class TrafficLight {

    private Signal state;

    public TrafficLight(String state) {
        this.state = Signal.valueOf(state);
    }

    public void changeState() {
        switch (this.state) {
            case RED:
                this.state = Signal.GREEN;
                break;
            case YELLOW:
                this.state = Signal.RED;
                break;
            default:
                this.state = Signal.YELLOW;
        }
    }

    @Override
    public String toString() {
        return this.state.toString();
    }

}
