package com.rui.lintcode.array;

public class ReverseString {
	
	/**
     * @param s : A string
     * @return : A string
     */
    public String reverseWords(String s) {
        // write your code
        char[] arr=s.toCharArray();
        int newlen=removeExtraSpace(arr);
        if(newlen==0) return "";
        reverse(arr,0,newlen-1);
        //reverse each words
        int i=0;
        while(i<newlen){
        	int p=i;
        	while(p<newlen&&arr[p]!=' ') p++;
        	reverse(arr,i,p-1);
        	i=p+1;
        }
        
        
        return new String(arr,0,newlen);
    }
    
    private void reverse(char[] arr, int start, int end){
    	while(start<end){
    		char c=arr[start];
    		arr[start]=arr[end];
    		arr[end]=c;
    		start++;
    		end--;
    	}
    }
    
    //This function will remove 
    private int removeExtraSpace(char[] arr){
    	int len=arr.length;
    	int newLen=0;
    	int i=0;
    	int j=0;
    	while(i<len&&arr[i]==' ') i++;
    	if(i==len) return 0;
    	
    	boolean meetspace=false;
    	for(;i<len;i++){
    		if(arr[i]!=' ' || (arr[i]== ' '&& !meetspace)){
    			arr[j]=arr[i];
    			j++;
    		}
    		if(arr[i]==' ' ){
    			meetspace=true;
    		}
    		if(arr[i]!=' '&& meetspace){
    			meetspace=false;
    		}
    	}
    	
    	if(arr[j-1]==' ') newLen=j-1;
    	else newLen=j;
  
    	for(int k=newLen;k<len;k++){
    		arr[k]=' ';
    	}
    	
    	return newLen;
    }

	public static void main(String[] args) {
		String s1="   I  love you   ";
		String s2="I love you   ";

		String s3="I love you ";

		String s4=" I love you ";

		
		ReverseString rs=new ReverseString();
		System.out.println(rs.removeExtraSpace(s1.toCharArray()));
		System.out.println(rs.removeExtraSpace(s2.toCharArray()));
		System.out.println(rs.removeExtraSpace(s3.toCharArray()));
		System.out.println(rs.removeExtraSpace(s4.toCharArray()));
		
		System.out.println(rs.reverseWords(s1));
		System.out.println(rs.reverseWords(s2));
		System.out.println(rs.reverseWords(s3));
		System.out.println(rs.reverseWords(s4));
	//	System.out.println(rs.reverseWords("hello"));
		System.out.println(rs.reverseWords("   "));

		
		

	}

}
