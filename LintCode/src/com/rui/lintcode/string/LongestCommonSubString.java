package com.rui.lintcode.string;

/*
 * http://www.lintcode.com/en/problem/longest-common-substring/#
 */
public class LongestCommonSubString {

	public static int longestCommonSubstring(String A, String B) {
		// write your code here
		int m = A.length();
		int n = B.length();
		if (m == 0 || n == 0)
			return 0;
		int[][] count = new int[m + 1][n + 1];
//
//		for (int p = 0; p <= m; p++) {
//			count[0][p] = 0;
//		}
//
//		for (int q = 0; q <= n; q++) {
//			count[q][0] = 0;
//		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				
				
				if (A.charAt(i) == B.charAt(j))
					count[i + 1][j + 1] = Math.max(count[i][j + 1],
							count[i + 1][j]) + 1;
				else
					count[i + 1][j + 1] = Math.max(count[i][j + 1],
							count[i + 1][j]);
			}
		}

		System.out.println(m);
		return count[m][n];
	}

	public static void main(String args[]) {

		String a = "www.lintcode.com code";
		String b = "www.ninechapter.com code";
		System.out.println(longestCommonSubstring(a, b));
	}

	
	
}
