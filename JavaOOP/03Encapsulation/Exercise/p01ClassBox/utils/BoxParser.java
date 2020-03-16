package p01ClassBox.utils;

import p01ClassBox.domain.Box;
import p01ClassBox.io.Reader;

public class BoxParser {

    public static Box createBox() {
        double length = Reader.nextDouble();
        double width = Reader.nextDouble();
        double height = Reader.nextDouble();

        return new Box(length, width, height);
    }

}
