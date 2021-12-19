package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms {
    public static void main(String[] args) {
        //int[][] intervals = new int[][]{{0, 30}, {5, 10}, {15, 20}};
        int[][] intervals = new int[][]{{7, 10}, {2, 4}};
        System.out.println(new MeetingRooms().canAttendMeetings(intervals));
    }

    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int start = 0;
        int end = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                return false;
            }
            end = Math.max(end, intervals[i][1]);
        }
        return true;
    }
}
