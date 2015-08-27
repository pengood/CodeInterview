package com.offer;

import java.util.Arrays;
import java.util.Random;

public class CombineList {
	public static ListNode combine(ListNode head1, ListNode head2) {
		if(head1==null)
			return head2;
		if(head2==null)
			return head1;
		if(head1==head2)
			return head1;
		ListNode current1=head1;
		ListNode current2=head2;
		ListNode retListNode,re;
		if(current1.val<current2.val){
			retListNode=current1;
			current1=current1.next;
		}
		else {
			retListNode=current2;
			current2=current2.next;
		}
		re=retListNode;
		while(current1!=null&current2!=null){
			if(current1.val<current2.val){
				retListNode.next=current1;
				current1=current1.next;
			}
			else {
				retListNode.next=current2;
				current2=current2.next;
			}
			retListNode=retListNode.next;
		}
		if(current1==null)
			retListNode.next=current2;
		if(current2==null)
			retListNode.next=current1;
		return re;
	}
	public static ListNode combinCur(ListNode head1,ListNode head2){
		if(head1==null)
			return head2;
		if(head2==null)
			return head1;
		if(head1==head2)
			return head1;
		ListNode mergeListNode;
		if(head1.val<head2.val){
			mergeListNode=head1;
			mergeListNode.next=combinCur(head1.next, head2);
		}
		else {
			mergeListNode=head2;
			mergeListNode.next=combinCur(head1, head2.next);
		}
		return mergeListNode;
	}
	public static void main(String[] args){
		ListNode[] listNodes1=new ListNode[7];
		ListNode[] listNodes2=new ListNode[5];
		Random random=new Random();
		for(int i=0;i<35;i=i+5){
			listNodes1[i/5]=new ListNode(i+random.nextInt(5));
			if(i>20)
				continue;
			listNodes2[i/5]=new ListNode(i+random.nextInt(5));
		}
		for(int i=0;i<6;i++){
			listNodes1[i].next=listNodes1[i+1];
			if(i>3)
				continue;
			listNodes2[i].next=listNodes2[i+1];
		}
		System.out.println(Arrays.toString(listNodes1));
		System.out.println(Arrays.toString(listNodes2));
		ListNode node=combinCur(listNodes2[0], listNodes2[0]);
		while(node!=null){
			System.out.print(node+", ");
			node=node.next;
		}
	}
}
