package p04TrafficLights;

import java.util.Scanner;

import p04TrafficLights.TrafficLight.TrafficLight;

public class Main {

    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);
        TrafficLight[] trafficLights = createTrafficLights(scanner);
        int n = scanner.nextInt();
        scanner.close();
        
        String output = createOutput(trafficLights, n);
        System.out.println(output);

    }

    private static String createOutput(TrafficLight[] trafficLights, int n) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (TrafficLight trafficLight : trafficLights) {
                trafficLight.changeState();
                sb.append(trafficLight.toString() + " ");
            }

            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    private static TrafficLight[] createTrafficLights(Scanner scanner) {
        String[] tokens = scanner.nextLine().split("\\s+");
        var trafficLights = new TrafficLight[tokens.length];
        
        for (int i = 0; i < trafficLights.length; i++) {
            trafficLights[i] = new TrafficLight(tokens[i]);
        }

        return trafficLights;
    }

}
