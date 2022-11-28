package leetcode.year_2022.november;

import java.util.*;

public class FindPlayersWithZeroOrOneLosses {
    public static void main(String[] args) {
        System.out.println(new FindPlayersWithZeroOrOneLosses().findWinners(new int[][]{{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {4, 9}, {10, 4}, {10, 9}}));
        System.out.println(new FindPlayersWithZeroOrOneLosses().findWinners(new int[][]{{2,3},{1,3},{5,4},{6,4}}));
    }

    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> winCnt = new TreeMap<>();
        Map<Integer, Integer> loseCnt = new TreeMap<>();
        for (int i = 0; i < matches.length; i++) {
            winCnt.merge(matches[i][0], 1, Integer::sum);
            loseCnt.merge(matches[i][1], 1, Integer::sum);
        }
        List<Integer> notLosts = new ArrayList<>();
        List<Integer> oneLosts = new ArrayList<>();
        for (int winner : winCnt.keySet()) {
            if (!loseCnt.containsKey(winner)) {
                notLosts.add(winner);
            }
        }
        for (int loser : loseCnt.keySet()) {
            if (loseCnt.get(loser) == 1) {
                oneLosts.add(loser);
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        result.add(notLosts);
        result.add(oneLosts);
        return result;
    }
}
