package com.rui.lintcode.array;

import java.util.ArrayList;

public class MinSubArray {
	
	public static int minSubArray(ArrayList<Integer> nums) {

        // write your code
          int len=nums.size();
        if(len==0) return 0;
        
        int[] dp=new int[len];
        dp[0]=nums.get(0);
        for(int i=1;i<len;i++){
            dp[i]=Math.min(dp[i-1]+nums.get(i),nums.get(i)); 
        }
        
        
        int finalMin=Integer.MAX_VALUE;
        for(int i=0;i<len;i++){
            finalMin=Math.min(finalMin,dp[i]);
        }
        
        return finalMin;
    
	}
	
	 public int minSubArray2(ArrayList<Integer> nums) {
	        // write your code
	          int len=nums.size();
	        if(len==0) return 0;
	        
	        int currMin=nums.get(0);
	        int preMin=nums.get(0);
	        for(int i=1;i<len;i++){
	             preMin=Math.min(preMin+nums.get(i),nums.get(i)); 
	            if(preMin<currMin) currMin=preMin;
	        }
	        return currMin;
	    }
	
	
	public static void main(String args[]){
		ArrayList<Integer> ll=new ArrayList<Integer>();
		ll.add(1);
		ll.add(-1);
		ll.add(-2);
		ll.add(3);
		System.out.println(minSubArray(ll));
	}

}
