package com.nowcoder.offer;
/*
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class FindKthToTailTest {
	public ListNode FindKthToTail(ListNode head,int k) {
		if(head==null||k<1)
			return null;
		ListNode node=head;
		for(int i=0;i<k;i++){
			if(node==null)
				return null;
			node=node.next;
		}
		ListNode node2=head;
		while(node!=null){
			node2=node2.next;
			node=node.next;
		}
		return node2;
    }
	public static void main(String[] args) {
		ListNode[] listNodes=new ListNode[5];
		for(int i=0;i<5;i++){
			listNodes[i]=new ListNode(i);
			if(i>0)
				listNodes[i-1].next=listNodes[i];
		}
		FindKthToTailTest tailTest=new FindKthToTailTest();
		System.out.println(tailTest.FindKthToTail(listNodes[0], 1));
	}
}
