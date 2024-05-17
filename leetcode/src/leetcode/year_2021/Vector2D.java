package leetcode.year_2021;

import common.Pair;

import java.util.ArrayList;
import java.util.List;

public class Vector2D {
    public static void main(String[] args) {
        Vector2D vector2D = new Vector2D(new int[][]{{1, 2}, {3}, {4}});
        System.out.println(vector2D.next());    // return 1
        System.out.println(vector2D.next());    // return 2
        System.out.println(vector2D.next());    // return 3
        System.out.println(vector2D.hasNext()); // return True
        System.out.println(vector2D.hasNext()); // return True
        System.out.println(vector2D.next());    // return 4
        System.out.println(vector2D.hasNext()); // return False
    }

    int[][] vec;
    int current = -1;
    List<Pair<Integer, Integer>> indexes = new ArrayList<>();

    public Vector2D(int[][] vec) {
        this.vec = vec;
        for (int i = 0; i < vec.length; i++) {
            for (int j = 0; j < vec[i].length; j++) {
                indexes.add(new Pair<>(i, j));
            }
        }
    }

    public int next() {
        Pair<Integer, Integer> pair = indexes.get(++current);
        return vec[pair.getKey()][pair.getValue()];
    }

    public boolean hasNext() {
        if (current < indexes.size() - 1) {
            return true;
        }
        return false;
    }
}
