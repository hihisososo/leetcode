package leetcode.year_2024.may;

public class CountTripletsThatCanFormTwoArraysOfEqualXor {

  public static void main(String[] args) {
    System.out.println(
        new CountTripletsThatCanFormTwoArraysOfEqualXor().countTriplets(new int[]{2, 3, 1, 6, 7}));
    System.out.println(
        new CountTripletsThatCanFormTwoArraysOfEqualXor().countTriplets(new int[]{1, 1, 1, 1, 1}));

  }

  public int countTriplets(int[] arr) {
    int[] sum = new int[arr.length * arr.length + 1];

    for (int i = 0; i < arr.length; i++) {
      int val = 0;
      for (int j = i; j < arr.length; j++) {
        val ^= arr[j];
        sum[i * arr.length + j] = val;
      }
    }

    int cnt = 0;
    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        for (int k = j; k < arr.length; k++) {
          int a = sum[i * arr.length + j - 1];
          int b = sum[j * arr.length + k];
          if (a == b) {
            cnt++;
          }
        }
      }
    }
    return cnt;
  }
}
