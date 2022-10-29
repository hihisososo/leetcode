package leetcode.year_2022.october;

import javafx.util.Pair;

import java.util.*;

public class EarliestPossibleDayofFullBloom {
    public static void main(String[] args) {
        System.out.println(new EarliestPossibleDayofFullBloom().earliestFullBloom(new int[]{1, 4, 3}, new int[]{2, 3, 1}));
        System.out.println(new EarliestPossibleDayofFullBloom().earliestFullBloom(new int[]{1, 2, 3, 2}, new int[]{2, 1, 2, 1}));
    }

    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        List<Integer> plants = new ArrayList<>();
        int firstDayIdx = -1;
        int min = Integer.MAX_VALUE;
        for (int i=0;i<plantTime.length;i++){
            if(plantTime[i] < min){
                min = plantTime[i];
                firstDayIdx = i;
            }
        }

        int lastDayIdx = -1;
        min = Integer.MAX_VALUE;
        for (int i=0;i<growTime.length;i++){
            if(growTime[i] < min){
                min = growTime[i];
                lastDayIdx = i;
            }
        }

        PriorityQueue<Pair<Integer,Integer>> maxGrow
        for (int i=0;i<plantTime.length;i++){
            if(i != firstDayIdx && i != lastDayIdx){
                plants.add(plantTime)
            }
        }
    }
}
