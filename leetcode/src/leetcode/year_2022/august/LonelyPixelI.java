package leetcode.year_2022.august;

public class LonelyPixelI {
    public static void main(String[] args) {
        char[][] pixel = new char[][]{{'W', 'W', 'B'}, {'W', 'B', 'W'}, {'B', 'W', 'W'}};
        System.out.println(new LonelyPixelI().findLonelyPixel(pixel));
        char[][] pixel2 = new char[][]{{'B', 'B', 'B'}, {'B', 'B', 'W'}, {'B', 'B', 'B'}};
        System.out.println(new LonelyPixelI().findLonelyPixel(pixel2));
    }

    public int findLonelyPixel(char[][] picture) {
        int[] rowSum = new int[picture.length];
        int[] colSum = new int[picture[0].length];

        for (int i = 0; i < rowSum.length; i++) {
            for (int j = 0; j < picture[0].length; j++) {
                if (picture[i][j] == 'B') {
                    colSum[j] += 1;
                    rowSum[i] += 1;
                }
            }
        }

        int lonelyPixel = 0;
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[0].length; j++) {
                if (picture[i][j] == 'B' && rowSum[i] == 1 && colSum[j] == 1) {
                    lonelyPixel++;
                }
            }
        }
        return lonelyPixel;
    }

}
