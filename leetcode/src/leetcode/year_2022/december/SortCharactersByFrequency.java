package leetcode.year_2022.december;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SortCharactersByFrequency {
    public static void main(String[] args) {
        System.out.println(new SortCharactersByFrequency().frequencySort("tree"));
        System.out.println(new SortCharactersByFrequency().frequencySort("cccaaa"));
        System.out.println(new SortCharactersByFrequency().frequencySort("Aabb"));
    }

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.merge(c, 1, Integer::sum);
        }
        List<Map.Entry<Character, Integer>> entryList = new LinkedList(map.entrySet());
        entryList.sort(((o1, o2) -> map.get(o2.getKey()) - map.get(o1.getKey())));
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<Character, Integer> e : entryList) {
            for (int i = 0; i < e.getValue(); i++) {
                sb.append(e.getKey());
            }
        }
        return sb.toString();
    }

}
