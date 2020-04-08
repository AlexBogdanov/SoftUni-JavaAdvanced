package p03BuilderDesignPattern.domain.components;

public class Gps {

    private String route;

    public Gps(String route) {
        this.route = route;
    }

    public void changeRoute(String newRoute) {
        this.route = newRoute;
    }

    public String getRoute() {
        return this.route;
    }

    @Override
    public String toString() {
        return "GPS with route" + this.getRoute();
    }

}
