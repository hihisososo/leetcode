package leetcode.year_2021;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DailyTemperatures {
    public static void main(String[] args) {

        int[] temperatures = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(new DailyTemperatures().dailyTemperatures(temperatures)));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        PriorityQueue<Temperature> priorityQueue = new PriorityQueue<>(new Comparator<Temperature>() {
            @Override
            public int compare(Temperature o1, Temperature o2) {
                return o1.value - o2.value;
            }
        });

        for (int i = 0; i < temperatures.length; i++) {
            int val = temperatures[i];

            while (!priorityQueue.isEmpty()) {
                if (priorityQueue.peek().value < val) {
                    int idx = priorityQueue.poll().idx;
                    answer[idx] = i - idx;
                } else {
                    break;
                }
            }
            priorityQueue.add(new Temperature(temperatures[i], i));

        }
        return answer;
    }

    class Temperature {
        private int value;
        private int idx;

        public Temperature(int value, int idx) {
            this.value = value;
            this.idx = idx;
        }
    }


}
