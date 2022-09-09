package leetcode.year_2022.september;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class TheNumberOfWeakCharactersInTheGame {

  public static void main(String[] args) {
    System.out.println(new TheNumberOfWeakCharactersInTheGame().numberOfWeakCharacters(
        new int[][]{{1, 5}, {10, 4}, {4, 3}}));
    System.out.println(new TheNumberOfWeakCharactersInTheGame().numberOfWeakCharacters(
        new int[][]{{2, 2}, {3, 3}}));
    System.out.println(new TheNumberOfWeakCharactersInTheGame().numberOfWeakCharacters(
        new int[][]{{5, 5}, {6, 3}, {3, 6}}));
    System.out.println(new TheNumberOfWeakCharactersInTheGame().numberOfWeakCharacters(
        new int[][]{{1, 1}, {2, 1}, {2, 2}, {1, 2}}));
    System.out.println(new TheNumberOfWeakCharactersInTheGame().numberOfWeakCharacters(
        new int[][]{{7, 9}, {10, 7}, {6, 9}, {10, 4}, {7, 5}, {7, 10}}));

  }

  public int numberOfWeakCharacters(int[][] properties) {
    Arrays.sort(properties, new Comparator<int[]>() {
      @Override
      public int compare(int[] arr1, int[] arr2) {
        if (arr2[0] == arr1[0]) {
          return arr2[1] - arr1[1];
        }
        return arr2[0] - arr1[0];
      }
    });

    HashSet<Integer> attackChangeIdxSet = new HashSet<>();
    for (int i = 1; i < properties.length; i++) {
      if (properties[i][0] != properties[i - 1][0]) {
        attackChangeIdxSet.add(i);
      }
    }

    int defenceMaxLastAttack = Integer.MIN_VALUE;
    int defenceMaxAll = Integer.MIN_VALUE;
    int weakCnt = 0;
    for (int i = 0; i < properties.length; i++) {
      int[] character = properties[i];
      if (attackChangeIdxSet.contains(i)) {
        defenceMaxLastAttack = defenceMaxAll;
      }
      if (defenceMaxLastAttack > character[1]) {
        weakCnt++;
      }
      defenceMaxAll = Math.max(defenceMaxAll, character[1]);
    }
    return weakCnt;
  }
}
