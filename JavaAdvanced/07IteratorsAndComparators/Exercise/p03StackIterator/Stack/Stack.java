package p03StackIterator.Stack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Stack<T> implements Iterable<T> {

    private List<T> stack;

    public Stack() {
        this.stack = new ArrayList<>();
    }

    @SafeVarargs
    public final void push(T... elements) {
        for (T el : elements) {
            this.stack.add(el);
        }
    }

    public void pop() {
        int index = this.stack.size() - 1;

        if (index == -1) {
            System.out.println("No elements");
            return;
        }

        this.stack.remove(index);
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private final class StackIterator implements Iterator<T> {

        @Override
        public boolean hasNext() {
            return stack.size() - 1 > -1;
        }

        @Override
        public T next() {
            T el = stack.get(stack.size() - 1);
            pop();
            return el;
        }

    }

}
