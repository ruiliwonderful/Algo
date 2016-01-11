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

	public static void main(String args[]) {
		Combination comb = new Combination();
		System.out.println(comb.combine(4, 2));

	}

}
