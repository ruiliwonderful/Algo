package com.rui.lintcode.recursionandsearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class WordLadder {

	/**
	 * http://www.lintcode.com/en/problem/word-ladder/ Given two words (start
	 * and end), and a dictionary, find the length of shortest transformation
	 * sequence from start to end, such that:
	 * 
	 * Only one letter can be changed at a time Each intermediate word must
	 * exist in the dictionary
	 * 
	 * @param start
	 *            , a string
	 * @param end
	 *            , a string
	 * @param dict
	 *            , a set of string
	 * @return an integer
	 */
	public int ladderLength(String start, String end, Set<String> dict) {
		if (dict == null) {
			return 0;
		}

		dict.add(start);
		dict.add(end);

		HashSet<String> hash = new HashSet<String>();
		Queue<String> queue = new LinkedList<String>();
		queue.offer(start);
		hash.add(start);

		int length = 1;
		while (!queue.isEmpty()) {
			length++;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String word = queue.poll();
				for (String nextWord : getNextWords(word, dict)) {
					if (hash.contains(nextWord)) {
						continue;
					}
					if (nextWord.equals(end)) {
						return length;
					}

					hash.add(nextWord);
					queue.offer(nextWord);
				}
			}
		}
		return 0;
	}
	
	  /**
	   * 
	   * http://www.lintcode.com/en/problem/word-ladder-ii/
	   * 
     * @param start, a string
     * @param end, a string
     * @param dict, a set of string
     * @return a list of lists of string
     */
   public List<List<String>> findLadders(String start, String end, Set<String> dict) {
	   List<List<String>> result=new ArrayList<List<String>>();
	   //solution is the all possible ladders
	   List<List<String>> allLadders=new ArrayList<List<String>>();
	   List<String> solution=new ArrayList<String>();
	   

		if (dict == null) {
			return result;
		}

		dict.add(start);
		dict.add(end);

		HashSet<String> hash = new HashSet<String>();
		Stack<String> stack=new Stack<String>();
		stack.push(start);
		hash.add(start);
		
//		Queue<String> queue = new LinkedList<String>();
//		queue.offer(start);
//		hash.add(start);
//		//solution.add(start);
//
//		while (!queue.isEmpty()) {
//			solution=new ArrayList<String>();
//			int size = queue.size();
//			for (int i = 0; i < size; i++) {
//				String word = queue.poll();
//				solution.add(word);
//				for (String nextWord : getNextWords(word, dict)) {
//					if (hash.contains(nextWord)) {
//						continue;
//					}
//					if (nextWord.equals(end)) {
//						//return length;
//						allLadders.add(new ArrayList<String>(solution));
//					}
//
//					hash.add(nextWord);
//					queue.offer(nextWord);
//				}
//			}
//		}
	
		
		
	   int minLen=Integer.MAX_VALUE;
	   
	   for(List<String> element: allLadders){
		   if(element.size()<minLen) minLen=element.size();
	   }
	   
	   for(List<String> element: allLadders){
		   if(element.size()<minLen) minLen=element.size();
	   }
	   
	   
	   for(List<String> element: allLadders){
		   if(element.size()==minLen) result.add(element);
	   }
	   return result;
   }
	

	// replace character of a string at given index to a given character
	// return a new string
	private String replace(String s, int index, char c) {
		char[] chars = s.toCharArray();
		chars[index] = c;
		return new String(chars);
	}

	// get connections with given word.
	// for example, given word = 'hot', dict = {'hot', 'hit', 'hog'}
	// it will return ['hit', 'hog']
	private ArrayList<String> getNextWords(String word, Set<String> dict) {
		ArrayList<String> nextWords = new ArrayList<String>();
		for (char c = 'a'; c <= 'z'; c++) {
			for (int i = 0; i < word.length(); i++) {
				if (c == word.charAt(i)) {
					continue;
				}
				String nextWord = replace(word, i, c);
				if (dict.contains(nextWord)) {
					nextWords.add(nextWord);
				}
			}
		}
		return nextWords;
	}

	public static void main(String[] args) {
		/*
		 * Given: start = "hit" end = "cog" dict =
		 * ["hot","dot","dog","lot","log"] As one shortest transformation is
		 * "hit" -> "hot" -> "dot" -> "dog" -> "cog", return its length 5.
		 */
		
		String start="hit";
		String end="cog";
		Set<String> dict=new HashSet(Arrays.asList(new String[] {"hot","dot","dog","lot","log"}));
		WordLadder wl=new WordLadder();
		 List<List<String>> result=	wl.findLadders(start, end, dict);
		 System.out.println(result.size());
		

	}

}
