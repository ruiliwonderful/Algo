package com.rui.lintcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TreeTraverse {

	public List<Integer> preOrder(TreeNode root) {
		TreeNode currNode = root;
		ArrayList<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> s = new Stack<TreeNode>();

		while (true) {
			if (currNode != null) {
				result.add(currNode.val);
				s.push(currNode);
				currNode = currNode.left;
			}

			else {
				if (!s.isEmpty()) {
					currNode = s.pop();
					currNode = currNode.right;
				} else
					break;
			}
		}

		return result;

	}

	public List<Integer> inOrder(TreeNode root) {
		TreeNode currNode = root;

		ArrayList<Integer> result = new ArrayList<Integer>();

		Stack<TreeNode> s = new Stack<TreeNode>();

		while (true) {
			if (currNode != null) {

				s.push(currNode);
				currNode = currNode.left;
			}

			else {
				if (!s.isEmpty()) {
					currNode = s.pop();
					result.add(currNode.val);
					currNode = currNode.right;
				} else
					break;
			}
		}

		return result;

	}

	// TODO: implement with two stacks
	public List<Integer> postOrder(TreeNode root) {
		return null;

	}
	
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

	// http://www.lintcode.com/en/problem/construct-binary-tree-from-preorder-and-inorder-traversal/
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		TreeNode root = null;
		if (preorder.length > 0 && preorder.length == inorder.length) {
			root = buildTree(preorder, 0, preorder.length - 1, inorder, 0,
					inorder.length - 1);

		}

		return root;
	}

	private TreeNode buildTree(int[] preorder, int pstart, int pend,
			int[] inorder, int istart, int iend) {
		if (pstart < pend) {
			TreeNode node = new TreeNode(preorder[pstart]);
			// find this node in inorder
			int k;
			for (k = istart; k < iend; k++) {
				if (inorder[k] == preorder[pstart])
					break;
			}
			node.left = buildTree(preorder, pstart + 1, pstart + k - 1,
					inorder, istart, k - 1);
			node.right = buildTree(preorder, pstart + k - 1, pend, inorder,
					k + 1, istart);
			return node;

		} else
			return null;
	}

	// http://www.lintcode.com/en/problem/remove-node-in-binary-search-tree/
	public TreeNode removeNodeFromBST(TreeNode root, int value) {

		if (root.left == null && root.right == null && root.val == value)
			return null;

		TreeNode fakePreRoot = new TreeNode(0);
		fakePreRoot.left = root;
		fakePreRoot.right = root;
		TreeNode parentNode = fakePreRoot;
		TreeNode currNode = root;
		boolean foundFlag = false;
		boolean leftFlag = false;
		while (currNode!=null) {
			if (currNode.val == value) {
				foundFlag = true;
				if(root==currNode) leftFlag=true;
				break;
			} else if (currNode.val < value) {// go right
				parentNode = currNode;
				currNode = currNode.right;
				leftFlag=false;
			} else {
				parentNode = currNode;
				currNode = currNode.left;
				leftFlag = true;
			}

		}
		// case: does not found value;
		if (!foundFlag)
			return root;

		if (currNode.left == null && currNode.right == null) {
			if (leftFlag)
				parentNode.left = null;
			else
				parentNode.right = null;
		} else if (currNode.left == null && currNode.right != null) {
			if (leftFlag)
				parentNode.left = currNode.right;
			else
				parentNode.right = currNode.right;
		} else if (currNode.left != null && currNode.right == null) {
			if (leftFlag)
				parentNode.left = currNode.left;
			else
				parentNode.right = currNode.left;
		} else {
			// the node will be deleted have both left and right child
			currNode.val = findSmallestNodeInRightSubTreeWithDelete(currNode);
		}

		return fakePreRoot.left;
	}

	private int findSmallestNodeInRightSubTreeWithDelete(TreeNode root) {
		TreeNode curr = root.right;
		TreeNode parentNode = root;
		while (curr.left != null) {
			parentNode = curr;
			curr = curr.left;
		}

		if (curr.right == null) {
			parentNode.left = null;
		} else {
			parentNode.left = curr.right;
		}

		return curr.val;
	}

	// www.lintcode.com/en/problem/binary-tree-serialization/
	public String serialize(TreeNode root) {
		StringBuffer sb = new StringBuffer();
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode node = root;
		while (true) {
			if (node != null) {
				sb.append(node.val).append(",");
				s.push(node);
				node = node.left;
				if (node == null)
					sb.append("#").append(",");

			} else {
				if (!s.isEmpty()) {
					node = s.pop();
					node = node.right;
					if (node == null)
						sb.append("#").append(",");

				} else
					break;
			}
		}

		return sb.toString();
	}

	public TreeNode dederialize(String data) {
	    if (data==null||data.trim().equals("")) return null;
		String[] arr = data.split(",");
		int len = arr.length;
		TreeNode root = null;
		if (len > 0) {
			
			root = new TreeNode(Integer.parseInt(arr[0]));
			TreeNode node = root;
			Stack<TreeNode> s = new Stack<TreeNode>();
			int i = 1;
			s.push(node);
			while (i < len) {
				if (node != null) {
					if (!arr[i].equals("#")) {						
						node.left = new TreeNode(Integer.parseInt(arr[i]));
						node = node.left;
						s.push(node);
					} else
						node = null;
				}

				else {
					if(!s.isEmpty())node = s.pop();
					else break;
					if (!arr[i].equals("#")) {
						node.right = new TreeNode(Integer.parseInt(arr[i]));
						node = node.right;
						s.push(node);
					} else
						node = null;
				}
				i++;
			}

			
		}
		return root;
	}
	
	
	
	public static void main(String args[]){
		TreeTraverse tt=new TreeTraverse();
		
		TreeNode t1root=new TreeNode(5);
		TreeNode node1=new TreeNode(1);
		//TreeNode node2=new TreeNode(3);
		t1root.left=node1;
		
		tt.removeNodeFromBST(t1root, 5);
	
	}
}
