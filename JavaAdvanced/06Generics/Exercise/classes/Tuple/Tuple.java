package classes.Tuple;

public class Tuple<T, E> {

    public T obj1;
    public E obj2;

    public Tuple(T obj1, E obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    @Override
    public String toString() {
        return this.obj1 + " -> " + this.obj2;
    }

}
