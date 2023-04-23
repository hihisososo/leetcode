package leetcode.year_2023.april;

import java.util.HashMap;
import java.util.Map;

public class RestoreTheArray {
    public static void main(String[] args) {
        System.out.println(new RestoreTheArray().numberOfArrays("1317", 2000));
        System.out.println(new RestoreTheArray().numberOfArrays("1000", 10));
        System.out.println(new RestoreTheArray().numberOfArrays("1000", 10000));
        System.out.println(new RestoreTheArray().numberOfArrays("600342244431311113256628376226052681059918526204", 703));
        System.out.println(new RestoreTheArray().numberOfArrays("171895851301603621199279559472582240564804526335544534392551", 905));
        System.out.println(new RestoreTheArray().numberOfArrays("407780786171321121429620765476840275495357129574174233567552131453038760763182952432348422252546559691171161181440370120987634895458140447952079749439961325982629462531738374032416182281868731817661954890417245087359968833257550123324827240537957646002494771036413572415", 823924906));
    }

    public int numberOfArrays(String s, int k) {
        Map<String, Integer> cntMap = new HashMap<>();
        return findByDFS(s, k, cntMap);
    }

    private int findByDFS(String s, int k, Map<String, Integer> cntMap) {
        if (s.length() == 0) {
            return 1;
        } else if (s.charAt(0) == '0') {
            return 0;
        }

        if (cntMap.containsKey(s)) {
            return cntMap.get(s);
        }
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            String subStr = s.substring(0, i + 1);
            if (subStr.length() <= 10 && Long.parseLong(subStr) <= k) {
                int val = 0;
                if (cntMap.containsKey(s.substring(i + 1))) {
                    val = cntMap.get(s.substring(i + 1));
                } else {
                    val = findByDFS(s.substring(i + 1), k, cntMap) % (1000000000 + 7);
                    cntMap.put(s.substring(i + 1), val);
                }
                sum = sum % (1000000000 + 7) + val;
            } else {
                break;
            }
        }

        return sum % (1000000000 + 7);
    }
}
