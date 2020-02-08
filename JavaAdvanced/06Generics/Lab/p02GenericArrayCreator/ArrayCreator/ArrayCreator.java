package p02GenericArrayCreator.ArrayCreator;

import java.lang.reflect.Array;

public class ArrayCreator {

    public static <T> T[] create(int length, T item) {
        T[] res = (T[]) new Object[length];

        for (int i = 0; i < length; i++) {
            res[i] = item;
        }

        return res;
    }

    public static <T> T[] create(Class<T> clazz, int length, T item) {
        T[] res = (T[]) Array.newInstance(clazz, length);

        for (int i = 0; i < length; i++) {
            res[i] = item;
        }

        return res;
    }

}
