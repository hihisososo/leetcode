package leetcode.year_2024.june;

import java.util.Arrays;

public class MinimumNumberOfMovesToSeatEveryone {
    public static void main(String[] args) {
        System.out.println(new MinimumNumberOfMovesToSeatEveryone().minMovesToSeat(new int[]{3, 1, 5}, new int[]{2, 7, 4}));
        System.out.println(new MinimumNumberOfMovesToSeatEveryone().minMovesToSeat(new int[]{4, 1, 5, 9}, new int[]{1, 3, 2, 6}));
        System.out.println(new MinimumNumberOfMovesToSeatEveryone().minMovesToSeat(new int[]{2, 2, 6, 6}, new int[]{1, 3, 2, 6}));

    }

    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int moves = 0;
        for (int i = 0; i < students.length; i++) {
            moves += Math.abs(students[i] - seats[i]);
        }
        return moves;
    }
}
