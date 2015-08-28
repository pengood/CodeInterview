package com.nowcoder.interview;

import java.util.Arrays;
import java.util.Random;

/*
 * 单向链表类
 */
class ListNode{
	   int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return ""+val;
		}
}

public class TestUtils {
	/*
	 * 构造指定size链表
	 */
	public static ListNode creatListNode(int size){
		if(size<=0)
			return null;
		Random random=new Random(47);
		ListNode[] listNodes=new ListNode[size];
		for(int i=0;i<size;i++){
			listNodes[i]=new ListNode(random.nextInt(10));
			if(i>0)
				listNodes[i-1].next=listNodes[i];
		}
		return listNodes[0];
	}
	
	/*
	 * 通过数字构造链表
	 */
	public static ListNode createListNode(int[] array){
		if(array==null||array.length==0)
			return null;
		ListNode[] listNodes=new ListNode[array.length];
		for(int i=0;i<listNodes.length;i++){
			listNodes[i]=new ListNode(array[i]);
			if(i>0)
				listNodes[i-1].next=listNodes[i];
		}
		return listNodes[0];
	}
	
	/*
	 * 构造排序链表
	 */
	public static ListNode cretedSortedListNode(int size){
		if(size<=0)
			return null;
		Random random=new Random(47);
		ListNode[] listNodes=new ListNode[size];
		for(int i=0;i<size;i++){
			listNodes[i]=new ListNode(i+5+random.nextInt(5));
			if(i>0)
				listNodes[i-1].next=listNodes[i];
		}
		return listNodes[0];
	}
	
	public static void printListNode(ListNode node){
		while(node!=null){
			System.out.print(node+" ");
			node=node.next;
		}
		System.out.println();
	}
	public static int[][] createArray(String string){
		string=string.substring(1, string.length()-1);
		System.out.println(string.length());
		
		return null;
	}
	public static void main(String[] args) {
		String string="[[1,-5],[1,-1],[1,9],[1,9],[2,0],[2,1],[1,-8],[2,1],[1,-71],[1,-92],[1,18],[1,91],[1,61],[2,-1],[1,-35],[1,95],[1,-49],[1,9],[1,78],[2,0],[1,91],[1,-96],[2,-1],[2,0],[2,-1],[2,1],[1,38],[2,0],[1,45],[2,0],[1,-51],[2,1],[2,1],[2,-1],[1,39],[1,59],[1,45],[2,0],[1,-70],[2,0],[1,23],[1,88],[1,83],[1,69],[1,-78],[1,-3],[1,-9],[1,-20],[1,-74],[1,-62],[1,5],[1,55],[1,-36],[1,-21],[1,-94],[1,-27],[1,-69],[2,0],[1,-30],[1,-84],[2,0],[2,0],[2,-1],[1,92],[1,60],[2,1],[2,0],[1,-63],[2,0],[1,-87],[1,66],[2,0],[1,17],[2,0],[2,1],[1,-41],[1,-3],[1,-29],[1,72],[2,1],[1,35],[1,81],[1,-83],[1,-17],[1,36],[1,99],[1,-17],[1,8],[2,0],[1,80],[1,50],[1,80],[2,0],[1,-48],[1,-82],[1,-63],[1,2],[2,1],[1,-43],[1,59],[1,93],[1,55],[1,-93],[2,-1],[1,2],[1,13],[2,0]]";
		createArray(string);
	}
}
