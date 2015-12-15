package com.rui.basic.sorting;

import java.util.Arrays;

public class Sort {

	public static int[] bubbleSort(int[] arr) {
		int len = arr.length;

		for (int i = 0; i < len; i++) {
			for (int j = 1; j < len - i; j++) {
				if (arr[j - 1] > arr[j]) {
					int tmp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = tmp;
				}
			}

		}

		return arr;
	}

	// 数据移动最少
	public static int[] selectSort(int[] arr) {
		int len = arr.length;

		for (int i = 0; i < len - 1; i++) {
			for (int j = i + 1; j < len; j++) {
				if (arr[j] < arr[i]) {
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
			System.out.println(Arrays.toString(arr));

		}
		return arr;
	}

	public static int[] insertSort(int[] arr) {
		int len = arr.length;
		for (int i = 1; i < len; i++) {
			int index = i;
			int value = arr[i];
			while (index > 0 && arr[index - 1] > value) {
				arr[index] = arr[index - 1];
				index--;
			}
			arr[index] = value;
			System.out.println(Arrays.toString(arr));

		}

		return arr;
	}

	public static int[] mergeSort(int[] arr) {
		int len = arr.length;
		mergeSort(arr, 0, len - 1);
		return arr;
	}

	private static void mergeSort(int[] arr, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(arr, start, mid);
			mergeSort(arr, mid + 1, end);
			merge(arr, start, mid, end);
			System.out.println(Arrays.toString(arr));
		}
	}

	private static void merge(int[] arr, int start, int mid, int end) {
		int[] helper = new int[end-start+1];

		for (int p = start; p < end; p++) {
			helper[p-start] = arr[p];
		}
		int k = 0;
		int i = start;// index for 1st half
		int j = mid + 1;// index for 2nd half

		while (i <= mid && j <= end) {
			if (arr[i] < arr[j]) {
				helper[k] = arr[i];
				i++;
			} else {
				helper[k] = arr[j];
				j++;
			}
			k++;
		}

		while (i <= mid) {
			helper[k] = arr[i];
			k++;
			i++;
		}

		while (j <= end) {
			helper[k] = arr[j];
			k++;
			j++;
		}
		
		//use helper to overwrite arr
		for(int p=start;p<end;p++){
			arr[p]=helper[p-start];
		}

	}

	public static int[] quickSort(int[] arr) {
		int len = arr.length;
		quickSort(arr, 0, len - 1);
		return arr;
	}

	private static void quickSort(int[] arr, int start, int end) {
		if (start >= end)
			return;
		int pivot = arr[start];
		int i = start + 1;
		int j = end;
		while (i <= j) {
			while (i <= end && arr[i] < pivot)
				i++;
			while (j >= start && arr[j] > pivot)
				j--;
			// swap

			if (i <= j) {
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
				j--;
			} else
				break;
		}
		// swap pivot
		int tmp = arr[j];
		arr[j] = arr[start];
		arr[start] = tmp;
		quickSort(arr, start, j - 1);
		quickSort(arr, j + 1, end);

	}

	public static void main(String args[]) {
		int[] unsortedList = { 6, 5, 3, 1, 3, 8, 7, 2, 4 };
		// System.out.println(Arrays.toString(bubbleSort(unsortedList)));
		// System.out.println(Arrays.toString(selectSort(unsortedList)));
		// System.out.println(Arrays.toString(insertSort(unsortedList)));
		 System.out.println(Arrays.toString(mergeSort(unsortedList)));
		// System.out.println(Arrays.toString(quickSort(unsortedList)));

	}

}
