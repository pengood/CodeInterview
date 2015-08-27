package com.offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class CloneNode {
	static class ListNode {
		int val;
		ListNode next;
		ListNode Sibling;

		public ListNode(int i) {
			// TODO Auto-generated constructor stub
			this.val = i;
		}

		public String toString() {
			if (this.Sibling != null)
				return "node:" + val + "->" + Sibling.val;
			return "node:" + val;
		}
	}

	public static ListNode clone(ListNode head) {
		if (head == null)
			return null;
		HashMap<ListNode, ListNode> map = new HashMap<>();
		ListNode clonehead = new ListNode(head.val);
		map.put(head, clonehead);
		ListNode current = head.next;
		ListNode clonecurrent = clonehead;
		while (current != null) {
			ListNode node = new ListNode(current.val);
			clonecurrent.next = node;
			map.put(current,node );
			clonecurrent = clonecurrent.next;
			current = current.next;
		}
		current = head;
		clonecurrent = clonehead;
		while (current != null) {
			clonecurrent.Sibling = map.get(current.Sibling);
			clonecurrent = clonecurrent.next;
			current = current.next;
		}
		return clonehead;
	}
	public static void main(String[] args){
		ListNode[] listNodes=new ListNode[7];
		Random random=new Random();
		for(int i=0;i<7;i++){
			listNodes[i]=new ListNode(i);
		}
		for(int i=0;i<6;i++){
			listNodes[i].next=listNodes[i+1];
			listNodes[i].Sibling=listNodes[random.nextInt(6)];
		}
		listNodes[6].Sibling=listNodes[random.nextInt(6)];
		System.out.println(Arrays.toString(listNodes));
		ListNode node=clone(listNodes[0]);
		while(node!=null){
			System.out.print(node+", ");
			node=node.next;
		}
	}
}
