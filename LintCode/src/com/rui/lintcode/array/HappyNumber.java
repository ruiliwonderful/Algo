package com.rui.lintcode.array;

import java.util.HashSet;

public class HappyNumber {

	public static boolean isHappy(int n) {
		System.out.println(n);
		HashSet<Integer> set = new HashSet<Integer>();

		while (true) {
			int m = 0;
			while (n > 0) {
			
				m = m + ((n % 10) * (n % 10));
				n = n / 10;
			}
			if (m == 1)
				return true;
			if (set.contains(m))
				return false;
			else {
				set.add(m);
				n = m;
			}

		}

	}

	public static void main(String[] args) {
	System.out.println(	isHappy(1));

	}

}
