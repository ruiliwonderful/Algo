package com.rui.lintcode.tree;

import java.util.HashMap;

class TrieNode2 {
	String s;
	boolean isString;
	HashMap<Character, TrieNode2> subTree;

	public TrieNode2() {
		isString = false;
		subTree = new HashMap<Character, TrieNode2>();
		s = "";
	}

}

public class Trie2 {

	public TrieNode2 root;

	public Trie2() {
		this.root = new TrieNode2();
	}

	public void insert(String s) {
		TrieNode2 now = root;
		for (int i = 0; i < s.length(); i++) {
			if (now.subTree.containsKey(s.charAt(i))) {
				now.subTree.put(s.charAt(i), new TrieNode2());
			}
			now = now.subTree.get(s.charAt(i));
		}
		now.s = s;
		now.isString = true;
	}

	public boolean find(String s) {
		TrieNode2 now = root;
		for (int i = 0; i < s.length(); i++) {
			if (!now.subTree.containsKey(s.charAt(i))) {
				return false;
			}
			now = now.subTree.get(s.charAt(i));
		}
		return now.isString;
	}

}
