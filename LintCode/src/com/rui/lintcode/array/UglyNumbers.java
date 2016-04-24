package com.rui.lintcode.array;

public class UglyNumbers {
	
	public long nthUglyNumber(int k) {
	    
        long[] arr=new long[k];
        arr[0]=1l;
        
        int index2=0;
        int index3=0;
        int index5=0;
        
        for(int i=1;i<k;i++){
            long min=Math.min(arr[index2]*2,Math.min(arr[index3]*3,arr[index5]*5));
            if(min==arr[index2]*2 ) index2++;
            if(min==arr[index3]*3 ) index3++;
            if(min==arr[index3]*5 ) index5++;
            arr[i]=min;
        }
        return arr[k-1];
    }
	
	
	public int nthSuperUglyNumber(int n, int[] primes) {
        int[] index=new int[primes.length];
        
        int[] result=new int[n];
        result[0]=1;
        
        for(int i=1;i<n;i++){
            int min=Integer.MAX_VALUE;
            for(int j=0;j<primes.length;j++){
                min=Math.min(min,result[index[j]]*primes[j]);
            }
            
            result[i]=min;
            
             for(int j=0;j<primes.length;j++){
                if(min == result[index[j]]*primes[j]) {
                   index[j]= index[j]+1;
                }
            }
        }
        return result[n-1];
        
    }

	public static void main(String[] args) {
		UglyNumbers ug=new UglyNumbers();
		//System.out.println(ug.nthUglyNumber(9));
		int[] primes={2,3,5};
		System.out.println(ug.nthSuperUglyNumber(11, primes));
	}

}
