package com.rui.lintcode.recursionandsearch;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

	public List<String> generatePermuationRecrusive(String str) {
		List<String> result = new ArrayList<String>();
		int len = str.length();
		char[] allChar = str.toCharArray();
		boolean[] usage = new boolean[len];

		helper(result, new StringBuffer(), allChar, usage, 0, len);

		return result;
	}

	private void helper(List<String> result, StringBuffer solution,
			char[] allChar, boolean[] usage, int start, int len) {
		if (solution.length() == len) {
			result.add(solution.toString());
			// TODO: set usage back to false
			return;

		}

		for (int i = 0; i < len; i++) {
			if (!usage[i]) {
				solution.append(allChar[i]);
				usage[i] = true;
				helper(result, solution, allChar, usage, start + 1, len);
				// char lastChar=solution.charAt(solution.length()-1);
				usage[i] = false;
				solution.deleteCharAt(solution.length() - 1);
			}

		}

	}

	public static void main(String[] args) {
		Permutation p = new Permutation();

		String src = "abcd";
		System.out.println(p.generatePermuationRecrusive(src));
		System.out.println(p.generatePermuationRecrusive(src).size());
	}

}
