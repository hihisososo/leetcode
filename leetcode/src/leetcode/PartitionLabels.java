package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PartitionLabels {
    public static void main(String[] args) {
        String s = "qiejxqfnqceocmy";
        System.out.println(new PartitionLabels().partitionLabels(s));
    }

    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        ArrayList<Integer> resultList = new ArrayList<>();
        for (int start = 0; start < s.length(); start++) {
            int endIdx = map.get(s.charAt(start));
            int last = 0;
            int subStart = start;
            int subLast = endIdx;
            while (true) {
                int temp = last;
                for (int i = subStart; i <= subLast; i++) {
                    last = Math.max(last, map.get(s.charAt(i)));
                }
                if (temp < last) {
                    subStart = subLast;
                    subLast = last;
                } else {
                    break;
                }
            }
            resultList.add(last - start + 1);
            start = last;
        }
        return resultList;
    }
}
