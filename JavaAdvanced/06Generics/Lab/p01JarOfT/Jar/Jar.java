package p01JarOfT.Jar;

import java.util.ArrayDeque;
import java.util.Deque;

public class Jar<T> {

    private Deque<T> stack;

    public Jar() {
        stack = new ArrayDeque<>();
    }

    public void add(T el) {
        this.stack.push(el);
    }

    public T remove() {
        return this.stack.pop();
    }

}
