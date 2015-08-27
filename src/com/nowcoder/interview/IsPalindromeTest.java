package com.nowcoder.interview;

import java.util.ArrayList;

/*
 * 请编写一个函数，检查链表是否为回文。
 给定一个链表ListNode* pHead，请返回一个bool，代表链表是否为回文。
 测试样例：
 {1,2,3,2,1}
 返回：true
 {1,2,3,2,3}
 返回：false
 */
public class IsPalindromeTest {
	public boolean isPalindrome(ListNode pHead) {
		if(pHead==null||pHead.next==null)
			return true;
		ArrayList<Integer> list=new ArrayList<>();
		ListNode node=pHead;
		while(node!=null){
			list.add(node.val);
			node=node.next;
		}
		while(list.size()>1){
			if(list.get(0)!=list.get(list.size()-1))
				return false;
			list.remove(0);
			list.remove(list.size()-1);
		}
		return true;
	}
	public static void main(String[] args) {
		int[] a={1,2,2,0,1};
		ListNode node=TestUtils.createListNode(a);
		TestUtils.printListNode(node);
		IsPalindromeTest test=new IsPalindromeTest();
		System.out.println(test.isPalindrome(node));
	}
}
