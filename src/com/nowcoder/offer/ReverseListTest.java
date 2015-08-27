package com.nowcoder.offer;
/*
 * 输入一个链表，反转链表后，输出链表的所有元素。
 */
public class ReverseListTest {
	public ListNode ReverseList(ListNode head) {
		if(head==null||head.next==null)
			return head;
		ListNode current=head;
		ListNode preListNode=null;
		ListNode node=current;
		current=current.next;
		node.next=null;
		while(current!=null){
			preListNode=node;
			node=current;
			current=current.next;
			node.next=preListNode;
		}
		return node;
    }
public static void main(String[] args) {
	ListNode[] listNodes=new ListNode[1];
	for(int i=0;i<5;i++){
		listNodes[i]=new ListNode(i);
		if(i>0)
			listNodes[i-1].next=listNodes[i];
	}
	ReverseListTest test=new ReverseListTest();
	ListNode node=test.ReverseList(listNodes[0]);
	while(node!=null){
		System.out.print(node+" ");
		node=node.next;
	}
}
}
