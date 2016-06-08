package com.rui.lintcode.recursionandsearch;

import java.util.ArrayList;
public class NQueens {

	/**
	 * Use recursion to solve N queen problem
	 * 
	 * Get all distinct N-Queen solutions
	 * 
	 * @param n
	 *            : The number of queens
	 * @return: All distinct solutions For example, A string '...Q' shows a
	 *          queen on forth position
	 */
	public ArrayList<ArrayList<String>> solveNQueens(int n) {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		helper(n, 0, new int[n], result);
		return result;
	}

	private void helper(int n, int row, int[] columnForRow,
			ArrayList<ArrayList<String>> result) {
		if (row == n) {// add current solution to result
			ArrayList<String> currentSolution = createStringFromColumnData(n,
					columnForRow);
			result.add(new ArrayList<String>(currentSolution));
			return;
		}

		for (int i = 0; i < n; i++) {
			columnForRow[row] = i;
			if (checkStatus(row, columnForRow)) {
				helper(n, row + 1, columnForRow, result);

			}

		}
	}

	private ArrayList<String> createStringFromColumnData(int n,
			int[] columnForRow) {
		ArrayList<String> result = new ArrayList<String>();

		for (int i = 0; i < n; i++) {
			StringBuffer sb = new StringBuffer();
			for (int j = 0; j < n; j++) {
				if (columnForRow[i] == j)
					sb.append("Q");
				else
					sb.append(".");
			}
			result.add(sb.toString());
		}

		return result;
	}

	private boolean checkStatus(int row, int[] columnForRow) {
		int column = columnForRow[row];
		for (int i = 0; i < row; i++) {
			if (column == columnForRow[i])
				return false;
			if (Math.abs(column - columnForRow[i]) == Math.abs(row - i))
				return false;
		}

		return true;
	}
	
	//TODO: implement this function.
	public  ArrayList<ArrayList<String>> solveNQueensWithoutRecusion(int n) {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		
		return result;
		
	}

	public static void main(String[] args) {
		NQueens nq=new NQueens();
		ArrayList<ArrayList<String>> result=nq.solveNQueens(4);
		
		for( ArrayList<String> oneSolution:result){
			for(String oneline: oneSolution){
				System.out.println(oneline);
			}
			
			System.out.println("    ");
		}

	}

}
