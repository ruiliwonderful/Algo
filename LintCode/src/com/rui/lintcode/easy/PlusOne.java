package com.rui.lintcode.easy;

public class PlusOne {

	public static int[] plusOne(int[] digits) {

		// Write your code here
		int len = digits.length;
		int[] resultArr = new int[len + 1];
		if (digits.length == 0) {
			resultArr = new int[] { 1 };
			return resultArr;
		}

		boolean flag = false;

		for (int j = len - 1; j >= 0; j--) {
			if (j == len - 1)
				digits[j] = digits[j] + 1;
			if (flag) {
				digits[j] = digits[j] + 1;

			}

			if (digits[j] >= 10) {
				resultArr[j + 1] = digits[j] - 10;
				flag = true;
			} else {
				resultArr[j + 1] = digits[j];
				flag = false;
			}

		}

		if (flag)
			resultArr[0] = 1;
		// trim resultArr
		if (resultArr[0] == 0) {
			int[] newresultArr = new int[len];
			for (int i = 1; i <= len; i++) {
				newresultArr[i - 1] = resultArr[i];

			}
			return newresultArr;
		}
		return resultArr;

	}

	public int climbStairs(int n) {
		// write your code here

		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		else if (n >= 3) {
			int[] result = new int[n];
			result[0] = 0;
			result[1] = 1;
			result[2] = 2;
			for (int i = 2; i <= n; i++) {
				result[i] = result[i - 1] + result[i - 2];
			}
			return result[n];
		}
		else return -1;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] digits = { 1, 0 };
		System.out.println(plusOne(digits));
	}

}
