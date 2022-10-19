package leetcode.year_2022.october;

import javafx.util.Pair;

import java.util.*;

public class TopKFrequentWords {
    public static void main(String[] args) {
        System.out.println(new TopKFrequentWords().topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
        System.out.println(new TopKFrequentWords().topKFrequent(new String[]{"the","day","is","sunny","the","the","the","sunny","is","is"}, 4));
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> countMap = new HashMap();
        for (String w : words) {
            countMap.putIfAbsent(w, 0);
            countMap.put(w, countMap.get(w) + 1);
        }

        PriorityQueue<Pair<String, Integer>> wordCountQueue = new PriorityQueue<>(new Comparator<Pair<String, Integer>>() {
            @Override
            public int compare(Pair<String, Integer> o1, Pair<String, Integer> o2) {
                if (o1.getValue() == o2.getValue()) {
                    return o2.getKey().compareTo(o1.getKey());
                }
                return o1.getValue() - o2.getValue();
            }
        });
        for (Map.Entry<String, Integer> e : countMap.entrySet()) {
            wordCountQueue.add(new Pair<>(e.getKey(), e.getValue()));
            if (wordCountQueue.size() > k) {
                wordCountQueue.poll();
            }
        }
        System.out.println(wordCountQueue);

        LinkedList<String> result = new LinkedList<>();
        while (!wordCountQueue.isEmpty()) {
            result.addFirst(wordCountQueue.poll().getKey());
        }
        return result;

    }
}
