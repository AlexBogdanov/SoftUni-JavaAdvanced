package classes.Swapper;

import java.util.List;

public class Swapper<T> {

    private List<T> list;

    public Swapper(List<T> list) {
        this.list = list;
    }

    public List<T> swap(int i1, int i2) {
        if (i1 < this.list.size() - 1 || i2 < this.list.size() - 1) {
            return this.list;
        }

        T el2 = this.list.remove(i2);
        T el1 = this.list.remove(i1);

        this.list.add(i1, el2);
        this.list.add(i2, el1);

        return this.list;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (T el : this.list) {
            sb.append(el.getClass().getCanonicalName() + ": " + el);
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

}
