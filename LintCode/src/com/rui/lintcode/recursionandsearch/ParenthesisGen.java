package com.rui.lintcode.recursionandsearch;

import java.util.ArrayList;

public class ParenthesisGen {
	
	public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String>  result=new ArrayList<String>();
        char[] solutionArr=new char[2*n];
        solutionArr[0]='(';
        int nleft=n-1;
        int nright=n;
        generate(result, n,solutionArr, nleft,nright);
        
        return result;
    }
    
   private void  generate( ArrayList<String>  result, int n,char[] arr, int nleft,int nright){
        if(nleft==nright&&nleft==0){
        	System.out.println(String.valueOf(arr));
            result.add(String.valueOf(arr));
        }
        
        if(nleft>0){
            int j=findFirstEmpty(arr);
            arr[j]='(';
            generate(result, n, arr, nleft-1,nright);
            arr[j]=0;
        }
        
        if(nleft<nright){
             int j=findFirstEmpty(arr);
            arr[j]=')';
            generate(result, n, arr, nleft,nright-1);
            arr[j]=0;
        }
        
        
    }
    
    private int findFirstEmpty(char[] arr){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0) return i;
        }
        return 0;
    }
    
    public static void main(String args[]){
    	ParenthesisGen pg=new ParenthesisGen();
    	pg.generateParenthesis(3);
    }
	
	
	



}
