package p06Animals;

import java.util.Scanner;

// import p06Animals.animals.Animal;
import p06Animals.io.InputReader;
import p06Animals.io.OutputWritter;

public class Main {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        OutputWritter outputWritter = new OutputWritter(System.out);

        while (true) {
            try {
                InputReader inputReader = new InputReader(scanner);
                outputWritter.print(inputReader.getInfo());
            } catch (Exception e) {
                if (e.getMessage().equals("No more animals")) {
                    break;
                }
    
                outputWritter.print(e.getMessage());
            }
        }

        scanner.close();

    }

}