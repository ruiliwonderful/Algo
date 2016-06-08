package com.rui.lintcode.segmentTree;

class SegmentTreeNode{
	public int start, end, max;
	public SegmentTreeNode left, right;

	public SegmentTreeNode(int start, int end, int max) {
		this.start = start;
		this.end = end;
		this.max = max;
		this.left = this.right = null;
	}
}
public class SegmentTree {

	public SegmentTreeNode build(int[] A) {
		int len = A.length;
		if (len == 0)
			return null;

		SegmentTreeNode root = buildSegTreeNode(A, 0, len - 1);
		return root;
	}

	private SegmentTreeNode buildSegTreeNode(int[] A, int start, int end) {
		if (start <= end) {
			SegmentTreeNode root = new SegmentTreeNode(start, end, Integer.MAX_VALUE);
			if (start == end)
				root.max = A[start];
			int leftright = (start + end) / 2;

			if (start <= leftright && leftright < end) {
				root.left = buildSegTreeNode(A, start, leftright);
			}
			int rightleft = leftright + 1;
			if (start < rightleft && end >= rightleft) {
				root.right = buildSegTreeNode(A, rightleft, end);
			}
			if (root.max == Integer.MAX_VALUE) {
				if (root.left != null && root.right != null)
					root.max = Math.max(root.left.max, root.right.max);
				if (root.left == null && root.right != null)
					root.max = root.right.max;
				if (root.left != null && root.right == null)
					root.max = root.left.max;

			}
			return root;
		} else
			return null;

	}
	
	//http://www.lintcode.com/en/problem/segment-tree-query/
	public int query(SegmentTreeNode root, int start, int end) {
        if(start==root.start && end==root.end){
            return root.max;
        }
        if(start>=root.start && end<=root.end){
            //if in the left side
            if(root.left!=null && start>=root.left.start && end<= root.left.end){
                return query(root.left,start,end);
            }
            //if in the right side
             if(root.right!=null && start>=root.right.start && end<= root.right.end){
                return query(root.right,start,end);
            }
            //if in both side
            if(root.left!=null && root.right!=null&& start>=root.left.start && end> root.left.end &&end<=root.right.end){
                int leftmax=query(root.left,start,root.left.end);
                int rightmax=query(root.right, root.right.start,end);
                return Math.max(leftmax,rightmax);
            }
            return 0;
        }
        
    return 0;
    }
	
	public static void main(String args[]){
		SegmentTree sg=new SegmentTree();
		int[] arr={1,4,2,3};
		SegmentTreeNode root=sg.build(arr);
		sg.query(root, 1, 2);
		
	}
}
