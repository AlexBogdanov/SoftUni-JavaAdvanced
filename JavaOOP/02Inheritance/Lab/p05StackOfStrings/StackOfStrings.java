package p05StackOfStrings;

import java.util.ArrayList;
import java.util.List;

public class StackOfStrings {

    private List<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<String>();
    }
    
    public void push(String el) {
        this.data.add(el);
    }

    public String pop() {
        return this.data.remove(this.data.size() - 1);
    }

    public String peek() {
        String el = this.data.remove(this.data.size() - 1);
        this.data.add(el);
        return el;
    }

    public boolean isEmpty() {
        return this.data.isEmpty();
    }

}
