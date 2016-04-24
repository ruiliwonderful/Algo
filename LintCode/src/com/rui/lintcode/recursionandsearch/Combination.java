package com.rui.lintcode.recursionandsearch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Combination {

	/**
	 * http://www.lintcode.com/en/problem/combinations/
	 * 
	 * @param n
	 *            : Given the range of numbers
	 * @param k
	 *            : Given the numbers of combinations
	 * @return: All the combinations of k numbers out of 1..n
	 */
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<List<Integer>> tmpList = new CopyOnWriteArrayList<List<Integer>>();

		for (int i = 1; i < n + 1; i++) {
			if (tmpList.size() == 0) {
				tmpList.add(new CopyOnWriteArrayList<Integer>());
				CopyOnWriteArrayList<Integer> element = new CopyOnWriteArrayList<Integer>();
				element.add(i);
				tmpList.add(element);
			} else {
				for (List<Integer> element : tmpList) {
					if (element.size() < k) {
						CopyOnWriteArrayList<Integer> newelement = new CopyOnWriteArrayList<Integer>();
						newelement.addAll(element);
						newelement.add(i);
						tmpList.add(newelement);
					}

				}
			}
		}

		for (List<Integer> turple : tmpList) {
			if (turple.size() == k)
				result.add(turple);
		}

		return result;
	}

	public ArrayList<ArrayList<Integer>> combine2(int n, int k) {
		ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> solution = new ArrayList<Integer>();

		helper(rst, solution, n, k, 1);
		return rst;
	}

	private void helper(ArrayList<ArrayList<Integer>> rst,
			ArrayList<Integer> solution, int n, int k, int start) {
		if (solution.size() == k) {
			rst.add(new ArrayList(solution));
			return;
		}

		for (int i = start; i <= n; i++) {
			solution.add(i);
			// the new start should be after the next number after i
			helper(rst, solution, n, k, i + 1);
			solution.remove(solution.size() - 1);
		}
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		// write your code here
		return combinationSum(candidates, 0, candidates.length - 1, target);
	}

	private List<List<Integer>> combinationSum(int[] candidates, int start,
			int end, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (start == end) {
			if (target % candidates[start] == 0) {
				List<Integer> tmpList = new ArrayList<Integer>();
				for (int j = target / candidates[start]; j > 0; j--) {
					tmpList.add(candidates[start]);
				}
				result.add(tmpList);
			} else {
				// do nothing
			}

		} else {
			if (candidates[end] > target)
				result = combinationSum(candidates, start, end - 1, target);
			else {
				List<List<Integer>> previousResult = combinationSum(candidates,
						start, end, target - candidates[end]);
				if (previousResult.size() > 0) {
					for (List<Integer> element : previousResult) {
						element.add(candidates[end]);
					}
					result.addAll(previousResult);
				} else {
					// do nothing.
				}

			}

		}

		return result;
	}


	public static void main(String args[]) {
		Combination comb = new Combination();
		int[] candidates = { 2, 3, 4 };
		int target = 7;
		System.out.println(comb.combine2(3, 2));

	}

}
