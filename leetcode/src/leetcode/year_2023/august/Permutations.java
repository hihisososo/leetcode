package leetcode.year_2023.august;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        System.out.println(new Permutations().permute(new int[]{1, 2, 3}));
        System.out.println(new Permutations().permute(new int[]{0, 1}));
        System.out.println(new Permutations().permute(new int[]{1}));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permutation(nums, new ArrayList<>(), new boolean[nums.length], result);
        return result;
    }

    private void permutation(int[] nums, ArrayList<Integer> curr, boolean[] visit,
                             List<List<Integer>> result) {
        if (curr.size() == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                curr.add(nums[i]);
                permutation(nums, curr, visit, result);
                curr.remove(curr.size() - 1);
                visit[i] = false;
            }
        }
    }
}
