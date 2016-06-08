package com.rui.lintcode.recursionandsearch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutation {

	public List<String> generatePermuationRecrusive(String str) {
		List<String> result = new ArrayList<String>();
		int len = str.length();
		char[] allChar = str.toCharArray();
		boolean[] usage = new boolean[len];

		//helper(result, new StringBuffer(), allChar, usage, 0, len);
		helper2(result, new StringBuffer(), allChar, usage, len);
		return result;
	}

	
	private void helper(List<String> result, StringBuffer solution,
			char[] allChar, boolean[] usage, int len) {
		if (solution.length() == len) {
			result.add(solution.toString());
			// TODO: set usage back to false
			return;

		}

		for (int i = 0; i < len; i++) {
			if (!usage[i]) {
				solution.append(allChar[i]);
				usage[i] = true;
				helper(result, solution, allChar, usage, len);
				usage[i] = false;
				solution.deleteCharAt(solution.length() - 1);
			}

		}

	}
	
	/*
	 * This version will handle the duplicate 
	 */
	private void helper2(List<String> result, StringBuffer solution,
			char[] allChar, boolean[] usage, int len) {
		if (solution.length() == len) {
			result.add(solution.toString());
			// TODO: set usage back to false
			return;

		}

		for (int i = 0; i < len; i++) {
			if(usage[i]) continue;
            if(i>0 && allChar[i]==allChar[i-1] && !usage[i-1]) continue;
			
				
				solution.append(allChar[i]);
				usage[i] = true;
				helper(result, solution, allChar, usage, len);
				usage[i] = false;
				solution.deleteCharAt(solution.length() - 1);
		}

		

	}
	
	//http://www.lintcode.com/en/problem/next-permutation/
	//http://www.lintcode.com/en/problem/next-permutation-ii/
	 public int[] nextPermutation(int[] nums) {
	     
	        //handle sepecial case: already sort
	        if(sortedArr(nums)){
	            reverse(nums,0,nums.length-1);
	            return nums;
	        }
	        
	        //find the 1st
	        int i=nums.length-1;
	        for(;i>1;i--){
	            if(nums[i]>nums[i-1]) break;
	        }
	        // //find min value which is bigger than nums[i-1]
	        int j=nums.length-1;
	        for(;j>0;j--){
	            if(nums[j]>nums[i-1]) break;
	        }
	        
	        int tmp=nums[j];
	        nums[j]=nums[i-1];
	        nums[i-1]=tmp;

	        reverse(nums,i,nums.length-1);
	        return nums;
	    }
	    
	    private boolean sortedArr(int[] nums){
	        if(nums.length<=2) return true;
	         if(nums[0]>nums[1]){
	               for(int i=2;i<nums.length;i++){
	                if(nums[i-1]<nums[i]) return false;
	            }
	            return true;
	        }
	        else return false;
	        
	    }
	    
	    private void reverse(int[] nums,int start,int end){
	        while(start<end){
	            int tmp=nums[start];
	            nums[start]=nums[end];
	            nums[end]=tmp;
	            start++;
	            end--;
	        }
	    }
	

	public static void main(String[] args) {
		Permutation p = new Permutation();

		String src = "baa";
		System.out.println(p.generatePermuationRecrusive(src));
		System.out.println(p.generatePermuationRecrusive(src).size());
		Set<String> myset=new HashSet<String>();
		for(String str:p.generatePermuationRecrusive(src)){
			myset.add(str);
		}
		System.out.println(myset.size());
	}

}
