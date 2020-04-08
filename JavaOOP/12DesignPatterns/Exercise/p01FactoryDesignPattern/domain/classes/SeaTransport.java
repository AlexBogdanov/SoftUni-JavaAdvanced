package p01FactoryDesignPattern.domain.classes;

public class SeaTransport implements Transport {

    private String transportType;

    public SeaTransport(String transportType) {
        this.transportType = transportType;
    }

    @Override
    public void transport(String cargo) {
        System.out.println(String.format(
            "%s is transporting %s by sea", 
            this.transportType,
            cargo
        ));
    }

}
