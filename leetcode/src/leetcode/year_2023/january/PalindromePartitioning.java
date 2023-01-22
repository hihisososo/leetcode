package leetcode.year_2023.january;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

  public static void main(String[] args) {
    System.out.println(new PalindromePartitioning().partition("aab"));
    System.out.println(new PalindromePartitioning().partition("a"));
  }

  public List<List<String>> partition(String s) {
    List<List<String>> result = new ArrayList<>();
    for (int i=0;i<s.length();i++) {
      findPalindromePartition(s, 0, i, new ArrayList<>(), result);
    }
    return result;
  }

  private void findPalindromePartition(String s, int start, int end,
      List<String> lists, List<List<String>> result) {
    if (!isPalindrome(s, start, end)) {
      return;
    }
    lists.add(s.substring(start, end+1));

    for (int i = end + 1; i < s.length(); i++) {
      findPalindromePartition(s, end+1, i, new ArrayList<>(lists), result);
    }

    if (end == s.length()-1) {
      result.add(lists);
    }
  }

  private boolean isPalindrome(String s, int start, int end) {
    for (int i = start; i <= (start + end) / 2; i++) {
      if (s.charAt(i) != s.charAt(end - (i - start))) {
        return false;
      }
    }
    return true;
  }
}
