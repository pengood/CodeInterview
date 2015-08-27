package com.nowcoder.offer;

/*
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 *  例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class DeleteDuplicationTest {
	public ListNode deleteDuplication(ListNode pHead) {
		if(pHead==null||pHead.next==null)
			return pHead;
		ListNode dump=new ListNode(Integer.MIN_VALUE);
		dump.next=pHead;
		ListNode pre=dump;
		ListNode cur=dump;
		ListNode next=null;
		boolean nextto=false;
		while(cur!=null){
			next=cur.next;
			if(next!=null&&cur.val==next.val){
				cur=pre;
				next=cur.next;
			}
			while(next!=null&&next.next!=null&&next.val==next.next.val){
				next=next.next;
				nextto=true;
			}
			if(nextto)
				next=next.next;
			nextto=false;
			cur.next=next;
			pre=cur;
			cur=next;
		}
		return dump.next;
	}
	public static void main(String[] args) {
		ListNode node=new ListNode(1);
		ListNode node2=new ListNode(2);
		ListNode node3=new ListNode(3);
		ListNode node4=new ListNode(3);
		ListNode node5=new ListNode(4);
		ListNode node6=new ListNode(4);
		ListNode node7=new ListNode(5);
		ListNode node8=new ListNode(6);
		node.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		node5.next=node6;
		node6.next=node7;
		node7.next=node8;
		DeleteDuplicationTest test=new DeleteDuplicationTest();
		ListNode node9=test.deleteDuplication(node);
		ListNode node10=node9;
		while(node10!=null){
			System.out.print(node10+" ");
			node10=node10.next;
		}
			
	}
}
