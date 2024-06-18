package leetcode.year_2024.june;

public class SumOfSquareNumbers {
    public static void main(String[] args) {
        System.out.println(new SumOfSquareNumbers().judgeSquareSum(5));
        System.out.println(new SumOfSquareNumbers().judgeSquareSum(3));
        System.out.println(new SumOfSquareNumbers().judgeSquareSum(4));
        System.out.println(new SumOfSquareNumbers().judgeSquareSum(0));
        System.out.println(new SumOfSquareNumbers().judgeSquareSum(6));
        System.out.println(new SumOfSquareNumbers().judgeSquareSum(9));
    }

    public boolean judgeSquareSum(int c) {
        if (c == 0) {
            return true;
        }
        int root = (int) Math.sqrt(c);
        for (int i = 0; i <= root; i++) {
            int left = 0;
            int right = root;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                double val = Math.pow(i, 2) + Math.pow(mid, 2);
                if (val < c) {
                    left = mid + 1;
                } else if (val > c) {
                    right = mid - 1;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}
