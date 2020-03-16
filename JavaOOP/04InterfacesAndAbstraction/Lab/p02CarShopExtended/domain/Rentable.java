package p02CarShopExtended.domain;

public interface Rentable extends Car {

    Integer getMinRentDay();
    Double getPricePerDay();

}
