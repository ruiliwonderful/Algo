package com.rui.lintcode.dp;

public class MaxSquare {
	public int maximalSquare(char[][] matrix) {
		int max = 0;
		int m = matrix.length;
		if (m == 0)
			return 0;
		int n = matrix[0].length;

		int[][] result = new int[m][n];
		// init corner cases for result
		for (int i = 0; i < n; i++) {
			if (matrix[0][i] == 1) {
				result[0][i] = 1;
				max = Math.max(max, result[0][i]);
			} else
				result[0][i] = 0;
		}

		for (int i = 0; i < m; i++) {
			if (matrix[i][0] == 1) {
				result[i][0] = 1;
				max = Math.max(max, result[i][0]);
			} else
				result[i][0] = 0;
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][j] == 1) {
					result[i][j] = Math.min(result[i - 1][j - 1],
							Math.min(result[i - 1][j], result[i][j - 1])) + 1;
					if (result[i][j] > max) {
						max = result[i][j];
					}
				} else
					result[i][j] = 0;
			}
		}// for

		return max;

	}

}
