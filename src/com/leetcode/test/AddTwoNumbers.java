package com.leetcode.test;

import java.util.ArrayList;
import java.util.List;



public class AddTwoNumbers {
	  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        int sum;
	        int  flag=0;
	        ListNode re=null,current=re;
	        if(l1==null) {
	        	 return l2;
	        }
	        if(l2==null){
	        	return l1;
	        }
	       while(l1!=null&&l2!=null){
	    	   sum=l1.val+l2.val+flag;
	    	   if(sum>=10){
	    		   flag=1;
	    		   sum-=10;
	    	   }else {
				flag=0;
			}
	        	ListNode tmpListNode=new ListNode(sum);
	        	if(re==null)
	        		re=current=tmpListNode;
	        	else{
	        		current.next=tmpListNode;
	        		current=current.next;
	        	}
	        	l1=l1.next;
	        	l2=l2.next;
	        }
	        while(l1!=null){
	        	sum=l1.val+flag;
	        	if(sum>=10){
	        		sum-=10;
	        		flag=1;
	        	}else {
					flag=0;
				}
	        	ListNode tmpListNode=new ListNode(sum);
	        	if(re==null)
	        		re=current=tmpListNode;
	        	else{
	        		current.next=tmpListNode;
	        		current=current.next;
	        	}
	        	l1=l1.next;
	        }
	        while(l2!=null){
	        	sum=l2.val+flag;
	        	if(sum>=10){
	        		sum-=10;
	        		flag=1;
	        	}else {
					flag=0;
				}
	        	ListNode tmpListNode=new ListNode(sum);
	        	if(re==null)
	        		re=current=tmpListNode;
	        	else{
	        		current.next=tmpListNode;
	        		current=current.next;
	        	}
	        	l2=l2.next;
	        }
	        if(flag!=0){
	        	ListNode tmpListNode=new ListNode(flag);
	        	current.next=tmpListNode;
	        }
	        return re;
	    }
	  public static void main(String[] args){
		  ListNode l1=new ListNode(1);
//		  l1.next=new ListNode(4);
//		  l1.next.next=new ListNode(3);
		  ListNode l2=new ListNode(9);
		  l2.next=new ListNode(9);
//		  l2.next.next=new ListNode(4);
//		  l2.next.next.next=new ListNode(4);
		  ListNode result=addTwoNumbers(l1, l2);
		  while(result!=null){
			  System.out.print(result.val);
			  result=result.next;
		  }
	  }
}
