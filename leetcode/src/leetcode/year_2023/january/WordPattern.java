package leetcode.year_2023.january;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

  public static void main(String[] args) {
    System.out.println(new WordPattern().wordPattern("abba", "dog cat cat dog"));
    System.out.println(new WordPattern().wordPattern("abba", "dog cat cat fish"));
    System.out.println(new WordPattern().wordPattern("aaaa", "dog cat cat fish"));
    System.out.println(new WordPattern().wordPattern("abba", "dog dog dog dog"));
    System.out.println(new WordPattern().wordPattern("aaaa", "dog dog dog dog"));
  }

  public boolean wordPattern(String pattern, String s) {

    Map<Character, String> map = new HashMap<>();
    Map<String, Character> reverseMap = new HashMap<>();
    String[] splitted = s.split(" ");
    if (pattern.length() != splitted.length) {
      return false;
    }

    for (int i = 0; i < pattern.length(); i++) {
      char patternChar = pattern.charAt(i);
      map.putIfAbsent(patternChar, splitted[i]);
      if (!map.get(patternChar).equals(splitted[i])) {
        return false;
      }
      reverseMap.putIfAbsent(splitted[i], patternChar);
      if(!reverseMap.get(splitted[i]).equals(patternChar)){
        return false;
      }
    }
    return true;

  }
}
