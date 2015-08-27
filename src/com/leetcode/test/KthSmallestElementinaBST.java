package com.leetcode.test;

import java.util.Stack;

public class KthSmallestElementinaBST {
	public static int kthSmallest(TreeNode root, int k) {
		if(root==null||k<0)
			throw new IllegalArgumentException();
		Stack<TreeNode> stack=new Stack<>();
		TreeNode current=root;
		int n=0;
		while(!stack.isEmpty()||current!=null){
			if(current!=null){
				stack.add(current);
				current=current.left;
			}
			else {
				current=stack.pop();
				if(++n>=k)
					return current.val;
				current=current.right;
			}
		}
		return 0;
	}
	public static synchronized void main(String[] args) {
		TreeNode[] nodes = new TreeNode[6];
		for (int i = 0; i < 6; i++) {
			nodes[i] = new TreeNode(i);
		}
		nodes[3].left = nodes[1];
		nodes[3].right = nodes[5];
		nodes[1].left = nodes[0];
		nodes[1].right = nodes[2];
		nodes[5].left = nodes[4];
		System.out.println(kthSmallest(nodes[3], 6));
	}
}
