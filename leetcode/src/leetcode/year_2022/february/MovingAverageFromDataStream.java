package leetcode.year_2022.february;

import java.util.ArrayDeque;
import java.util.Queue;

public class MovingAverageFromDataStream {
    public static void main(String[] args) {
        MovingAverageFromDataStream movingAverage = new MovingAverageFromDataStream(3);
        System.out.println(movingAverage.next(1));; // return 1.0 = 1 / 1
        System.out.println(movingAverage.next(10)); // return 5.5 = (1 + 10) / 2
        System.out.println(movingAverage.next(3)); // return 4.66667 = (1 + 10 + 3) / 3
        System.out.println(movingAverage.next(5)); // return 6.0 = (10 + 3 + 5) / 3
    }

    int currSize;
    int size;
    Queue<Integer> queue;
    int sum;

    public MovingAverageFromDataStream(int size) {
        this.size = size;
        queue = new ArrayDeque<>(3);
    }

    public double next(int val) {
        currSize++;
        sum += val;
        queue.add(val);
        if (queue.size() > size) {
            currSize--;
            sum -= queue.poll();
        }

        return (double) sum / currSize;
    }
}
