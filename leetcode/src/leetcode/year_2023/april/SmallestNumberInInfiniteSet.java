package leetcode.year_2023.april;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class SmallestNumberInInfiniteSet {

    public static void main(String[] args) {
        SmallestNumberInInfiniteSet SmallestNumberInInfiniteSet = new SmallestNumberInInfiniteSet();
        SmallestNumberInInfiniteSet.addBack(2);    // 2 is already in the set, so no change is made.
        System.out.println(SmallestNumberInInfiniteSet
                .popSmallest()); // return 1, since 1 is the smallest number, and remove it from the set.
        System.out.println(
                SmallestNumberInInfiniteSet.popSmallest()); // return 2, and remove it from the set.
        System.out.println(
                SmallestNumberInInfiniteSet.popSmallest()); // return 3, and remove it from the set.
        SmallestNumberInInfiniteSet.addBack(1);    // 1 is added back to the set.
        System.out.println(SmallestNumberInInfiniteSet
                .popSmallest()); // return 1, since 1 was added back to the set and
        // is the smallest number, and remove it from the set.
        System.out.println(
                SmallestNumberInInfiniteSet.popSmallest()); // return 4, and remove it from the set.
        System.out.println(
                SmallestNumberInInfiniteSet.popSmallest()); // return 5, and remove it from the set.
    }

    private Set<Integer> numberSet;
    private PriorityQueue<Integer> numberQueue;

    public SmallestNumberInInfiniteSet() {
        this.numberSet = new HashSet<>();
        this.numberQueue = new PriorityQueue<>();
        for (int i = 1; i <= 1000; i++) {
            this.numberSet.add(i);
            this.numberQueue.add(i);
        }
    }

    public int popSmallest() {
        Integer poll = this.numberQueue.poll();
        this.numberSet.remove(poll);
        return poll;
    }

    public void addBack(int num) {
        if (numberSet.contains(num)) {
            return;
        }
        this.numberSet.add(num);
        this.numberQueue.add(num);
    }
}
