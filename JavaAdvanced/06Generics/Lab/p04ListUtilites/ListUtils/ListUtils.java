package p04ListUtilites.ListUtils;

import java.util.List;

public class ListUtils {

    public static <T extends Comparable> T getMin(List<T> list) {
        if (list.size() == 0) {
            throw new IllegalArgumentException();
        }

        T res = list.stream()
            .min((e1, e2) -> e1.compareTo(e2))
            .orElseThrow();

        return res;
    }

    public static <T extends Comparable> T getMax(List<T> list) {
        if (list.size() == 0) {
            throw new IllegalArgumentException();
        }

        T res = list.stream()
            .max((e1, e2) -> e1.compareTo(e2))
            .orElseThrow();

        return res;
    }

}
