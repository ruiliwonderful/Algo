package com.rui.lintcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestDistance {
	
	 public int shortestDistance(String[] words, String word1, String word2) {
	        int index1=Integer.MAX_VALUE;
	        int index2=Integer.MAX_VALUE;
	        int currMinDis=Integer.MAX_VALUE;
	        boolean found1=false;
	        boolean found2=false;
	        
	        for(int i=0;i<words.length;i++){
	            if(words[i].equals(word1)){
	                index1=i;
	                found1=true;
	            }
	            if(words[i].equals(word2)){
	                index2=i;
	                found2=true;
	            }
	            
	            if(found1 && found2)
	            currMinDis=Math.min(currMinDis, Math.abs(index1-index2));
	        }
	        
	        return currMinDis;
	        
	        
	    }
	 
	  class WordDistance {
		    
		    private Map<String,List<Integer>> mymap=new HashMap<String,List<Integer>>();
		    

		    public WordDistance(String[] words) {
		        for(int i=0;i<words.length;i++){
		            if(mymap.containsKey(words[i])){
		            	mymap.get(words[i]).add(i);
		            }
		            else{
		            	List<Integer> indexArr=new ArrayList<Integer>();
		            	indexArr.add(i);
		            	mymap.put(words[i], indexArr);
		            }
		        }
		        
		    }

		    private int shortestDistance(List<Integer> l1, List<Integer> l2){
		    	int minDist=Integer.MAX_VALUE;
		    	int i=0;
		    	int j=0;
		    	
		    	while(i<l1.size()&&j<l2.size()){
		    		
		    	}
		    	
		    	return minDist;
		    	
		    }
		    public int shortest(String word1, String word2) {
		    	List<Integer> l1=mymap.get(word1);
		    	List<Integer> l2=mymap.get(word2);
		    	return shortestDistance(l1,l2);
		        
		    }
		}
	 
	 
	 

	public static void main(String[] args) {
		String[] words={"practice"
		                 ,"makes"
		                 ,"perfect"
		                 ,"coding"
		                 ,"makes"};
		
		ShortestDistance sd=new ShortestDistance();
		System.out.println(	sd.shortestDistance(words, "makes", "coding"));
	}

}
