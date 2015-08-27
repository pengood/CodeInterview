package com.nowcoder.offer;

import java.util.HashMap;

/*
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点）。
 */

class RandomListNode {
	int label;
	RandomListNode next = null;
	RandomListNode random = null;

	RandomListNode(int label) {
		this.label = label;
	}
	public String toString(){
		return ""+label;
	}
}

public class ComplexListCloneTest {
	public RandomListNode Clone(RandomListNode pHead) {
		if(pHead==null)
			return pHead;
		HashMap<RandomListNode, RandomListNode> map=new HashMap<>();
		RandomListNode cur=pHead;
		RandomListNode node=new RandomListNode(cur.label);
		map.put(cur, node);
		cur=cur.next;
		while(cur!=null){
			RandomListNode node2=new RandomListNode(cur.label);
			map.put(cur, node2);
			node.next=node2;
			node=node.next;
			cur=cur.next;
		}
		RandomListNode cloneHead=map.get(pHead);
		RandomListNode node2=cloneHead;
		RandomListNode curListNode=pHead;
		while(node2!=null){
			node2.random=map.get(curListNode.random);
			node2=node2.next;
			curListNode=curListNode.next;
		}
		return cloneHead;
	}
	public static void main(String[] args) {
		RandomListNode[] nodes=new RandomListNode[5];
		for(int i=0;i<5;i++){
			nodes[i]=new RandomListNode(i);
			if(i>0)
				nodes[i-1].next=nodes[i];
		}
		nodes[0].random=nodes[2];
		nodes[1].random=nodes[4];
		ComplexListCloneTest test=new ComplexListCloneTest();
		RandomListNode node=test.Clone(nodes[0]);
		System.out.println(node);
	}
}
