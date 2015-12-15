package com.rui.lintcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {
	 public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
	        
	        if (root==null) return null;
	        
	        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
	        
	        Queue<TreeNode> allNodesQueue=new LinkedList<TreeNode>();
	       
	        allNodesQueue.add(root);
	        allNodesQueue.add(new TreeNode(Integer.MAX_VALUE));
	        
	         ArrayList<Integer> currLayer=new  ArrayList<Integer>();;
	         
	        while(!allNodesQueue.isEmpty()){
	            TreeNode currTreeNode= allNodesQueue.poll();
	           
	            if(currTreeNode.val==Integer.MAX_VALUE) {
	                if(currLayer!=null) result.add(currLayer);
	               currLayer=new  ArrayList<Integer>();
	               if(!allNodesQueue.isEmpty()) allNodesQueue.add(new TreeNode(Integer.MAX_VALUE));
	            
	        }
	        else {
	        	if(!allNodesQueue.isEmpty()){
	            currLayer.add(currTreeNode.val);
	            if(currTreeNode.left!=null)  allNodesQueue.add(currTreeNode.left);
	            if(currTreeNode.right!=null) allNodesQueue.add(currTreeNode.right);
	        }}
	        
	        
	    }
	    
	    return result;
	    
	    
	}
	 
	 
	 public static void main(String args[]){
		 TreeNode root=new TreeNode(1);
		 TreeNode left=new TreeNode(2);
		 TreeNode right=new TreeNode(3);
		 root.left=left;
		 root.right=right;
		 LevelOrder levelorder=new LevelOrder(); 
		 levelorder.levelOrder(root);
		 
		 
		 
	 }

}
