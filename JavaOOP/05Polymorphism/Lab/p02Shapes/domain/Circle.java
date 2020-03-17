package p02Shapes.domain;

public class Circle extends Shape {

    private Double radius;

    public Circle(Double radius) {
        this.setRadius(radius);
    }

    @Override
    public Double calculatePerimeter() {
        return 2 * Math.PI * this.getRadius();
    }

    @Override
    public Double calculateArea() {
        return Math.PI * this.radius * this.getRadius();
    }

    public final Double getRadius() {
        return this.radius;
    }

    public final void setRadius(Double radius) {
        this.radius = radius;
    }

}
