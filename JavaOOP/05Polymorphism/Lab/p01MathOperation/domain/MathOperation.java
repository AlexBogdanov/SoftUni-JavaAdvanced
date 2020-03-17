package p01MathOperation.domain;

public class MathOperation {

    public int add(int x, int y) {
        return x + y;
    }

    public int add(int x, int y, int z) {
        return this.add(x, y) + z;
    }

    public int add(int x, int y, int z, int u) {
        return this.add(x, y, z) + u;
    }

}
