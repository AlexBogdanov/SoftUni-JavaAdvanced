package classes.CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import classes.Count.Count;
import classes.Swapper.Swapper;

public class CustomList<T extends Comparable<T>> implements Iterable<T> {

    private List<T> list;

    public CustomList() {
        this.list = new ArrayList<>();
    }
    
    public boolean add(T el) {
        if (this.list.contains(el)) {
            return false;
        }

        this.list.add(el);
        return true;
    }

    public T remove(int i) {
        return this.list.remove(i);
    }

    public boolean contains(T el) {
        return this.list.contains(el);
    }

    public void swap(int i1, int i2) {
        Swapper<T> swapper = new Swapper<>(this.list);
        this.list = swapper.swap(i1, i2);
    }

    public int countGreaterThan(T el) {
        return Count.counter(this.list, el);
    }

    public T getMax() {
        return this.list.stream()
            .max((el1, el2) -> el1.compareTo(el2))
            .orElseThrow(NoSuchElementException::new);
    }

    public T getMin() {
        return this.list.stream()
            .min((el1, el2) -> el1.compareTo(el2))
            .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        this.list.forEach(el -> {
            sb.append(el).append(System.lineSeparator());
        });

        return sb.toString();
    }
    
    public void sort() {
        Collections.sort(this.list);
    }

    @Override
    public Iterator<T> iterator() {
        return this.list.iterator();
    }

}
