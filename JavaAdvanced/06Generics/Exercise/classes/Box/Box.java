package classes.Box;

import java.util.ArrayList;
import java.util.List;

import classes.Count.Count;

public class Box<T extends Comparable<T>> {

    private List<T> box;
    
    public Box() {
        box = new ArrayList<>();
    }

    public void add(T el) {
        this.box.add(el);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (T el : this.box) {
            sb.append(el.getClass().getCanonicalName() + ": " + el);
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    public int compare(T el) {
        int count = Count.counter(this.box, el);
        return count;
    }
    
}
