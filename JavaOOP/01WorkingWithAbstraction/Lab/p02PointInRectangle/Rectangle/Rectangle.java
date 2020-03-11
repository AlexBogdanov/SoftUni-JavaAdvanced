package p02PointInRectangle.Rectangle;

import p02PointInRectangle.Point.Point;

public class Rectangle {

    private Point bL;
    private Point tR;

    public Rectangle(Point bL, Point tR) {
        this.bL = bL;
        this.tR = tR;
    }

    public boolean contains(Point p) {
        boolean isInBotLeft = isInBotLeft(p);
        boolean isInTopRight = isInTopRight(p);

        if (isInBotLeft && isInTopRight) {
            return true;
        }

        return false;
    }

    private boolean isInTopRight(Point p) {
        if (p.getX() <= this.tR.getX() && p.getY() <= this.tR.getY()) {
            return true;
        }

        return false;
    }

    private boolean isInBotLeft(Point p) {
        if (p.getX() >= this.bL.getX() && p.getY() >= this.bL.getY()) {
            return true;
        }

        return false;
    }

}
