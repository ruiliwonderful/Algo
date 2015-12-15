package com.rui.binary;

public class Sqrt {
	public static int calcSqrt(int x) {

		long start = 1, end = x;
		while (start + 1 < end) {
			long mid = start + (end - start) / 2;
			if (mid * mid <= x) {
				start = mid;
			} else {
				end = mid;
			}
		}

		if (end * end <= x) {
			return (int) end;
		}
		return (int) start;

	}

	public static void main(String args[]) {
		int x = 999999999;
		System.out.println(calcSqrt(x));
		System.out.println(Integer.toBinaryString(14&31));
		System.out.println(Integer.toBinaryString(32));

	}
	
	
	public int uniquePaths(int m, int n) {
        // write your code here
        int[] dp=new int[m];
        
        for(int i=1;i<m;i++){
            dp[i]=dp[i-1]+dp[i];
        }
        
        return dp[m-1];
        
    }

}
