package com.rui.lintcode.array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public int[] twoSum(int[] numbers, int target) {
		int[] result = new int[2];
		Map<Integer, Integer> tmpMap = new HashMap<Integer, Integer>();

		for (int i = 0; i < numbers.length; i++) {
			tmpMap.put(numbers[i], i);

		}
		int i = 0;
		for (; i < numbers.length; i++) {
			if (tmpMap.containsKey(target - numbers[i]))
				break;

		}

		int j = tmpMap.get(target-numbers[i]);

		if (i > j) {
			result[0] = j + 1;
			result[1] = i+ 1;
		} else {
			result[0] = i + 1;
			result[1] = j + 1;
		}

		return result;


	}

}
