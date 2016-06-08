package com.rui.lintcode.dp;

public class DistinctSeq {

	//http://www.lintcode.com/en/problem/distinct-subsequences/
	//how many T in S
	 public int numDistinct(String S, String T) {
	        int len2=S.length();
	        int len1=T.length();
	        
	        if(len1==0||len2==0) return 1;
	        
	        int[][] arr=new int[len1+1][len2+1];
	        
	        for(int i=0;i<=len2;i++){
	            arr[0][i]=1;
	        }
	        
	        for(int j=1;j<=len1;j++){
	            arr[j][0]=0;
	        }
	        
	        for(int i=1;i<=len1;i++)
	        {
	        	for(int j=1;j<=len2;j++) {
	                char t=T.charAt(i-1);
	                char s=S.charAt(j-1);
	                
	                if(t==s){
	                    arr[i][j]=arr[i-1][j-1]+arr[i][j-1];
	                }
	                else
	                    arr[i][j]=arr[i][j-1];
	            }
	        }
	        
	       for(int i=0;i<=len1;i++){
	    	   for(int j=0;j<=len2;j++){
	    		   System.out.print(arr[i][j]);
	    		   System.out.print(" ");
	    	   }
	    	   System.out.println();
	       }

	       return arr[len1][len2]; 
	    }
	
	
	public static void main(String[] args) {
		DistinctSeq dq=new DistinctSeq();
		System.out.println(dq.numDistinct("ddd","dd"));;
	}

}
