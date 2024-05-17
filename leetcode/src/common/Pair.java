package common;

public class Pair<A, B> {
    private A x;
    private B y;

    public Pair(A x, B y) {
        this.x = x;
        this.y = y;
    }

    public A getKey() {
        return x;
    }

    public B getValue() {
        return y;
    }
}