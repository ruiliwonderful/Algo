package com.rui.lintcode.recursionandsearch;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

	/**
	 * http://www.lintcode.com/en/problem/combination-sum/Ø
	 * 
	 * @param candidates
	 *            : A list of integers
	 * @param target
	 *            :An integer
	 * @return: A list of lists of integers
	 */
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		List<Integer> solution = new ArrayList<Integer>();
		//TODO: As we can reuse elements, we need to clear duplidate before process.
		
		// process(candidates, target, result, solution, 0);
		process2(candidates, target, result, solution, 0);
		return result;
	}

	private void process(int[] candidates, int target,
			List<List<Integer>> result, List<Integer> solution, int start) {
		if (target == 0) {
			result.add(new ArrayList<Integer>(solution));

			return;
		}

		int prev = -1;

		for (int i = start; i < candidates.length; i++) {

			if (candidates[i] > target)
				break;
			if (prev != -1 && prev == candidates[i]) {
				continue;
			}

			solution.add(candidates[i]);
			process(candidates, target - candidates[i], result, solution, i);
			solution.remove(solution.size() - 1);

			prev = candidates[i];

		}

	}

	private void process2(int[] candidates, int target,
			List<List<Integer>> result, List<Integer> solution, int start) {
		if (target == 0) {
			result.add(new ArrayList<Integer>(solution));

			return;
		} else if (target < 0)
			return;

		for (int i = start; i < candidates.length; i++) {

			solution.add(candidates[i]);
			process(candidates, target - candidates[i], result, solution, i);
			solution.remove(solution.size() - 1);

			// prev = candidates[i];

		}

	}

	// for the scenario that only allow to use element once
	public List<List<Integer>> combinationSumWithNoDuplicate(int[] candidates,
			int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		List<Integer> solution = new ArrayList<Integer>();
		// process(candidates, target, result, solution, 0);
		processNoDuplciate(candidates, target, result, solution, 0);
		return result;
	}

	private void processNoDuplciate(int[] candidates, int target,
			List<List<Integer>> result, List<Integer> solution, int start) {
		if (target == 0) {
			result.add(new ArrayList<Integer>(solution));

			return;
		} else if (target < 0)
			return;

		for (int i = start; i < candidates.length; i++) {

			solution.add(candidates[i]);
			
			process(candidates, target - candidates[i], result, solution, i+1);
			solution.remove(solution.size() - 1);
			while (i < candidates.length - 1
					&& candidates[i] == candidates[i + 1])
				// we add this while loop is to skip the duplication result
				++i;
			

		}

	}
	
	

	public static void main(String args[]) {
		CombinationSum cs = new CombinationSum();
		int[] candidates = { 2,2,2,2,2,2,2,2,2,3, 3, 4 };
		int target = 7;
		System.out.println(cs.combinationSum(candidates, target));
		System.out
				.println(cs.combinationSumWithNoDuplicate(candidates, target));
	}
}
