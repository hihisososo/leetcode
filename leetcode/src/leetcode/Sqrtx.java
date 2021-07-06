package leetcode;

public class Sqrtx {
    public static void main(String[] args) {
        int x = 2147395599;
        System.out.println(new Sqrtx().mySqrt(x));
    }

    public int mySqrt(int x) {
        return binarySearch(0, 46341, x);
    }

    private int binarySearch(int start, int end, int x) {
        while (end - start > 1) {
            int value = (end + start) / 2;
            int multi = value * value;
            if (multi > x) {
                end = value;
            } else if (multi < x) {
                start = value;
            } else {
                return value;
            }
        }
        if (start * start > x) {
            return start - 1;
        } else if ((start * start) < x) {
            return start;
        } else {
            return start;
        }

    }
}
