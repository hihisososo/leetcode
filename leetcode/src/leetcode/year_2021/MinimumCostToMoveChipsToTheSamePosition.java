package leetcode.year_2021;

public class MinimumCostToMoveChipsToTheSamePosition {
    public static void main(String[] args) {
        int[] position = new int[]{1, 2, 3};
        System.out.println(new MinimumCostToMoveChipsToTheSamePosition().minCostToMoveChips(position));
    }

    public int minCostToMoveChips(int[] position) {
        int oddTotal = 0;
        int evenTotal = 0;

        for (int i = 0; i < position.length; i++) {
            if (position[i] % 2 == 0) {
                evenTotal++;
            } else {
                oddTotal++;
            }
        }
        return Math.min(oddTotal, evenTotal);
    }

}
