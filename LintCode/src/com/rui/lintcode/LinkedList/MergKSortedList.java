package com.rui.lintcode.LinkedList;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MergKSortedList {

	public static ListNode mergeTwoSortedList(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		ListNode head = null;
		ListNode p1 = l1;
		ListNode p2 = l2;
		ListNode currNode;
		
		
		if (l1.val > l2.val) {
			head = l2;
			p2 = p2.next;
		} else {
			head = l1;
			p1 = p1.next;
		}
		currNode = head;
		while (p1 != null && p2 != null) {
			if (p1.val > p2.val) {
				currNode.next = p2;
				p2 = p2.next;

			} else {
				currNode.next = p1;
				p1 = p1.next;
			}
			currNode = currNode.next;
		}

		if (p1 != null)
			currNode.next = p1;
		if (p2 != null)
			currNode.next = p2;

		return head;

	}
	
	public static ListNode mergeKSortedList(List<ListNode> lists){
		
		Queue<ListNode> sortedListQueue=new LinkedList<ListNode>();
		for(ListNode listNode:lists){
    	    if(listNode!=null) sortedListQueue.add(listNode);
    	}
		while(!sortedListQueue.isEmpty()){
			ListNode l1=sortedListQueue.poll();
			if(sortedListQueue.peek()==null)
			return l1;
			else{
				ListNode l2=sortedListQueue.poll();
				ListNode mergedList=mergeTwoSortedList(l1,l2);
				sortedListQueue.add(mergedList);
			}
			
			
		}
		
		return null;
		
	}

}
