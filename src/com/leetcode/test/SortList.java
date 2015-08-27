package com.leetcode.test;

public class SortList {
public ListNode sortList(ListNode head) {
        if(head==null||head.next==null)
        	return head;
        ListNode mid=getMid(head);
        ListNode nextListNode=mid.next;
        mid.next=null;
        return merge(sortList(head), sortList(nextListNode));
     
    }
private ListNode getMid(ListNode node){
	ListNode slow=node,fast=node;
	while(fast.next!=null&&fast.next.next!=null){
		slow=slow.next;
		fast=fast.next.next;
	}
	return slow;
}
private ListNode merge(ListNode a,ListNode b){
	ListNode node=new ListNode(-1);
	ListNode curListNode=node;
	while(a!=null&&b!=null){
		if(a.val<=b.val){
			curListNode.next=a;
			a=a.next;
		}
		else {
			curListNode.next=b;
			b=b.next;
		}
		curListNode=curListNode.next;
	}
	if(a==null)
		curListNode.next=b;
	else if(b==null)
		curListNode.next=a;
	return node.next;
}
public static void main(String[] args) {
	SortList sortList=new SortList();
	ListNode node=new ListNode(2);
	ListNode node2=new ListNode(1);
	node.next=node2;
	System.out.println(sortList.sortList(node));
}

}
