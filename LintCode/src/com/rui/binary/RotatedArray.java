package com.rui.binary;

public class RotatedArray {
	
	//http://www.lintcode.com/en/problem/search-in-rotated-sorted-array/#
	public int search(int[] A, int target) {
        // write your code here
        int i=0;
        int j=A.length-1;
        
        while(i<=j){
            int mid=(i+j)/2;
            if(A[mid]==target) return mid;
            
            if(A[i]>A[mid]){
                //left half roated and right side in order
               
               if(A[mid]<target&&target<A[j]){
                    // case for search on right
                   i=mid+1;
               }
               else j=mid-1;
            }
            
           else  if(A[mid]>A[j]){
                //right half rotated and left side in order
                if(A[i]<target&&target<A[mid]) {
                    //case for search in left side 
                    j=mid-1;
                }
                else i=mid+1;
            }
            else{
                //no rotate
                if(A[mid]<target) i=mid+1;
                else j=mid-1;
            }
            
            
        }
        
        return -1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
