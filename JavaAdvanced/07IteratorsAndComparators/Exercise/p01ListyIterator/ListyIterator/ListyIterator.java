package p01ListyIterator.ListyIterator;

import java.util.ArrayList;
import java.util.List;

public class ListyIterator {

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
        if (this.pointer < this.list.size()) {
            this.pointer++;
            return true;
        }

        return false;
    }

    public boolean hasNext() {
        if (this.pointer < this.list.size() - 1) {
            return true;
        }

        return false;
    }

    public void print() throws Exception {
        if (this.list.size() == 0) {
            throw new Exception("Invalid Operation!");
        }

        System.out.println(this.list.get(this.pointer));
    }

}
