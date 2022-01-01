package leetcode.year_2021;

import java.util.concurrent.atomic.AtomicBoolean;

public class SearchA2DMatrixII {
	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 },
				{ 10, 13, 14, 17, 24 }, { 18, 21, 23, 26, 30 } };
		int target = 5;
		System.out.println(new SearchA2DMatrixII().searchMatrix(matrix, target));
	}

	public boolean searchMatrix(int[][] matrix, int target) {
		AtomicBoolean isFind = new AtomicBoolean(false);
		boolean[][] visit = new boolean[matrix.length][matrix[0].length];
		findTarget(matrix, 0, 0, target, isFind, visit);
		return isFind.get();
	}

	private void findTarget(int[][] matrix, int i, int j, int target, AtomicBoolean isFind, boolean[][] visit) {
		if (visit[i][j] == true) {
			return;
		} else {
			visit[i][j] = true;
		}

		if (matrix[i][j] == target) {
			isFind.set(true);
			return;
		} else if (matrix[i][j] > target) {
			return;
		} else {
			if (i + 1 < matrix.length) {
				findTarget(matrix, i + 1, j, target, isFind, visit);
			}
			if (j + 1 < matrix[0].length) {
				findTarget(matrix, i, j + 1, target, isFind, visit);
			}
		}
	}
}
