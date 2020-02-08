package p03GenericScale;

import p03GenericScale.Scale.Scale;

public class Main {

    public static void main(String[] args) {

        Scale<String> stringScale = new Scale<>("a", "c");
        System.out.println(stringScale.getHeavier());

        Scale<String> stringScale2 = new Scale<>("a", "a");
        System.out.println(stringScale2.getHeavier());

        Scale<Integer> integerScale = new Scale<>(2, 1);
        System.out.println(integerScale.getHeavier());

        Scale<Integer> integerScale2 = new Scale<>(1, 2);
        System.out.println(integerScale2.getHeavier());

    }

}
