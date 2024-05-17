package leetcode.year_2024.may;

import common.Pair;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ReconstructItinerary {

  public static void main(String[] args) {
    String[][] data = new String[][]{{"JFK", "SFO"}, {"JFK", "ATL"}, {"SFO", "JFK"}, {"ATL", "AAA"},
        {"AAA", "BBB"}, {"BBB", "ATL"}, {"ATL", "AAA"}, {"AAA", "BBB"}, {"BBB", "ATL"},
        {"ATL", "AAA"}, {"AAA", "BBB"}, {"BBB", "ATL"}, {"ATL", "AAA"}, {"AAA", "BBB"},
        {"BBB", "ATL"}, {"ATL", "AAA"}, {"AAA", "BBB"}, {"BBB", "ATL"}, {"ATL", "AAA"},
        {"AAA", "BBB"}, {"BBB", "ATL"}, {"ATL", "AAA"}, {"AAA", "BBB"}, {"BBB", "ATL"},
        {"ATL", "AAA"}, {"AAA", "BBB"}, {"BBB", "ATL"}, {"ATL", "AAA"}, {"AAA", "BBB"},
        {"BBB", "ATL"}, {"ATL", "AAA"}, {"AAA", "BBB"}, {"BBB", "ATL"}, {"ATL", "AAA"},
        {"AAA", "BBB"}, {"BBB", "ATL"}, {"ATL", "AAA"}, {"AAA", "BBB"}, {"BBB", "ATL"},
        {"ATL", "AAA"}, {"AAA", "BBB"}, {"BBB", "ATL"}, {"ATL", "AAA"}, {"AAA", "BBB"},
        {"BBB", "ATL"}, {"ATL", "AAA"}, {"AAA", "BBB"}, {"BBB", "ATL"}, {"ATL", "AAA"},
        {"AAA", "BBB"}, {"BBB", "ATL"}, {"ATL", "AAA"}, {"AAA", "BBB"}, {"BBB", "ATL"},
        {"ATL", "AAA"}, {"AAA", "BBB"}, {"BBB", "ATL"}, {"ATL", "AAA"}, {"AAA", "BBB"},
        {"BBB", "ATL"}, {"ATL", "AAA"}, {"AAA", "BBB"}, {"BBB", "ATL"}, {"ATL", "AAA"},
        {"AAA", "BBB"}, {"BBB", "ATL"}, {"ATL", "AAA"}, {"AAA", "BBB"}, {"BBB", "ATL"},
        {"ATL", "AAA"}, {"AAA", "BBB"}, {"BBB", "ATL"}, {"ATL", "AAA"}, {"AAA", "BBB"},
        {"BBB", "ATL"}, {"ATL", "AAA"}, {"AAA", "BBB"}, {"BBB", "ATL"}, {"ATL", "AAA"},
        {"AAA", "BBB"}, {"BBB", "ATL"}};
    List<List<String>> datas = Arrays.stream(data)
        .map(Arrays::asList)
        .collect(Collectors.toList());
    System.out.println(new ReconstructItinerary().findItinerary(datas));
  }

  private boolean find = false;
  private List<String> result = new ArrayList<>();

  public List<String> findItinerary(List<List<String>> tickets) {
    Collections.sort(tickets, (a, b) -> a.get(1).compareTo(b.get(1)));
    Map<String, List<Pair<String, Integer>>> fromTo = new HashMap<>();
    for (int i = 0; i < tickets.size(); i++) {
      String from = tickets.get(i).get(0);
      String to = tickets.get(i).get(1);
      fromTo.putIfAbsent(from, new ArrayList<>());
      fromTo.get(from).add(new Pair<>(to, i));
    }

    dfs("JFK", fromTo, new LinkedList<>(), new HashSet<Integer>(), new HashSet<String>(),
        tickets.size());

    return result;
  }

  private void dfs(String name, Map<String, List<Pair<String, Integer>>> fromTo,
      LinkedList<String> paths, Set<Integer> useTicketNum, Set<String> pathSet, int length) {
    if (find) {
      return;
    }
    paths.addLast(name);
    String pathStr = paths.stream().collect(Collectors.joining(","));
    if (pathSet.contains(pathStr)) {
      paths.removeLast();
      return;
    }
    pathSet.add(pathStr);

    if (useTicketNum.size() == length) {
      find = true;
      result.addAll(paths);
    }

    Iterator<Pair<String, Integer>> iter = fromTo.getOrDefault(name, Collections.emptyList())
        .iterator();
    while (iter.hasNext()) {
      Pair<String, Integer> next = iter.next();
      if (!useTicketNum.contains(next.getValue())) {
        useTicketNum.add(next.getValue());
        dfs(next.getKey(), fromTo, paths, useTicketNum, pathSet, length);
        useTicketNum.remove(next.getValue());
      }
    }
    paths.removeLast();
  }
}
