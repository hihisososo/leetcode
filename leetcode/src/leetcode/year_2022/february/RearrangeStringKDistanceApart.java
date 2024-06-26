package leetcode.year_2022.february;

import java.util.*;

public class RearrangeStringKDistanceApart {
    public static void main(String[] args) {
//        String s = "aabbcc";int k = 3;
//        String s = "aaadbbcc";int k = 2;
//        String s = "aaabc";int k = 3;
        String s = "aa";
        int k = 0;
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
                return o2.getValue() - o1.getValue();
            }
        });
        Queue<Map.Entry<Character, Integer>> waitQueue = new LinkedList<>();
        Queue<Map.Entry<Character, Integer>> tempQueue = new LinkedList<>();

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
                waitQueue.add(poll);
            }

            while (!waitQueue.isEmpty()) {
                Map.Entry<Character, Integer> wq = waitQueue.poll();
                if (result.length() - result.lastIndexOf(String.valueOf(wq.getKey())) >= k) {
                    cntQueue.offer(wq);
                } else {
                    tempQueue.add(wq);
                }
            }
            while (!tempQueue.isEmpty()) {
                waitQueue.add(tempQueue.poll());
            }
        }

        if (!waitQueue.isEmpty()) {
            return "";
        } else {
            return result.toString();
        }

    }
}
