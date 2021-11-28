package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RandomizedSet {

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.insert(0));
        System.out.println(randomizedSet.insert(1));
        System.out.println(randomizedSet.remove(0));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.remove(1));
        System.out.println(randomizedSet.getRandom());
    }

    private Random random;
    private HashMap<Integer, Integer> map;
    private ArrayList<Integer> list;
    private int offSet = 0;

    public RandomizedSet() {
        random = new Random();
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        int idx = map.get(val);
        list.remove(idx + offSet);
        map.remove(val);
        offSet--;
        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
