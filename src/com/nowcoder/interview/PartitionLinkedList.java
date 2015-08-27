package com.nowcoder.interview;

/*
 * 编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
 给定一个链表的头指针 ListNode* pHead，请返回重新排列后的链表的头指针。注意：分割以后保持原来的数据顺序不变。
 */
public class PartitionLinkedList {
	public ListNode partition(ListNode pHead, int x) {
		if(pHead==null||pHead.next==null)
			return pHead;
		ListNode dump1=new ListNode(-1);
		ListNode dump2=new ListNode(-1);
		ListNode cur=pHead;
		ListNode cur1=dump1;
		ListNode cur2=dump2;
		while(cur!=null){
			if(cur.val<x){
				cur1.next=cur;
				cur1=cur1.next;
			}else {
				cur2.next=cur;
				cur2=cur2.next;
			}
			cur=cur.next;
		}
		cur2.next=null;
		cur1.next=dump2.next;
		return dump1.next;
	}
	public static void main(String[] args) {
		ListNode node=TestUtils.creatListNode(20);
		PartitionLinkedList testLinkedList=new PartitionLinkedList();
		TestUtils.printListNode(node);
		ListNode node2=testLinkedList.partition(node, 16);
		TestUtils.printListNode(node2);
	}
}
