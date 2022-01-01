package leetcode.year_2021;

import java.util.*;

public class ShuffleAnArray {
    public static void main(String[] args) {
        ShuffleAnArray shuffleAnArray = new ShuffleAnArray(new int[]{1,2,3});
        System.out.println(Arrays.toString(shuffleAnArray.shuffle()));
        System.out.println(Arrays.toString(shuffleAnArray.reset()));
        System.out.println(Arrays.toString(shuffleAnArray.shuffle()));
    }

    int[] original;
    int[] current;
    Random random;

    public ShuffleAnArray(int[] nums) {
        original = Arrays.copyOf(nums, nums.length);
        current = Arrays.copyOf(nums, nums.length);
        random = new Random();
    }

    public int[] reset() {
        current = Arrays.copyOf(original, original.length);
        return current;
    }

    public int[] shuffle() {
        ArrayList<Integer> idxList = new ArrayList<>();
        int[] newArr = new int[current.length];
        for (int i = 0; i < current.length; i++) {
            idxList.add(i);
        }
        for (int i = 0; i < current.length; i++) {
            Integer idx = idxList.get(random.nextInt(idxList.size()));
            newArr[i] = current[idx];
            idxList.remove(idx);
        }
        current = newArr;
        return current;
    }
}
