package p03BuilderDesignPattern;

import p03BuilderDesignPattern.domain.builders.CarBuilder;
import p03BuilderDesignPattern.domain.builders.ManualCarBuilder;
import p03BuilderDesignPattern.domain.cars.Car;
import p03BuilderDesignPattern.domain.cars.ManualCar;
import p03BuilderDesignPattern.domain.director.Director;

public class Main {

    public static void main(String[] args) {

        Director director = new Director();

        CarBuilder carBuilder = new CarBuilder();
        director.constructCityCar(carBuilder);
        Car cityCar = carBuilder.build();

        director.constructSUV(carBuilder);
        Car suv = carBuilder.build();

        ManualCarBuilder manualCarBuilder = new ManualCarBuilder();
        director.constructSportsCar(manualCarBuilder);
        ManualCar sportsCar = manualCarBuilder.build();
        sportsCar.getEngine().on();
        sportsCar.getEngine().go(10000);

        cityCar.changeGear();
        suv.changeGear();
        sportsCar.changeGear();

        System.out.println(cityCar);
        System.out.println(suv);
        System.out.println(sportsCar);

    }

}
