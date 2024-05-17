package leetcode.year_2022.october;

import common.Pair;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TimeBasedKeyValueStore {

    public static void main(String[] args) {
        TimeBasedKeyValueStore timeMap = new TimeBasedKeyValueStore();
        timeMap.set("foo", "bar", 1);  // store the key "foo" and value "bar" along with timestamp = 1.
        System.out.println(timeMap.get("foo", 1));         // return "bar"
        System.out.println(timeMap.get("foo", 3));         // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
        timeMap.set("foo", "bar2", 4); // store the key "foo" and value "bar2" along with timestamp = 4.
        System.out.println(timeMap.get("foo", 4));         // return "bar2"
        System.out.println(timeMap.get("foo", 5));         // return "bar2"
    }

    private Map<String, List<Pair<String, Integer>>> keyValueTimeMap;

    public TimeBasedKeyValueStore() {
        this.keyValueTimeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        keyValueTimeMap.putIfAbsent(key, new LinkedList<>());
        keyValueTimeMap.get(key).add(new Pair<>(value, timestamp));

    }

    public String get(String key, int timestamp) {
        if (keyValueTimeMap.get(key) == null) {
            return "";
        }
        List<Pair<String, Integer>> timeList = keyValueTimeMap.get(key);
        int idx = timeList.size() - 1;
        StringBuilder sb = new StringBuilder();
        while (idx >= 0) {
            Pair<String, Integer> timeVal = timeList.get(idx);
            if (timeVal.getValue() <= timestamp) {
                sb.append(timeVal.getKey());
                break;
            }
            idx--;
        }
        return sb.toString();
    }
}
