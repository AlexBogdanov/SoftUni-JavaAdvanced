package classes.Sorter;

import classes.CustomList.CustomList;

public class Sorter {
    
    public static <T extends Comparable<T>> CustomList<T> sort(CustomList<T> list) {
        list.sort();
        return list;
    }

}
