import java.util.ArrayDeque;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Integer decimal = scanner.nextInt();
        ArrayDeque<Integer> binaryStack = new ArrayDeque<>();
        
        while (decimal > 0) {
            binaryStack.push(decimal % 2);
            decimal = decimal / 2;
        }
        
        String output = "";

        while(binaryStack.size() > 0) {
            output = output + binaryStack.pop();
        }

        System.out.println(output);

    }

}
