package com.rui.lintcode.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {

	public static String largestNumber(int[] num) {

		// write your code here
		List<String> allNumbers = new ArrayList<String>();
		for (int i : num) {
			allNumbers.add(Integer.toString(i));
		}

		Collections.sort(allNumbers, new Comparator<String>() {

			public int compare(String o1, String o2) {
				char[] arr1 = o1.toString().toCharArray();
				char[] arr2 = o2.toString().toCharArray();

				int len1 = arr1.length;
				int len2 = arr2.length;
				int i = 0;
				while (i < len1 && i < len2) {
					if (arr1[i] > arr2[i])
						return 1;
					else if (arr1[i] == arr2[i])
						i++;
					else
						return -1;
				}

				if (len1 > len2) {
					if (arr1[i] > arr1[0])
						return 1;
					else
						return -1;
				}

				if (len1 < len2) {
					if (arr2[i] > arr2[0])
						return -1;
					else
						return 1;
				}

				return 0;

			}

		});

		StringBuffer sb = new StringBuffer();
		boolean flag = false;
		for (int i = allNumbers.size() - 1; i >= 0; i--) {
			if (i == 0)
				flag = true;
			// DO not append 0 before we reach 0 zero
			if (!flag && allNumbers.get(i).equals("0")) {
				// do nothing
			} else {

				flag = true;
				sb.append(allNumbers.get(i));

			}
		}

		return sb.toString();

	}

	public static void main(String args[]) {
		int[] numbers = { 38, 3 };

		System.out.println(largestNumber(numbers));

	}
}
