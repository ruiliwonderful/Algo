package com.rui.basic.sorting;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Medium {
	
	
	  /**
	   * 
	   * http://www.lintcode.com/en/problem/data-stream-median/
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
    public int[] median(int[] nums) {
        int len=nums.length;
        int[] result=new int[len];
        
        
         class PQsort implements Comparator<Integer> {
        	 
    		public int compare(Integer one, Integer two) {
    			return two - one;
    		}
    	}
        
        PriorityQueue<Integer> minHeap=new PriorityQueue<Integer>();
       // PriorityQueue<Integer> maxHeap=new PriorityQueue<Integer>(Collections.reverseOrder());
        PriorityQueue<Integer> maxHeap=new PriorityQueue<Integer>(11,new PQsort());
        
        for(int i=0;i<len;i++){
        	if(maxHeap.size()!=0&&nums[i]>maxHeap.peek()){
        		minHeap.add(nums[i]);
        	}
        	else maxHeap.add(nums[i]);
        	
        	if(minHeap.size()>maxHeap.size()+1){
        		maxHeap.add(minHeap.poll());
        	}
        	
        	if(maxHeap.size()>minHeap.size()+1){
        		minHeap.add(maxHeap.poll());
        	}
        	
        	result[i]=maxHeap.size()>=minHeap.size()?maxHeap.peek():minHeap.peek();
        	
        }
               
        return result;
    }

	public static void main(String[] args) {
		Medium m=new Medium();
		int[] arr1={1, 2, 3, 4, 5};
		int[] result1=m.median(arr1);
		for(int i=0;i<result1.length;i++){
			System.out.println(result1[i]);
		}
		
		
	}

}
