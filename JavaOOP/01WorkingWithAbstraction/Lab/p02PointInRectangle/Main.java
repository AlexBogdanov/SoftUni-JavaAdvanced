package p02PointInRectangle;

import java.util.Scanner;

import p02PointInRectangle.Point.Point;
import p02PointInRectangle.Rectangle.Rectangle;

public class Main {

    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);
        Point p1 = createPoint(scanner);
        Point p2 = createPoint(scanner);
        scanner.nextLine();

        Rectangle reactangle = new Rectangle(p1, p2);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            Point p = createPoint(scanner);
            scanner.nextLine();
            System.out.println(reactangle.contains(p));
        }

        scanner.close();

    }

    private static Point createPoint(Scanner scanner) {
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        return new Point(x, y);
    }

}
