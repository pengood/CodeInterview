package com.nowcoder.offer;

import java.util.Random;
/*
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class MergeSortedLinkedList {
	 public ListNode Merge(ListNode list1,ListNode list2) {
	        if(list1==null)
	        	return list2;
	        if(list2==null)
	        	return list1;
	        ListNode dump=new ListNode(Integer.MIN_VALUE);
	        ListNode node=dump;
	        while(list1!=null&&list2!=null){
	        	if(list1.val<=list2.val){
	        			node.next=list1;
	        			list1=list1.next;
	        	}
	        	
	        	else {
					node.next=list2;
					list2=list2.next;
				}
	        	node=node.next;
	        }
	        if(list1==null)
	        	node.next=list2;
	       if(list2==null)
	    	   node.next=list1;
	       return dump.next;
	    }
	 public static void main(String[] args) {
		 Random random=new Random();
		 ListNode[] listNodes=new ListNode[5];
			for(int i=0;i<5;i++){
				listNodes[i]=new ListNode(i+5+random.nextInt(5));
				System.out.print(listNodes[i]+" ");
				if(i>0)
					listNodes[i-1].next=listNodes[i];
			}
			System.out.println();
			ListNode[] listNodes1=new ListNode[5];
			for(int i=0;i<5;i++){
				listNodes1[i]=new ListNode(i+5+random.nextInt(5));
				System.out.print(listNodes1[i]+" ");
				if(i>0)
					listNodes1[i-1].next=listNodes1[i];
			}
			System.out.println();
			MergeSortedLinkedList linkedList=new MergeSortedLinkedList();
			ListNode node=linkedList.Merge(listNodes[0], listNodes1[0]);
			while(node!=null){
				System.out.print(node+" ");
				node=node.next;
			}
	}
}
