package p02Shapes.domain;

public class Rectangle extends Shape {

    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        this.setHeight(height);
        this.setWidth(width);
    }

    @Override
    public Double calculatePerimeter() {
        return 2 * (this.getHeight() + this.getWidth());
    }

    @Override
    public Double calculateArea() {
        return this.getHeight() * this.getWidth();
    }

    public final Double getHeight() {
        return this.height;
    }

    public final void setHeight(Double height) {
        this.height = height;
    }

    public final Double getWidth() {
        return this.width;
    }

    public final void setWidth(Double width) {
        this.width = width;
    }

}
