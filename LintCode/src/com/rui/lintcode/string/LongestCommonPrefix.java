package com.rui.lintcode.string;

public class LongestCommonPrefix {

	public static String longestCommonPrefix(String[] strs) {

		if (strs.length == 0)
			return "";
		if (strs.length == 1)
			return strs[0];

		int k = 0;
		while (true) {
			char c;
			if (k < strs[0].length())
				c = strs[0].charAt(k);
			else
				return strs[0].substring(0, k);

			for (int i = 1; i < strs.length; i++) {
				
				if(strs[i].length()==0) return "";

				if (k > strs[i].length()-1||strs[i].charAt(k) != c ) {
					
						return strs[0].substring(0, k);

				
				}
				
			}
			k++;

		}
	}

	public static void main(String args[]) {

		String[] strs = { "ABCFf", "ABC" };
		System.out.println(longestCommonPrefix(strs));
		

	}

}
