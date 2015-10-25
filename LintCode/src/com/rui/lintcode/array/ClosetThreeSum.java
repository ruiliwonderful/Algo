package com.rui.lintcode.array;

import java.util.Arrays;

public class ClosetThreeSum {
	
public int threeSumClosest(int[] numbers ,int target) {
        
        Arrays.sort(numbers);
       
        int currentMinDiff=Integer.MAX_VALUE;
        int currentClosetSum=numbers[0]+numbers[1]+numbers[2];
        
        for(int i=0;i<=numbers.length-3;i++){
            int j=i+1;
            int k=numbers.length-1;
            if(numbers[i]==4){
            	System.out.println("start debug");
            }

			while (j < k) {
				int currentSum = numbers[i] + numbers[j] + numbers[k];
				if (Math.abs(currentSum - target) < currentMinDiff) {
					currentMinDiff = Math.abs(currentSum - target);
					currentClosetSum = currentSum;

				}

				if (currentSum > target) {
					k--;
				} else if (currentSum == target) {
					return target;
				} else
					j++;

			}

		}

		return currentClosetSum;

	}

	public static void main(String[] args) {
	 int[] numbers={-2,-3,5,-1,-4,5,-11,7,1,2,3,4,-7,-1,-2,-3,-4,-5};
	 ClosetThreeSum cts=new ClosetThreeSum();
	 cts.threeSumClosest(numbers, 45);

	}

}
