package com.offer;

import java.util.Deque;
import java.util.LinkedList;

public class BTSum {
	public static void mybtPath(TreeNode root,int sum){
		Deque<TreeNode> deque=new LinkedList<TreeNode>();
		btPath(root, deque, sum);
		
	}
	private static void btPath(TreeNode root, Deque<TreeNode> deque, int sum) {
		if (root == null || root.val > sum)
			return;
		deque.addLast(root);
		if (sum - root.val == 0) {
			System.out.println(deque);
			deque.pollLast();
			return;
		}
		if (root.left != null)
			btPath(root.left, deque, sum - root.val);
		if (root.right != null)
			btPath(root.right, deque, sum - root.val);
	//	if (deque.peekLast() != root.left || deque.peekLast() != root.right)
			deque.pollLast();
	}
	public static void main(String[] args){
		TreeNode[] nodes=new TreeNode[8];
		for(int i=1;i<8;i++){
			nodes[i]=new TreeNode(i);
		}
		nodes[1].left=nodes[2];
		nodes[1].right=nodes[3];
		nodes[2].left=nodes[4];
		nodes[2].right=nodes[5];
		nodes[3].left=nodes[6];
		nodes[3].right=nodes[7];
		nodes[4].left=new TreeNode(1);
		mybtPath(nodes[1], 8);
	}

}
