package classes.Threeuple;

import classes.Tuple.Tuple;

public class Threeuple<T, E, V> extends Tuple<T, E> {

    private V obj3;

    public Threeuple(T obj1, E obj2, V obj3) {
        super(obj1, obj2);

        this.obj3 = obj3;
    }

    public T getObj1() {
        return this.obj1;
    }

    public void setObj1(T obj) {
        this.obj1 = obj;
    }

    public E getObj2() {
        return this.obj2;
    }

    public void setObj2(E obj) {
        this.obj2 = obj;
    }

    public V getObj3() {
        return this.obj3;
    }

    public void setObj3(V obj) {
        this.obj3 = obj;
    }

    @Override
    public String toString() {
        return this.obj1 + " -> " + this.obj2 + " -> " + this.obj3;
    }

}
