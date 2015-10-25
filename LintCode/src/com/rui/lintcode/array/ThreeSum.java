package com.rui.lintcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//http://www.lintcode.com/en/problem/3-sum/#
public class ThreeSum {
	public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		Arrays.sort(numbers);

		for (int i = numbers.length - 1; i >= 0; i--) {

			ArrayList<ArrayList<Integer>> tmpTwoSumResult = twoSum(numbers, 0,
					i - 1, 0 - numbers[i]);
			for (ArrayList<Integer> oneCombo : tmpTwoSumResult) {
				oneCombo.add(numbers[i]);
			}
			result.addAll(tmpTwoSumResult);
		}

		// remove duplicate from
		result = removeDuplidate(result);
		System.out.println(result.size());
		return result;

	}

	/*
	 * Given a sorted a array, find all the combination which has 2 elements sum
	 * up to target.
	 */
	public ArrayList<ArrayList<Integer>> twoSum(int[] numbers, int start,
			int end, int target) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		while (start < end) {
			int sum = numbers[start] + numbers[end];
			if (sum == target) {
				ArrayList<Integer> oneCommbo = new ArrayList<Integer>();
				oneCommbo.add(numbers[start]);
				oneCommbo.add(numbers[end]);
				result.add(oneCommbo);
				start++;
				end--;

			} else if (sum < target) {
				start++;
			} else
				end--;
		}

		return result;

	}

	public ArrayList<ArrayList<Integer>> removeDuplidate(
			ArrayList<ArrayList<Integer>> list) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		Set<ArrayList<Integer>> tmpSet = new HashSet<ArrayList<Integer>>();
		for (ArrayList<Integer> tmparr : list) {
			if (!tmpSet.contains(tmparr)) {
				tmpSet.add(tmparr);
				result.add(tmparr);
			}
		}

		return result;

	}

	/*
	 * Given a sorted array return a array without duplicate
	 */
	public int[] removeDuplidate(int[] nums) {
		int len = nums.length;
		int i = 0;
		int j = 1;
		while (j < len) {
			if (nums[i] == nums[j])
				j++;
			else {
				nums[i + 1] = nums[j];
				i++;
				j++;
			}
		}

		// the new array size should be i+1;
		int[] result = new int[i + 1];
		for (int k = 0; k < i + 1; k++) {
			result[k] = nums[k];
		}
		return result;

	}
	
	
	

	public static void main(String args[]) {
		int[] nums = { -2, -3, 5, -1, -4, 5, -11, 7, 1, 2, 3, 4, -7, -1, -2,
				-3, -4, -5 };
		ThreeSum threeSum = new ThreeSum();
		threeSum.threeSum(nums);

	}

}
