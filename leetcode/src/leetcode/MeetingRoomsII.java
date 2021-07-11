package leetcode;

import java.util.HashSet;

public class MeetingRoomsII {
	public static void main(String[] args) {
		int[][] intervals = new int[][] { { 13, 15 }, { 1, 13 } };
		System.out.println(new MeetingRoomsII().minMeetingRooms(intervals));
	}

	public int minMeetingRooms(int[][] intervals) {
		HashSet<Integer> points = new HashSet<>();

		for (int i = 0; i < intervals.length; i++) {
			points.add(intervals[i][0]);
			points.add(intervals[i][1]);
		}

		int maxDup = 0;
		for (int i : points) {
			int dup = 0;
			for (int j = 0; j < intervals.length; j++) {
				if (intervals[j][0] <= i && i < intervals[j][1]) {
					dup++;
				}
				maxDup = Math.max(maxDup, dup);
			}
		}
		return maxDup;
	}
}
