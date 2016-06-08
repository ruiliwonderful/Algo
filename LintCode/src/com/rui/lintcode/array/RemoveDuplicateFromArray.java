package com.rui.lintcode.array;

public class RemoveDuplicateFromArray {

	
	/*
	 * Given a sorted array, reduce the index of all unique element in the array. 
	 */
	public int removeDuplicateFromSortedArray(int[] arr) {
		if (arr.length <= 1)
			return arr.length;
		int i = 0;
		int j = 1;
		while (j < arr.length) {
			while (j < arr.length&&arr[i] == arr[j])
				j++;
			if (j < arr.length) {
				i = i + 1;
				arr[i] = arr[j];
				j++;
			}

		}
		return i;

	}
	
	 

	public static void main(String args[]) {
		RemoveDuplicateFromArray rd = new RemoveDuplicateFromArray();
		int[] arr = { 2, 2, 3, 4, 5, 5, 5, 5, 6 };
		int[] arr1 = { 1, 2 };
		int[] arr2 = { 2, 2 };

		System.out.println(rd.removeDuplicateFromSortedArray(arr));
		System.out.println(rd.removeDuplicateFromSortedArray(arr1));
		System.out.println(rd.removeDuplicateFromSortedArray(arr2));
		System.out.println(arr);

	}

}
