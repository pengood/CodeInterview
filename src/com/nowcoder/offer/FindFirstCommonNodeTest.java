package com.nowcoder.offer;

import java.util.Stack;

/*
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class FindFirstCommonNodeTest {
	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		if(pHead1==null||pHead2==null)
			return null;
		Stack<ListNode> stack1=new Stack<>();
		Stack<ListNode> stack2=new Stack<>();
		ListNode curListNode=pHead1;
		while(curListNode!=null){
			stack1.push(curListNode);
			curListNode=curListNode.next;
		}
		curListNode=pHead2;
		while(curListNode!=null){
			stack2.push(curListNode);
			curListNode=curListNode.next;
		}
		curListNode=null;
		while(!stack1.isEmpty()&&!stack2.isEmpty()){
			if(stack1.peek()!=stack2.peek())
				break;
			else {
				curListNode=stack1.pop();
				stack2.pop();
			}
		}
		return curListNode;
	}
}
