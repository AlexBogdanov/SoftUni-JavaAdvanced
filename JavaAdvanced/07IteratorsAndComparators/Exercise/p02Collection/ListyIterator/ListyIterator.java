package p02Collection.ListyIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String> {

    private List<String> list;
    private int pointer;

    public ListyIterator(String... elements) {
        this.list = new ArrayList<>();

        for (String el : elements) {
            if (el.equals("Create")) {
                continue;
            }

            this.list.add(el);
        }

        this.pointer = 0;
    }

    public boolean move() {
        if (this.pointer < this.list.size() - 1) {
            this.pointer++;
            return true;
        }

        return false;
    }

    public boolean hasNext() {
        return this.pointer < this.list.size() - 1;
    }

    public void print() throws Exception {
        if (this.list.size() == 0) {
            throw new Exception("Invalid Operation!");
        }

        System.out.println(this.list.get(this.pointer));
    }

    public void printAll() throws Exception {
        if (this.list.size() == 0) {
            throw new Exception("Invalid Operation!");
        }

        StringBuilder sb = new StringBuilder();

        for (String str : list) {
            sb.append(str + " ");
        }

        System.out.println(sb);
    }

    @Override
    public Iterator<String> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<String> {

        @Override
        public boolean hasNext() {
            return pointer < list.size() - 1;
        }

        @Override
        public String next() {
            return list.get(pointer);
        }

    }

}
