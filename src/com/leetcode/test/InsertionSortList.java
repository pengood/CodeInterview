package com.leetcode.test;

import java.util.Random;

/*
 * Sort a linked list using insertion sort.
 */
public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
		if(head==null||head.next==null)
			return head;
		ListNode helper=new ListNode(-1);
		ListNode current=head;
		ListNode pre=null;
		while(current!=null){
			ListNode next=current.next;
			pre=helper;
			while(pre.next!=null&&pre.next.val<current.val){
				pre=pre.next;
			}
			current.next=pre.next;
			pre.next=current;
			current=next;
		}
		return helper.next;
	}
	public static void main(String[] args) {
		ListNode[] nodes=new ListNode[5];
		Random random=new Random();
		for(int i=0;i<5;i++){
			nodes[i]=new ListNode(random.nextInt(10));
			if(i>0)
				nodes[i-1].next=nodes[i];
		}
		ListNode node=nodes[0];
		while(node!=null){
			System.out.print(node+" ");
			node=node.next;
		}
		System.out.println();
		InsertionSortList list=new InsertionSortList();
		ListNode node2=list.insertionSortList(nodes[0]);
		while(node2!=null){
			System.out.print(node2+" ");
			node2=node2.next;
		}
	}
}
