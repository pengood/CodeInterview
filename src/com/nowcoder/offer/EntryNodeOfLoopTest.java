package com.nowcoder.offer;

/*
 * 一个链表中包含环，请找出该链表的环的入口结点。
 */
public class EntryNodeOfLoopTest {
	public ListNode EntryNodeOfLoop(ListNode pHead) {
		if(pHead==null||pHead.next==null)
			return null;
		ListNode slow=pHead;
		ListNode fast=pHead;
		while(slow!=null&&fast!=null&&fast.next!=null){
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast)
				break;
		}
		slow=pHead;
		while(slow!=null&&fast!=null&&slow!=fast){
			slow=slow.next;
			fast=fast.next;
		}
		return slow;
	}
	public static void main(String[] args) {
		ListNode[] listNodes=new ListNode[6];
		for(int i=0;i<6;i++){
			listNodes[i]=new ListNode(i);
			if(i>0)
				listNodes[i-1].next=listNodes[i];
		}
		listNodes[5].next=listNodes[4];
		EntryNodeOfLoopTest test=new EntryNodeOfLoopTest();
		System.out.println(test.EntryNodeOfLoop(listNodes[0]));
	}
}
