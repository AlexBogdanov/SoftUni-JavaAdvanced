package p04Froggy.LakeComparator;

import java.util.Comparator;

public class LakeComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer num1, Integer num2) {
        if (num1 % 2 != 0 && num2 % 2 == 0) { return -1; }

        if (num1 % 2 == 0 && num2 % 2 != 0) { return 1; }

        if (num1 % 2 != 0 && num2 % 2 != 0) {
            if (num1 > num2) { return 1; }

            if (num1 < num2) { return -1; }
        }

        if (num1 % 2 == 0 && num2 % 2 == 0) {
            if (num1 == 0) { return 1; }
    
            if (num2 == 0) { return -1; }

            if (num1 > num2) { return 1; }

            if (num1 < num2) { return -1; }
        }

        return 0;
    }

}
