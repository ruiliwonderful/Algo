package com.rui.lintcode.string;

public class LongestCommonPrefix {

	public String longestCommonPrefix(String[] strs) {
		// write your code here

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
				if (k < strs[i].length() || strs[i].charAt(k) != c)
					return strs[0].substring(0, k);
			}
			k++;
		}

	}

}
