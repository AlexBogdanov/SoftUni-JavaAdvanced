package p01FactoryDesignPattern.domain.classes;

public class LandTransport implements Transport {

    private String transportType;

    public LandTransport(String transportType) {
        this.transportType = transportType;
    }

    @Override
    public void transport(String cargo) {
        System.out.println(String.format(
            "%s is transporting %s by land", 
            this.transportType,
            cargo
        ));
    }

}
