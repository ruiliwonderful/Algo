package com.rui.lintcode.recursionandsearch;

import java.util.ArrayList;
import java.util.List;

public class NumsRecursion {
	
	
	/**
     * @param n: An integer.
     * return : An array storing 1 to the largest number with n digits.
     */
    public  List<Integer> numbersByRecursion(int n) {
        List<Integer> result=new ArrayList<Integer>();
        if(n==0) return result;
        if(n==1){
            for(int i=1;i<10;i++){
                result.add(i);
            }
            return result;
        }
        
        List<Integer> previousResult=numbersByRecursion(n-1);
        result.addAll(previousResult);
        for(int i=1;i<10;i++){
            int base=(int) (i*(Math.pow(10, n-1)));
            result.add(base);
            for(Integer element: previousResult){
                result.add(element+base);
            }
        }
        
        return result;
        
    }

	public static void main(String[] args) {
		NumsRecursion nr=new NumsRecursion();
		nr.numbersByRecursion(2);
	}

}
