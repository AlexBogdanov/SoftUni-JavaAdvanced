package p01ClassBox;

import p01ClassBox.domain.Box;
import p01ClassBox.io.Printer;
import p01ClassBox.utils.BoxParser;

public class Main {

    public static void main(String[] args) {
    
        try {
            Box box = BoxParser.createBox();
            Printer.print(String.format(
                "Surface Area - %.2f%nLateral Surface Area - %.2f%nVolume - %.2f",
                box.calculateSurfaceArea(),
                box.calculateLateralSurfaceArea(),
                box.calculateVolume()
            ));
        } catch (IllegalArgumentException iae) {
            Printer.print(iae.getMessage());
        }

    }

}
