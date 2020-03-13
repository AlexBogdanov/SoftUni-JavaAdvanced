package p04RandomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList<T> extends ArrayList<T> {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public T getRandomElement() {
        Random random = new Random();
        int rnd = random.nextInt(this.size());
        return this.get(rnd);
    }

}
