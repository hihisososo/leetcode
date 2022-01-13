package leetcode.year_2022.january;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZigzagIterator {
    public static void main(String[] args) {
        List<Integer> v1 = new ArrayList<>(Arrays.asList(new Integer[]{}));
        List<Integer> v2 = new ArrayList<>(Arrays.asList(new Integer[]{1}));
        ZigzagIterator iter = new ZigzagIterator(v1, v2);
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    List<Integer> v1;
    List<Integer> v2;
    int v1Idx = 0;
    int v2Idx = 0;
    boolean isV1 = true;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    public int next() {
        if (isV1) {
            isV1 = !isV1;
            if (v1Idx < v1.size()) {
                return v1.get(v1Idx++);
            } else {
                return v2.get(v2Idx++);
            }
        } else {
            isV1 = !isV1;
            if (v2Idx < v2.size()) {
                return v2.get(v2Idx++);
            } else {
                return v1.get(v1Idx++);
            }
        }

    }

    public boolean hasNext() {
        return v1Idx < v1.size() || v2Idx < v2.size();
    }
}
