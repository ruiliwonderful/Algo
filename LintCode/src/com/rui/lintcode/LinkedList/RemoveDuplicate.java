package com.rui.lintcode.LinkedList;

public class RemoveDuplicate {
	
	 /**
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of the linked list
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if(head==null) return head;
        ListNode fakeHead=new ListNode(0);
        fakeHead.next=head;
        ListNode pre=head;
        ListNode curr=head.next;
        while(curr!=null){
            if(pre.val==curr.val){
                pre.next=curr.next;
                
            }
            else{
            	pre=curr;
            }
            curr=curr.next;
            
        }
        return fakeHead.next;
    }

	public static void main(String[] args) {
		ListNode l0=new ListNode(1);
		ListNode l1=new ListNode(1);
		ListNode l2=new ListNode(2);
		ListNode l3=new ListNode(3);
		ListNode l4=new ListNode(3);
		l0.next=l1;
		l1.next=l2;
		l2.next=l3;
		l3.next=l4;
		
		RemoveDuplicate rd=new RemoveDuplicate();
		ListNode head=rd.deleteDuplicates(l0);
		ListNode curr=head;
		while(curr!=null){
			System.out.println(curr.val);
			curr=curr.next;
		}
		
		

	}

}
