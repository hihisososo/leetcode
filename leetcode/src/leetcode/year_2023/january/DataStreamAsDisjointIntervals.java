package leetcode.year_2023.january;

import java.util.Arrays;
import java.util.LinkedList;
import javafx.util.Pair;

public class DataStreamAsDisjointIntervals {

  public static void main(String[] args) {
    DataStreamAsDisjointIntervals obj = new DataStreamAsDisjointIntervals();
    obj.addNum(1);      // arr = [1]
    System.out.println(Arrays.deepToString(obj.getIntervals())); // return [[1, 1]]
    obj.addNum(3);      // arr = [1, 3]
    System.out.println(Arrays.deepToString(obj.getIntervals())); // return [[1, 1], [3, 3]]
    obj.addNum(7);      // arr = [1, 3, 7]
    System.out.println(Arrays.deepToString(obj.getIntervals())); // return [[1, 1], [3, 3], [7, 7]]
    obj.addNum(2);      // arr = [1, 2, 3, 7]
    System.out.println(Arrays.deepToString(obj.getIntervals())); // return [[1, 3], [7, 7]]
    obj.addNum(6);      // arr = [1, 2, 3, 6, 7]
    System.out.println(Arrays.deepToString(obj.getIntervals())); // return [[1, 3], [6, 7]]
  }

  LinkedList<Pair<Integer, Integer>> intervals;

  public DataStreamAsDisjointIntervals() {
    this.intervals = new LinkedList<>();
  }

  public void addNum(int value) {
    int intervalIdx = binarySearch(value);
    if (intervalIdx < 0) {
      System.out.println(-intervalIdx);
      if (-intervalIdx > intervals.size()) {
        intervals.addLast(new Pair<>(value, value));
      } else {
        intervals.add(-intervalIdx - 1, new Pair<>(value, value));
      }
      doMergeIfPossible(-intervalIdx - 1);
    }
  }

  private void doMergeIfPossible(int idx) {
    if (idx + 1 < intervals.size() && intervals.get(idx).getValue() + 1 == intervals.get(idx + 1)
        .getKey()) {
      merge(idx, idx + 1);
    }
    if (idx - 1 >= 0 && intervals.get(idx - 1).getValue() + 1 == intervals.get(idx).getKey()) {
      merge(idx - 1, idx);
    }
  }

  private void merge(int left, int right) {
    int leftMin = intervals.get(left).getKey();
    int rightMax = intervals.get(right).getValue();
    intervals.remove(right);
    intervals.remove(left);
    if (intervals.size() == 0) {
      intervals.addFirst(new Pair<>(leftMin, rightMax));
    } else {
      intervals.add(left, new Pair<>(leftMin, rightMax));
    }
  }

  private int binarySearch(int key) {
    int low = 0;
    int high = intervals.size() - 1;

    while (low <= high) {
      int mid = (low + high) >>> 1;
      Pair<Integer, Integer> minMax = intervals.get(mid);

      if (minMax.getKey() <= key && minMax.getValue() >= key) {
        return mid;
      } else if (minMax.getValue() < key) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return -(low + 1);  // key not found.
  }

  public int[][] getIntervals() {
    int[][] result = new int[intervals.size()][];
    for (int i = 0; i < intervals.size(); i++) {
      result[i] = new int[]{intervals.get(i).getKey(), intervals.get(i).getValue()};
    }
    return result;
  }
}
