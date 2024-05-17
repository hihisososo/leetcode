package leetcode.year_2022.october;

public class MinimumTimeToMakeRopeColorful {
    public static void main(String[] args) {
        System.out.println(new MinimumTimeToMakeRopeColorful().minCost("abaac", new int[]{1, 2, 3, 4, 5}));
        System.out.println(new MinimumTimeToMakeRopeColorful().minCost("abc", new int[]{1, 2, 3, 4, 5}));
        System.out.println(new MinimumTimeToMakeRopeColorful().minCost("aabaa", new int[]{1, 2, 3, 4, 1}));
        System.out.println(new MinimumTimeToMakeRopeColorful().minCost("bbbaaa", new int[]{4, 9, 3, 8, 8, 9}));
        System.out.println(new MinimumTimeToMakeRopeColorful().minCost("aaabbbabbbb", new int[]{3, 5, 10, 7, 5, 3, 5, 5, 4, 8, 1}));
    }

    public int minCost(String colors, int[] neededTime) {
        int result = 0;
        int maxVal = Integer.MIN_VALUE;
        int sum = 0;
        boolean seq = false;
        for (int i = 1; i < colors.length(); i++) {
            if (colors.charAt(i) == colors.charAt(i - 1)) {
                if (!seq) {
                    seq = true;
                }
                maxVal = Math.max(neededTime[i - 1], maxVal);
                sum += neededTime[i - 1];
            } else {
                if (seq) {
                    maxVal = Math.max(neededTime[i - 1], maxVal);
                    sum += neededTime[i - 1];
                    result += (sum - maxVal);
                    sum = 0;
                    maxVal = Integer.MIN_VALUE;
                    seq = false;
                }
            }
        }
        if (seq) {
            maxVal = Math.max(neededTime[colors.length() - 1], maxVal);
            sum += neededTime[colors.length() - 1];
            result += (sum - maxVal);
        }
        return result;
    }
}
