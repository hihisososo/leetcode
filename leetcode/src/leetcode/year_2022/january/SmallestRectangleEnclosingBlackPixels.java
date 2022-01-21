package leetcode.year_2022.january;

public class SmallestRectangleEnclosingBlackPixels {
    public static void main(String[] args) {
        /*char[][] image = {{'0', '0', '1', '0'}, {'0', '1', '1', '0'}, {'0', '1', '0', '0'}};
        int x = 0;
        int y = 2;*/
        char[][] image = {{'0', '1'}};
        int x = 0;
        int y = 1;
        System.out.println(new SmallestRectangleEnclosingBlackPixels().minArea(image, x, y));
    }

    public int minArea(char[][] image, int x, int y) {
        Point point = new Point();
        traverseBlackPixel(image, x, y, new boolean[image.length][image[0].length], point);
        System.out.println(point);
        return (point.xmax - point.xmin + 1) * (point.ymax - point.ymin + 1);
    }

    private void traverseBlackPixel(char[][] image, int x, int y, boolean[][] visit, Point point) {
        if (x < 0 || x >= image.length || y < 0 || y >= image[0].length) {
            return;
        }
        if (visit[x][y] || image[x][y] == '0') {
            return;
        }

        visit[x][y] = true;
        compareMaxMin(point, x, y);
        traverseBlackPixel(image, x - 1, y, visit, point);
        traverseBlackPixel(image, x + 1, y, visit, point);
        traverseBlackPixel(image, x, y - 1, visit, point);
        traverseBlackPixel(image, x, y + 1, visit, point);
    }

    private void compareMaxMin(Point point, int x, int y) {
        point.xmin = Math.min(x, point.xmin);
        point.xmax = Math.max(x, point.xmax);
        point.ymin = Math.min(y, point.ymin);
        point.ymax = Math.max(y, point.ymax);
    }

    class Point {
        int xmin = Integer.MAX_VALUE;
        int xmax = Integer.MIN_VALUE;
        int ymin = Integer.MAX_VALUE;
        int ymax = Integer.MIN_VALUE;

        @Override
        public String toString() {
            return "Point{" +
                    "xmin=" + xmin +
                    ", xmax=" + xmax +
                    ", ymin=" + ymin +
                    ", ymax=" + ymax +
                    '}';
        }
    }
}
