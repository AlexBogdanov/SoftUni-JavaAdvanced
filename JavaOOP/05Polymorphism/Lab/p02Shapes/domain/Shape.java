package p02Shapes.domain;

public abstract class Shape {

    private Double perimeter;
    private Double area;

    public Double getPerimeter() {
        if (this.perimeter == null) {
            this.setPerimeter(this.calculatePerimeter());
        }

        return this.perimeter;
    }

    protected void setPerimeter(Double perimeter) {
        this.perimeter = perimeter;
    }

    public Double getArea() {
        return this.area;
    }

    protected void setArea(Double area) {
        if (this.area == null) {
            this.setArea(this.calculateArea());
        }

        this.area = area;
    }

    public abstract Double calculatePerimeter();
    public abstract Double calculateArea();

}
