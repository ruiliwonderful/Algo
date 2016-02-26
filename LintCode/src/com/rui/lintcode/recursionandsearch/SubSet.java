package com.rui.lintcode.recursionandsearch;

import java.util.ArrayList;
import java.util.Arrays;

public class SubSet {
	
	
	
	//http://www.lintcode.com/en/problem/subsets/
	 /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
	 public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
		  Arrays.sort(nums);
		 ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
		 ArrayList<Integer> solution=new ArrayList<Integer>();
		 result.add(solution);
		 for(int i=0;i<nums.length;i++){
			 ArrayList<ArrayList<Integer>> preSolution=new ArrayList(result);
			 ArrayList<ArrayList<Integer>> currSolution=new ArrayList<ArrayList<Integer>>();

			 for(ArrayList<Integer> element:preSolution){
				ArrayList<Integer> newelement= new ArrayList<Integer>(element);
				newelement.add(nums[i]);
				 currSolution.add(newelement);
			 }
			 result.addAll(currSolution);
		 }
		 return result;
	    }

	 //http://www.lintcode.com/en/problem/subsets-ii/
	 /**
	     * @param S: A set of numbers.
	     * @return: A list of lists. All valid subsets.
	     */
	    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
	        
	         int len=S.size();
	         int[] nums=new int[len];
	        for(int i=0;i<len;i++){
	            nums[i]=S.get(i);
	        }
			 Arrays.sort(nums);
			 ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
			 ArrayList<Integer> solution=new ArrayList<Integer>();
			 result.add(solution);
			 for(int i=0;i<nums.length;i++){
				 ArrayList<ArrayList<Integer>> preSolution=new ArrayList(result);
				 ArrayList<ArrayList<Integer>> currSolution=new ArrayList<ArrayList<Integer>>();

				 for(ArrayList<Integer> element:preSolution){
					ArrayList<Integer> newelement= new ArrayList<Integer>(element);
					newelement.add(nums[i]);
					 currSolution.add(newelement);
				 }
				 result.addAll(currSolution);
			 }
			 
			 
			 
			 
			 return result;
		    
	    }
	 
	public static void main(String[] args) {
		int[] nums={1,2,3};
		SubSet ss=new SubSet();
		System.out.println(ss.subsets(nums));
		
	}

}
