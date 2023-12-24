package leetcode.year_2023.december;

import java.util.ArrayList;
import java.util.List;

public class MinimumChangesToMakeAlternatingBinaryString {

  public static void main(String[] args) {
    System.out.println(new MinimumChangesToMakeAlternatingBinaryString().minOperations("0100"));
    System.out.println(new MinimumChangesToMakeAlternatingBinaryString().minOperations("10"));
    System.out.println(new MinimumChangesToMakeAlternatingBinaryString().minOperations("1111"));
  }

  public int minOperations(String s) {
    List<String> goals = new ArrayList<>();
    String goal1 = "";
    String goal2 = "";
    for (int i = 0; i < s.length(); i++) {
      if (i % 2 == 0) {
        goal1 += '0';
        goal2 += '1';
      } else {
        goal1 += '1';
        goal2 += '0';
      }
    }
    goals.add(goal1);
    goals.add(goal2);

    int diffCntMin = Integer.MAX_VALUE;
    for (int i = 0; i < goals.size(); i++) {
      String goal = goals.get(i);
      int diffCnt = 0;
      for (int j = 0; j < s.length(); j++) {
        if (s.charAt(j) != goal.charAt(j)) {
          diffCnt++;
        }
      }
      diffCntMin = Math.min(diffCnt, diffCntMin);
    }
    return diffCntMin;
  }
}
