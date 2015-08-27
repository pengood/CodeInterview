package com.nowcoder.interview;


/*
 * 有两个用链表表示的整数，每个结点包含一个数位。这些数位是反向存放的，也就是个位排在链表的首部。编写函数对这两个整数求和，并用链表形式返回结果。
 给定两个链表ListNode* A，ListNode* B，请返回A+B的结果(ListNode*)。
 测试样例：
 {1,2,3},{3,2,1}
 返回：{4,4,4}
 */
public class PlusLinkedListABTest {
	public ListNode plusAB(ListNode a, ListNode b) {
		if(a==null)
			return b;
		if(b==null)
			return a;
		ListNode curA=a;
		ListNode curB=b;
		ListNode preA=null;
		int carry=0;
		while(curA!=null&&curB!=null){
			int sum=curA.val+curB.val+carry;
			if(sum>=10){
				carry=1;
				sum=sum-10;
			}else {
				carry=0;
			}
			curA.val=sum;
			preA=curA;
			curA=curA.next;
			curB=curB.next;
		}
		if(curB!=null){
			curB.val+=carry;
			carry=0;
			preA.next=curB;
		}
		if(curA!=null){
			curA.val+=carry;
			carry=0;
		}
		if(carry!=0){
			preA.next=new ListNode(carry);
		}
		return a;
	}
	public static void main(String[] args) {
		ListNode a=TestUtils.creatListNode(4);
		ListNode b=TestUtils.creatListNode(0);
		TestUtils.printListNode(a);
		TestUtils.printListNode(b);
		PlusLinkedListABTest test=new PlusLinkedListABTest();
		ListNode node=test.plusAB(a, b);
		TestUtils.printListNode(node);
	}
}
