package com.leetcode.test;
 class ListNode {
    int val;
    ListNode next;
     ListNode(int x) { val = x; }
     
     @Override
     public String toString(){
    	 return ""+val;
     }
 }
public class DeleteNodeinaLinkedList {
	 public void deleteNode(ListNode node) {
	        if(node==null)
	        	return;
	        ListNode node2=node.next;
	        while(node2!=null){
	        	node.val=node2.val;
	        	if(node2.next==null){
	        		node.next=null;
	        		break;
	        	}
	        	node=node2;
	        	node2=node2.next;
	        }
	        node=null;
	    }
}
