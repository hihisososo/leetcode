package leetcode.year_2024.may;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KThSmallestPrimeFraction {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new KThSmallestPrimeFraction().kthSmallestPrimeFraction(new int[]{1, 2, 3, 5}, 3)));
        System.out.println(Arrays.toString(new KThSmallestPrimeFraction().kthSmallestPrimeFraction(new int[]{1, 7}, 1)));
    }

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<Pair<Double, String>> pq = new PriorityQueue<>(new Comparator<Pair<Double, String>>() {
            @Override
            public int compare(Pair<Double, String> o1, Pair<Double, String> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                double val = (double) arr[i] / arr[j];
                String point = i + "," + j;
                pq.add(new Pair<>(val, point));
            }
        }
        int cnt = 0;
        Pair<Double, String> val = null;

        while (cnt < k) {
            val = pq.poll();
            cnt++;
        }
        String point = val.getValue();
        int i = Integer.parseInt(point.split(",")[0]);
        int j = Integer.parseInt(point.split(",")[1]);
        return new int[]{arr[i], arr[j]};
    }
}
