package com.rui.lintcode.tree;

import java.util.ArrayList;
import java.util.List;
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
		
		if(root.left==null&&root.right==null&&root.val==value) return null;
		
		TreeNode fakePreRoot=new TreeNode(0);
		fakePreRoot.left=root;
		fakePreRoot.right=root;
		TreeNode parentNode = fakePreRoot;
		TreeNode currNode = root;
		boolean foundFlag = false;
		boolean leftFlag = false;
		while (currNode!=null) {
			if (currNode.val == value) {
				foundFlag = true;
				break;
			} else if (currNode.val < value) {// go right
				parentNode = currNode;
				currNode = currNode.right;
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
}
