package com.nowcoder.offer;

import java.util.ArrayList;
import java.util.List;

class ListNode {
	int val;
	ListNode next = null;
	ListNode(int val) {
		this.val = val;
	}
	@Override
	public String toString(){
		return ""+val;
	}
}

public class PrintListFromTailToHead {
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
			ArrayList<Integer> list=new ArrayList<>();
			if(listNode==null)
				return list;
			if(listNode.next==null){
				list.add(listNode.val);
				return list;
			}
			ListNode pre=listNode,current=listNode.next;
			pre.next=null;
			while(current!=null){
				ListNode node=pre;
				pre=current;
				current=current.next;
				pre.next=node;
			}
			ListNode node=pre;
			while(node!=null){
				list.add(node.val);
				node=node.next;
			}
			return list;
	}
	public static void main(String[] args) {
		ListNode[] listNodes=new ListNode[5];
		for(int i=0;i<5;i++){
			listNodes[i]=new ListNode(i);
			if(i>0)
				listNodes[i-1].next=listNodes[i];
		}
		PrintListFromTailToHead head=new PrintListFromTailToHead();
		System.out.println(head.printListFromTailToHead(listNodes[0]));
	}
}
