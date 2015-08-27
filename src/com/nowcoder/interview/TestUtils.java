package com.nowcoder.interview;

import java.util.Random;

/*
 * 单向链表类
 */
class ListNode{
	   int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return ""+val;
		}
}

public class TestUtils {
	/*
	 * 构造指定size链表
	 */
	public static ListNode creatListNode(int size){
		if(size<=0)
			return null;
		Random random=new Random(47);
		ListNode[] listNodes=new ListNode[size];
		for(int i=0;i<size;i++){
			listNodes[i]=new ListNode(random.nextInt(10));
			if(i>0)
				listNodes[i-1].next=listNodes[i];
		}
		return listNodes[0];
	}
	
	/*
	 * 通过数字构造链表
	 */
	public static ListNode createListNode(int[] array){
		if(array==null||array.length==0)
			return null;
		ListNode[] listNodes=new ListNode[array.length];
		for(int i=0;i<listNodes.length;i++){
			listNodes[i]=new ListNode(array[i]);
			if(i>0)
				listNodes[i-1].next=listNodes[i];
		}
		return listNodes[0];
	}
	
	/*
	 * 构造排序链表
	 */
	public static ListNode cretedSortedListNode(int size){
		if(size<=0)
			return null;
		Random random=new Random(47);
		ListNode[] listNodes=new ListNode[size];
		for(int i=0;i<size;i++){
			listNodes[i]=new ListNode(i+5+random.nextInt(5));
			if(i>0)
				listNodes[i-1].next=listNodes[i];
		}
		return listNodes[0];
	}
	
	public static void printListNode(ListNode node){
		while(node!=null){
			System.out.print(node+" ");
			node=node.next;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		ListNode node=creatListNode(10);
		while(node!=null){
			System.out.print(node+" ");
			node=node.next;
		}
		System.out.println();
		ListNode node1=cretedSortedListNode(10);
		while(node1!=null){
			System.out.print(node1+" ");
			node1=node1.next;
		}
	}
}
