package leetcode;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LargestNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{0,0};
        System.out.println(new LargestNumber().largestNumber(nums));
    }

    public String largestNumber(int[] nums) {
        String maxPrefix = "";
        Queue<Pair<String, boolean[]>> queue = new LinkedList<>();
        queue.add(new Pair<>("", new boolean[nums.length]));

        while (!queue.isEmpty()) {
            Pair<String, boolean[]> poll = queue.poll();
            if (isPrefixMatch(poll.getKey(), maxPrefix)) {
                if (poll.getKey().length() > maxPrefix.length()) {
                    maxPrefix = poll.getKey();
                }
                addQueue(nums, queue, poll);
            } else if (isLarge(poll.getKey(), maxPrefix)) {
                maxPrefix = poll.getKey();
                addQueue(nums, queue, poll);
            } else {
                continue;
            }
        }
        return maxPrefix.replaceAll("^0+", "0");
    }

    private void addQueue(int[] nums, Queue<Pair<String, boolean[]>> queue, Pair<String, boolean[]> poll) {
        for (int i = 0; i < poll.getValue().length; i++) {
            if (!poll.getValue()[i]) {
                boolean[] copy = Arrays.copyOf(poll.getValue(), poll.getValue().length);
                copy[i] = true;
                queue.add(new Pair<>(poll.getKey() + nums[i], copy));
            }
        }
    }

    private boolean isLarge(String prefix, String maxPrefix) {
        int length = Math.min(prefix.length(), maxPrefix.length());
        for (int i = 0; i < length; i++) {
            if (prefix.charAt(i) > maxPrefix.charAt(i)) {
                return true;
            }else if(prefix.charAt(i) < maxPrefix.charAt(i)){
                return false;
            }
        }
        return false;
    }

    private boolean isPrefixMatch(String prefix, String maxPrefix) {
        int length = Math.min(prefix.length(), maxPrefix.length());
        for (int i = 0; i < length; i++) {
            if (prefix.charAt(i) != maxPrefix.charAt(i)) {
                return false;
            }
        }
        return true;
    }


}
