package leetcode.year_2021;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupShiftedStrings {
    public static void main(String[] args) {
        String[] strings = new String[]{"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
        System.out.println(new GroupShiftedStrings().groupStrings(strings));
    }

    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (String s : strings) {
            String differenceStr = "";
            for (int i = 0; i < s.length() - 1; i++) {
                int difference = (s.charAt(i + 1) - s.charAt(i));
                if (difference < 0) {
                    difference += 26;
                }
                differenceStr += (difference + "/");
            }
            map.putIfAbsent(differenceStr, new ArrayList<>());
            map.get(differenceStr).add(s);
        }

        List<List<String>> result = new ArrayList<>();
        for (String key : map.keySet()) {
            result.add(map.get(key));
        }
        return result;
    }
}
