package leetcode.year_2023.december;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WidestVerticalAreaBetween {

  public static void main(String[] args) {
    System.out.println(new WidestVerticalAreaBetween()
        .maxWidthOfVerticalArea(new int[][]{{8, 7}, {9, 9}, {7, 4}, {9, 7}}));
    System.out.println(new WidestVerticalAreaBetween()
        .maxWidthOfVerticalArea(new int[][]{{3, 1}, {9, 0}, {1, 0}, {1, 4}, {5, 3}, {8, 8}}));
  }

  public int maxWidthOfVerticalArea(int[][] points) {
    int max = 0;
    List<Integer> xPoints = new ArrayList<>();
    for (int i = 0; i < points.length; i++) {
      xPoints.add(points[i][0]);
    }
    Collections.sort(xPoints);
    for (int i = 1; i < xPoints.size(); i++) {
      max = Math.max(xPoints.get(i) - xPoints.get(i - 1), max);
    }
    return max;
  }
}
