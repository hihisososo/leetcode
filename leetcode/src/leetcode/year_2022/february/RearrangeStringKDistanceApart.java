package leetcode.year_2022.february;

import java.util.*;

public class RearrangeStringKDistanceApart {
    public static void main(String[] args) {
//        String s = "aabbcc";int k = 3;
        String s = "aaadbbcc";int k = 2;
//        String s = "aaabc";int k = 3;
        System.out.println(new RearrangeStringKDistanceApart().rearrangeString(s, k));
    }

    public String rearrangeString(String s, int k) {
        HashMap<Character, Integer> cntMap = new HashMap<>();
        for (Character c : s.toCharArray()) {
            cntMap.putIfAbsent(c, 0);
            cntMap.put(c, cntMap.get(c) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> cntQueue = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        PriorityQueue<Map.Entry<Character, Integer>> waitQueue = new PriorityQueue<>();

        for (Map.Entry<Character, Integer> e : cntMap.entrySet()) {
            cntQueue.add(e);
        }

        StringBuffer result = new StringBuffer();
        while (!cntQueue.isEmpty()) {
            Map.Entry<Character, Integer> poll = cntQueue.poll();
            result.append(poll.getKey());
            poll.setValue(poll.getValue() - 1);
            if (poll.getValue() == 0) {
                cntQueue.remove(poll);
            } else {
                waitQueue.add(new AbstractMap.SimpleEntry<>(poll.getKey(), result.length() - 1));
            }

            Iterator<Map.Entry<Character, Integer>> iter = waitQueue.iterator();
            while (iter.hasNext()) {
                Map.Entry<Character, Integer> wq = iter.next();
                if (result.length() - wq.getValue() == k) {
                    cntQueue.offer(wq);
                    waitQueue.remove(wq);
                }
            }
        }

        if (!waitQueue.isEmpty()) {
            return "";
        } else {
            return result.toString();
        }

    }
}
