package p04Froggy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import p04Froggy.Lake.Lake;

public class Main {

    public static void main(String[] args) {

        Lake lake = createLake();
        System.out.println(lake.toString());

    }

    private static Lake createLake() {
        Scanner scanner = new Scanner(System.in);
        List<Integer> intTokens = new ArrayList<>();
        Pattern p = Pattern.compile("\\d+");

        for (String input = scanner.nextLine(); !input.equals("END"); input = scanner.nextLine()) {
            Matcher m = p.matcher(input);

            while (m.find()) {
                intTokens.add(Integer.parseInt(m.group()));
            }
        }

        scanner.close();
        return new Lake(intTokens.toArray(new Integer[intTokens.size()]));
    }

}
