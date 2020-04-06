package p02Facade;

public class CarInfoBuilder extends CarBuilderFacade {

    public CarInfoBuilder(Car car) {
        this.car = car;
    }

    public CarInfoBuilder withType(String type) {
        this.car.setType(type);
        return this;
    }

    public CarInfoBuilder withColor(String color) {
        this.car.setColor(color);
        return this;
    }

    public CarInfoBuilder withNumberOfDoors(int numberOfDoors) {
        this.car.setNumberOfDoors(numberOfDoors);
        return this;
    }

}
