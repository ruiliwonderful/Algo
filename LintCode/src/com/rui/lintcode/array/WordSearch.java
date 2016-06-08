package com.rui.lintcode.array;

import java.util.ArrayList;

public class WordSearch {

	// http://www.lintcode.com/en/problem/word-search/
	/**
	 * @param board
	 *            : A list of lists of character
	 * @param word
	 *            : A string
	 * @return: A boolean
	 */
	public boolean exist(char[][] board, String word) {

		int m = board.length;
		int n = board[0].length;
		char[] wordarr = word.toCharArray();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				boolean[][] visited = new boolean[m][n];

				if (search(board, i, j, wordarr, 0, visited))
					return true;
			}
		}

		return false;
	}

	private boolean search(char[][] board, int i, int j, char[] arr, int start,
			boolean[][] visited) {
		int m = board.length;
		int n = board[0].length;

		// should before check boundary;
		if (start == arr.length)
			return true;

		if (i < 0 || j < 0 || i >= m || j >= n || visited[i][j])
			return false;

		if (board[i][j] == arr[start]) {
			visited[i][j] = true;
			boolean result = search(board, i + 1, j, arr, start + 1, visited)
					|| search(board, i, j + 1, arr, start + 1, visited)
					|| search(board, i - 1, j, arr, start + 1, visited)
					|| search(board, i, j - 1, arr, start + 1, visited);

			visited[i][j] = false;
			return result;
		} else
			return false;

	}
	
	//http://www.lintcode.com/en/problem/word-search-ii/
	  /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
    	return null;
    }	
	
	
	

}
