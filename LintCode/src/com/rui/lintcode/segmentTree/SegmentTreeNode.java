package com.rui.lintcode.segmentTree;

public class SegmentTreeNode {
	public int start, end, max;
	public SegmentTreeNode left, right;

	public SegmentTreeNode(int start, int end, int max) {
		this.start = start;
		this.end = end;
		this.max = max;
		this.left = this.right = null;
	}

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
}
