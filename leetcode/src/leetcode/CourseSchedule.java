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

		HashSet<Integer> alreadyCheckSet = new HashSet<>();
		for (int key : valuesMap.keySet()) {
			HashSet<Integer> requireSet = new HashSet<>();
			if (checkDuplicate(valuesMap, key, requireSet, alreadyCheckSet)) {
				return false;
			}
		}

		return true;

	}

	private boolean checkDuplicate(HashMap<Integer, HashSet<Integer>> valuesMap, int key, HashSet<Integer> checkSet, HashSet<Integer> alreadyCheckSet) {
		if(alreadyCheckSet.contains(key)){
			return false;
		}else{
			if(checkSet.contains(key)){
				return true;
			}else{
				checkSet.addAll(valuesMap.get(key));
			}
		}
		return false;
	}

}
