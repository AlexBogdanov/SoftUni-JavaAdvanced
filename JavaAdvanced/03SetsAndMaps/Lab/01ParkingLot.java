import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

class ParkingLot {

    public static void main (String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Set<String> parkingLot = readInput(scanner);
        StringBuilder sb = new StringBuilder();
        createOutput(parkingLot, sb);

        if (parkingLot.size() > 0) {
            System.out.println(sb);
        } else {
            System.out.println("Parking Lot is Empty");
        }

    }

    private static Set<String> readInput (Scanner scanner) {
        Set<String> parkingLot = new LinkedHashSet<>();
        String input = scanner.nextLine();
        
        while (!"END".equals(input)) {
            String[] tokens = input.split(", +");
            String command = tokens[0];
            String carNum = tokens[1];

            switch (command) {
                case "IN":
                    parkingLot.add(carNum);
                    break;
                case "OUT":
                    parkingLot.remove(carNum);
                    break;
            }

            input = scanner.nextLine();
        }

        return parkingLot;
    }

    private static void createOutput (Set<String> parkingLot, StringBuilder sb) {
        for (String carNum : parkingLot) {
            sb.append(carNum);
            sb.append(System.lineSeparator());
        }
    }

}
