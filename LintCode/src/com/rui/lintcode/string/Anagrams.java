package com.rui.lintcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
 * http://www.lintcode.com/en/problem/anagrams/#
 */

public class Anagrams {

	public List<String> anagrams(String[] strs) {
		// write your code here
		List<String> resultList = new ArrayList<String>();

		Map<String, List<String>> tmpMap = new HashMap<String, List<String>>();
		
		for (int i = 0; i < strs.length; i++) {
			String sortedStr = sortStr(strs[i]);
			if (tmpMap.containsKey(sortedStr)) {
				tmpMap.get(sortedStr).add(strs[i]);

			} else {
				List<String> tmpList = new ArrayList<String>();
				tmpList.add(strs[i]);
				tmpMap.put(sortedStr, tmpList);
			}

		}

		for (String key : tmpMap.keySet()) {
			if (tmpMap.get(key).size() > 1) {
				resultList.addAll(tmpMap.get(key));
			}
		}

		return resultList;
	}

	public String sortStr(String str) {
		int[] exsit = new int[26];
		for (int i = 0; i < str.length(); i++) {
			exsit[str.charAt(i) - 'a'] = exsit[str.charAt(i) - 'a']+1;
		}

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 26; ) {
			while (exsit[i] > 0) {
				sb.append((char) (i + 'a'));
				exsit[i]--;
			}
			i++;
		}
		return sb.toString();
	}

	public static void main(String args[]) {
		String str1="bacd";
		String str2="bcadac";
		
		Anagrams a=new Anagrams();
	//	System.out.println(a.sortStr(str1));
		System.out.println(a.sortStr(str2));

	}

}
