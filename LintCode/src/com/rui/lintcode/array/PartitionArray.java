package com.rui.lintcode.array;

//http://www.lintcode.com/en/problem/partition-array/
public class PartitionArray {

	public int partitionArray(int[] nums, int k) {

		int len = nums.length;

		int start = 0;
		int end = len - 1;
		while (start < end) {
			//need start<len because the case all <k
			while (start < len && nums[start] < k)
				start++;
			//need end>0 for case all > k
			while (end > 0 && nums[end] >= k)
				end--;
			//need condition check for make sure it's still swippable 
			if (start <= len - 1 && end >= 0 && start < end) {
				int tmp = nums[start];

				nums[start] = nums[end];
				nums[end] = tmp;
				start++;
				end--;
			}

		}

		return start;

	}

}
