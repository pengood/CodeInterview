package com.offer;

import java.util.Arrays;

class ListNode{
	ListNode next;
	int val;
	public ListNode(){};
	public ListNode(int i){
		this.val=i;
	}
	public String toString(){
		return "node: "+val;
	}
}

public class ReserveList {
	public static ListNode reserve(ListNode head){
		ListNode current=head;
		ListNode preNode=null;
		ListNode reserveNode=null;
		while(current!=null){
			ListNode nextNode=current.next;
			if(nextNode==null)
				reserveNode=current;
			current.next=preNode;
			preNode=current;
			current=nextNode;
		}
		return reserveNode;
	}
	
	public static ListNode reserveRecur(ListNode head){
		return reserveRecur1(null, head);
	}
	public static ListNode reserveRecur1(ListNode pre,ListNode current){
		if(current==null)
			return pre;
		ListNode nextListNode=current.next;
		current.next=pre;
		return reserveRecur1(current, nextListNode);
	}
	public static void main(String[] args){
		ListNode[] listNodes=new ListNode[10];
		for(int i=0;i<10;i++){
			listNodes[i]=new ListNode(i);
		}
		for(int i=0;i<9;i++){
			listNodes[i].next=listNodes[i+1];
		}
		System.out.println(Arrays.toString(listNodes));
		ListNode node=reserveRecur(listNodes[0]);
		while(node!=null)
		{
			System.out.print(node+", ");
			node=node.next;
		}
	}
	
}
