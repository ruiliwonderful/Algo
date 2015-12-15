package com.rui.basic.sorting;

import java.util.ArrayList;
import java.util.List;

/*
 * http://www.lintcode.com/en/problem/combinations/
 */
public class Combination {
	
	/**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public List<List<Integer>> combine(int n, int k) {
    	
    	List<List<Integer>> resultList=new ArrayList<List<Integer>>();
    	List<List<Integer>> tmpList=new ArrayList<List<Integer>>();

    	tmpList.add(new ArrayList<Integer>());
    	for(int i=1;i<=n;i++){
        	List<List<Integer>> tmpListinLoop=new ArrayList<List<Integer>>();        	

    		for(List<Integer> element: tmpList){
    			List<Integer> tmp=new ArrayList<Integer>();
				tmp.addAll(element);
				tmp.add(i);
				
    			if(tmp.size()==k) resultList.add(tmp);
    			else {
    				
    				tmpListinLoop.add(tmp);
    			}
    		}
    		tmpList.addAll(tmpListinLoop);
    	}
    	
    	
    	System.out.println(resultList.size());
    	return resultList;
    }

    
    public static void main(String args[]){
    	Combination c=new Combination();
    	c.combine(1, 1);
    }
}
