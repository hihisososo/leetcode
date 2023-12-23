package leetcode.year_2023.december;

import java.util.HashSet;
import java.util.Set;

public class PathCrossing {

  public static void main(String[] args) {
    System.out.println(new PathCrossing().isPathCrossing("NESWW"));
    System.out.println(new PathCrossing().isPathCrossing("NES"));

  }

  public boolean isPathCrossing(String path) {
    Set<String> point = new HashSet<>();
    int x = 0;
    int y = 0;
    point.add("0/0");
    for (int i = 0; i < path.length(); i++) {
      char c = path.charAt(i);
      if (c == 'N') {
        y++;
      } else if (c == 'E') {
        x++;
      } else if (c == 'S') {
        y--;
      } else {
        x--;
      }
      if (point.contains(x + "/" + y)) {
        return true;
      }
      point.add(x + "/" + y);
    }
    return false;
  }
}
