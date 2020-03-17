package p02Shapes;

import p02Shapes.domain.Circle;
import p02Shapes.domain.Rectangle;
import p02Shapes.domain.Shape;

public class Main {

    public static void main(String[] args) {

        Shape rectangle = new Rectangle(3.0, 5.0);
        Rectangle rectangle2 = new Rectangle(3.0, 5.0);

        Shape circle = new Circle(2.0);
        Circle circle2 = new Circle(2.0);

        System.out.println(rectangle.calculatePerimeter());
        System.out.println(rectangle2.calculatePerimeter());
        System.out.println(rectangle.calculateArea());
        System.out.println(rectangle2.calculateArea());

        System.out.println(circle.calculatePerimeter());
        System.out.println(circle2.calculatePerimeter());
        System.out.println(circle.calculateArea());
        System.out.println(circle2.calculateArea());

    }

}
