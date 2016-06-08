package com.rui.lintcode.tree;

import java.util.ArrayList;

public class WordSearch {

	/**
	 * http://www.lintcode.com/en/problem/word-search-ii/#
	 * 
	 * @param board
	 *            : A list of lists of character
	 * @param words
	 *            : A list of string
	 * @return: A list of string
	 */
	public ArrayList<String> wordSearchII(char[][] board,
			ArrayList<String> words) {
		ArrayList<String> result = new ArrayList<String>();
		
		//Build trie from dictionary 
		Trie2 trie=new Trie2();
		for(String word: words){
			trie.insert(word);
		}
		
		String solution="";
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				search(board,i,j,trie.root,result,solution);
			}
		}

		return result;

	}
	
	private void search(char[][] board,int x,int y,TrieNode2 root, ArrayList<String> result, String solution){
		if(root.isString){
			if(!result.contains(root.s)){
				result.add(root.s);
			}
		}
		
        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y]==0 || root == null)
        	return ;
        if(root.subTree.containsKey(board[x][y])){
        	 int []dx = {1, 0, -1, 0};
             int []dy = {0, 1, 0, -1};
             for(int i = 0; i < 4; i++){
                 char now = board[x][y];
                 board[x][y] = 0;
                 search(board, x+dx[i], y+dy[i], root.subTree.get(now), result, solution);
                 board[x][y] = now;
             }

        }

	}
}
