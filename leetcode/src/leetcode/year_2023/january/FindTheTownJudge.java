package leetcode.year_2023.january;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class FindTheTownJudge {

  public static void main(String[] args) {
    System.out.println(new FindTheTownJudge().findJudge(2, new int[][]{{1, 2}}));
    System.out.println(new FindTheTownJudge().findJudge(3, new int[][]{{1, 3}, {2, 3}}));
    System.out.println(new FindTheTownJudge().findJudge(3, new int[][]{{1, 3}, {2, 3}, {3, 1}}));
  }

  public int findJudge(int n, int[][] trust) {
    Map<Integer, Set<Integer>> trustMap = new HashMap<>();
    Map<Integer, Set<Integer>> trustReverseMap = new HashMap<>();
    for (int i = 1; i <= n; i++) {
      trustMap.putIfAbsent(i, new HashSet<>());
      trustReverseMap.putIfAbsent(i, new HashSet<>());
    }

    for (int[] t : trust) {
      trustMap.get(t[1]).add(t[0]);
      trustReverseMap.get(t[0]).add(t[1]);
    }

    List<Entry<Integer, Set<Integer>>> result = trustMap.entrySet().stream()
        .filter(e -> e.getValue().size() == n - 1)
        .filter(e -> trustReverseMap.get(e.getKey()).size() == 0)
        .collect(Collectors.toList());
    if (result.size() != 1) {
      return -1;
    }
    return result.get(0).getKey();
  }
}
