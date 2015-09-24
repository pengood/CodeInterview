package com.leetcode.test;
/*
 * Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?
 */
public class PalindromeLinkedList {
	 public boolean isPalindrome(ListNode head) {
	        if(head==null||head.next==null)
	        	return true;
	        ListNode fast=head;
	        ListNode slow=head;
	        ListNode pre=null;
	        while(fast.next!=null&&fast.next.next!=null){
	        	fast=fast.next.next;
	        	ListNode node=slow.next;
	        	slow.next=pre;
	        	pre=slow;
	        	slow=node;
	        }
	        //奇数个
	        if(fast.next==null){
	        	ListNode left=pre;
	        	ListNode right=slow.next;
	        	while(left!=null&&right!=null){
	        		if(left.val!=right.val)
	        			return false;
	        		left=left.next;
	        		right=right.next;
	        	}
	        	if(left!=null||right!=null)
	        		return false;
	        	return true;
	        }else {
	        	//偶数个
				if(slow.val!=slow.next.val)
					return false;
				ListNode left=pre;
				ListNode right=slow.next.next;
				while(left!=null&&right!=null){
	        		if(left.val!=right.val)
	        			return false;
	        		left=left.next;
	        		right=right.next;
	        	}
	        	if(left!=null||right!=null)
	        		return false;
	        	return true;
			}
	    }
	 public static void main(String[] args) {
		ListNode[] nodes=new ListNode[5];
		nodes[0]=new ListNode(0);
		nodes[1]=new ListNode(1);
		nodes[0].next=nodes[1];
		nodes[2]=new ListNode(1);
		nodes[1].next=nodes[2];
		nodes[3]=new ListNode(1);
		nodes[2].next=nodes[3];
		nodes[4]=new ListNode(1);
		nodes[3].next=nodes[4];
		PalindromeLinkedList linkedList=new PalindromeLinkedList();
		boolean result=linkedList.isPalindrome(nodes[0]);
		System.out.println(result);
		
	}
}
