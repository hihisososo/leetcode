package leetcode.year_2021;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AlienDictionary {
    public static void main(String[] args) {
        String[] words = new String[]{"wrt", "wrf", "er", "ett", "rftt"};
        new AlienDictionary().alienOrder(words);
    }

    public String alienOrder(String[] words) {
        HashMap<Character, List<Character>> wordMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                if (wordMap.get(words[i].charAt(j)) == null) {
                    wordMap.put(words[i].charAt(j), new ArrayList<>());
                }
            }
        }


        return "";

    }

    class CharNode {
        char c;
        List<CharNode> lowers;

        public CharNode(char c) {
            this.c = c;
            this.lowers = new ArrayList<>();
        }
    }

}
