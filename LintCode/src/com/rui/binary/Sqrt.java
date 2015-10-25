package com.rui.binary;

public class Sqrt {
	public static int calcSqrt(int x){
		
		       if(x<=0) return 0;
		       
		       int i=0;
		       int j=x/2+1;
		       
		       while(i<j){
		         int mid=(i+j)/2;
		         long res=mid*mid;
		          if(mid*mid==x) return mid;
		         else if(mid*mid<x){
		              i=mid+1;
		          }
		          else j=mid-1;
		       }
		       return j;
		       
		 
	}
	
	public static void main(String args[]){
		int x=999999999;
		System.out.println(calcSqrt(x));
		
	}

}
