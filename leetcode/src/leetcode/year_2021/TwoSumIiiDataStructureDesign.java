package leetcode.year_2021;

import java.util.HashMap;

public class TwoSumIiiDataStructureDesign {
    HashMap<Integer, Boolean> map;

    public TwoSumIiiDataStructureDesign() {
        map = new HashMap<Integer, Boolean>();
    }

    public void add(int number) {
        if (map.containsKey(number)) {
            map.put(number, true);
        } else {
            map.put(number, false);
        }

    }

    public boolean find(int value) {
        for (Integer i : map.keySet()) {
            if (map.get(value - i) != null) {
                if (i == value - i) {
                    if (map.get(value - i)) {
                        return true;
                    }
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}
