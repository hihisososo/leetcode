package leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class CourseSchedule {
	public static void main(String[] args) {
		int numCourses = 3;
		int[][] prerequisites = new int[][] { { 1, 0 } };

		System.out.println(new CourseSchedule().canFinish(numCourses, prerequisites));
	}

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		HashMap<Integer, HashSet<Integer>> valuesMap = new HashMap<>();
		for (int i = 0; i < prerequisites.length; i++) {
			if (prerequisites[i][0] < numCourses && prerequisites[i][1] >= numCourses) {
				return false;
			}
			HashSet<Integer> values = null;
			if (valuesMap.get(prerequisites[i][0]) != null) {
				values = valuesMap.get(prerequisites[i][0]);
			} else {
				values = new HashSet<>();
			}
			values.add(prerequisites[i][1]);
			valuesMap.put(prerequisites[i][0], values);
		}

		for (int key : valuesMap.keySet()) {
			if (checkDuplicate(valuesMap, key, new HashSet<Integer>())) {
				return false;
			}
		}

		return true;

	}

	private boolean checkDuplicate(HashMap<Integer, HashSet<Integer>> valuesMap, int key,
			HashSet<Integer> checkedKeys) {
		if (checkedKeys.contains(key)) {
			return false;
		}
		checkedKeys.add(key);
		HashSet<Integer> map = valuesMap.get(key);
		if (map != null) {
			for (int val : map) {
				if (checkedKeys.contains(val)) {
					return true;
				} else {
					if (checkDuplicate(valuesMap, val, new HashSet<Integer>(checkedKeys))) {
						return true;
					}
				}

			}
		}

		return false;
	}

}
