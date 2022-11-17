package leetcode.year_2022.november;

public class RectangleArea {
    public static void main(String[] args) {
        System.out.println(new RectangleArea().computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
        System.out.println(new RectangleArea().computeArea(-2, -2, 2, 2, -2, -2, 2, 2));
    }

    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int leftRecArea = (ax2 - ax1) * (ay2 - ay1);
        int rightRecArea = (bx2 - bx1) * (by2 - by1);

        int overlapXLen = overlapXLen(ax1, ax2, bx1, bx2);
        int overlapYLen = overlapYLen(ay1, ay2, by1, by2);

        int overlapArea = 0;
        if (overlapXLen > 0 && overlapYLen > 0) {
            overlapArea = overlapXLen * overlapYLen;
        }

        return leftRecArea + rightRecArea - overlapArea;

    }

    private int overlapYLen(int ay1, int ay2, int by1, int by2) {
        if (ay2 <= by1 || ay1 >= by2) {
            return 0;
        }
        int up = ay1 >= by1 ? ay1 : by1;
        int down = ay2 >= by2 ? by2 : ay2;
        return Math.abs(up - down);
    }

    private int overlapXLen(int ax1, int ax2, int bx1, int bx2) {
        if (ax2 <= bx1 || ax1 >= bx2) {
            return 0;
        }

        int left = ax1 >= bx1 ? ax1 : bx1;
        int right = ax2 >= bx2 ? bx2 : ax2;
        return Math.abs(right - left);
    }

}
