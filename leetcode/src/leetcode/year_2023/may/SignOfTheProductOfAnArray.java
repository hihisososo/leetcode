package leetcode.year_2023.may;

public class SignOfTheProductOfAnArray {

  public static void main(String[] args) {
    System.out
        .println(new SignOfTheProductOfAnArray().arraySign(new int[]{-1, -2, -3, -4, 3, 2, 1}));
    System.out.println(new SignOfTheProductOfAnArray().arraySign(new int[]{1, 5, 0, 2, -3}));
    System.out.println(new SignOfTheProductOfAnArray().arraySign(new int[]{-1, 1, -1, 1, -1}));
  }

  public int arraySign(int[] nums) {
    boolean positive = true;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        return 0;
      } else if (nums[i] < 0) {
        positive = !positive;
      }
    }
    return positive ? 1 : -1;
  }
}
