package leetcode.year_2022.february;

import common.NestInteger;
import common.NestedInteger;

import java.util.ArrayList;
import java.util.List;

public class NestedListWeightSum {
    public static void main(String[] args) {
        List<NestedInteger> nestedList = new ArrayList<>();
        NestInteger list1 = new NestInteger();
        list1.add(new NestInteger(1));
        list1.add(new NestInteger(1));
        NestInteger list2 = new NestInteger();
        list2.add(new NestInteger(1));
        list2.add(new NestInteger(1));
        nestedList.add(list1);
        nestedList.add(new NestInteger(2));
        nestedList.add(list2);
        System.out.println(new NestedListWeightSum().depthSum(nestedList));
    }


    public int depthSum(List<NestedInteger> nestedList) {
        int sum = 0;
        for (int i = 0; i < nestedList.size(); i++) {
            sum += getSum(nestedList.get(i), 1);
        }
        return sum;
    }

    private int getSum(NestedInteger nestedInteger, int depth) {
        if (nestedInteger.isInteger()) {
            return nestedInteger.getInteger() * depth;
        } else {
            int sum = 0;
            for (NestedInteger n : nestedInteger.getList()) {
                sum += getSum(n, depth + 1);
            }
            return sum;
        }
    }
}
