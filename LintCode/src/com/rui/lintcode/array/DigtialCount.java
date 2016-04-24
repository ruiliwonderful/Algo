package com.rui.lintcode.array;
//http://www.lintcode.com/en/problem/digit-counts/

public class DigtialCount {

	/*
	 * param k : As description. param n : As description. return: An integer
	 * denote the count of digit k in 1..n
	 */
	public int digitCounts(int k, int n) {
		if (k == n)
			return 1;
		int count = 0;
		int high = 0;
		int currdig = 0;
		int low = 0;

		int factor = 1;

		while (n / factor != 0) {
			low = n - (n / factor) * factor;// 低位数字
			currdig = (n / factor) % 10;// 当前位数字
			high = n / (factor * 10);// 高位数字

			if (currdig > k) {
				if (!(high == 0 && k == 0))
					count += (high + 1) * factor;
			} else if (currdig == k) {
				count += high * factor + low + 1;
			} else {
				count += high * factor;
			}
			factor = factor * 10;

		}

		return count;
	}

	public static void main(String[] args) {
		DigtialCount dc = new DigtialCount();
		System.out.println(dc.digitCounts(0, 19));
	}

}
