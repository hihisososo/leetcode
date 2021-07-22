package leetcode;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class MaxPointsOnALine {
    public static void main(String[] args) {
        int[][] points = new int[][]{{0,0}};
        System.out.println(new MaxPointsOnALine().maxPoints(points));
    }

    public int maxPoints(int[][] points) {
        if (points.length == 0 || points.length == 1) {
            return points.length;
        }
        //ax + b, collect a and b values
        HashMap<AB, Integer> result = new HashMap<>();
        int maxCnt = 0;
        for (int i = 0; i < points.length; i++) {
            HashSet<AB> set = new HashSet<>();
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                int numeratorA = points[j][1] - points[i][1];
                int denominatorA = points[j][0] - points[i][0];
                int gcd = gcd(numeratorA, denominatorA);
                numeratorA /= gcd;
                denominatorA /= gcd;
                Pair<Integer, Integer> a = new Pair<>(numeratorA, denominatorA);
                Pair<Integer, Integer> b = getB(a, points[i]);
                AB ab = new AB(a, b);
                set.add(ab);
            }
            for (AB ab : set) {
                if (result.get(ab) == null) {
                    result.put(ab, 1);
                    maxCnt = Math.max(maxCnt, 1);
                } else {
                    result.put(ab, result.get(ab) + 1);
                    maxCnt = Math.max(maxCnt, result.get(ab));
                }
            }
        }
        return maxCnt;
    }

    private Pair<Integer, Integer> getB(Pair<Integer, Integer> a, int[] point) {
        if (a.getValue() == 0) {
            return new Pair<>(Integer.MAX_VALUE, point[0]);
        }
        int numerator = (point[1] * a.getValue()) - (a.getKey() * point[0]);
        int denominator = a.getValue();
        int gcd = gcd(numerator, denominator);
        return new Pair<>(numerator / gcd, denominator / gcd);
    }

    class AB {
        public Pair<Integer, Integer> a;
        public Pair<Integer, Integer> b;

        public AB(Pair<Integer, Integer> a, Pair<Integer, Integer> b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return "AB{" +
                    "a=" + a +
                    ", b=" + b +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            AB ab = (AB) o;
            return Objects.equals(a, ab.a) && Objects.equals(b, ab.b);
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
