package classes.Count;

import java.util.List;
import java.util.stream.Collectors;

public class Count {

    public static <T extends Comparable<T>>int counter(List<T> box, T el) {
        List<T> greaterVals = box.stream()
            .filter(currEl -> {
                if (currEl.compareTo(el) == 0) {
                    return false;
                }

                if (currEl.compareTo(el) > 0) {
                    return true;
                }

                return false;
            }).collect(Collectors.toList());

        return greaterVals.size();
    }

}
