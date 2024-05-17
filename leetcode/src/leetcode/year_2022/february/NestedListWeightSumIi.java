package leetcode.year_2022.february;

import common.NestInteger;
import common.NestedInteger;
import common.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NestedListWeightSumIi {
    public static void main(String[] args) {
        List<NestedInteger> nestedIntegerList = new ArrayList<>();
        NestInteger n1 = new NestInteger();
        n1.add(new NestInteger(1));
        n1.add(new NestInteger(1));
        NestInteger n2 = new NestInteger();
        n2.add(new NestInteger(1));
        n2.add(new NestInteger(1));
        nestedIntegerList.add(n1);
        nestedIntegerList.add(new NestInteger(2));
        nestedIntegerList.add(n2);
        System.out.println(new NestedListWeightSumIi().depthSumInverse(nestedIntegerList));
    }

    public int depthSumInverse(List<NestedInteger> nestedList) {
        List<Pair<Integer, Integer>> depthList = new ArrayList<>();
        Queue<Pair<NestedInteger, Integer>> queue = new LinkedList<>();
        for (NestedInteger ne : nestedList) {
            queue.add(new Pair<>(ne, 1));
        }
        int maxDepth = 0;
        while (!queue.isEmpty()) {
            Pair<NestedInteger, Integer> pair = queue.poll();
            NestedInteger ne = pair.getKey();
            Integer depth = pair.getValue();
            maxDepth = Math.max(maxDepth, depth + 1);
            if (pair.getKey().isInteger()) {
                depthList.add(new Pair<>(ne.getInteger(), depth));
            } else {
                for (NestedInteger l : ne.getList()) {
                    queue.add(new Pair<>(l, depth + 1));
                }
            }
        }

        int sum = 0;
        for (Pair<Integer, Integer> d : depthList) {
            sum += (maxDepth - d.getValue()) * d.getKey();
        }
        return sum;
    }
}
