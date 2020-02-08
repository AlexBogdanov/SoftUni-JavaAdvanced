package p02GenericArrayCreator;

import p02GenericArrayCreator.ArrayCreator.ArrayCreator;

public class Main {

    public static void main(String[] args) {
        
        String[] strings = ArrayCreator.create(10, "some");
        Integer[] integers = ArrayCreator.create(Integer.class, 10, 10);

    }

}
