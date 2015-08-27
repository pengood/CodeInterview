package com.leetcode.test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class FlattenBinaryTreetoLinkedList {
	public static void flatten(TreeNode root) {
		if (root == null)
			return;
		Queue<TreeNode> queue = new LinkedList<>();
		flatTreeNode(root, queue);
		TreeNode preNode = queue.poll();
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			preNode.right = node;
			preNode = node;
		}
	}

	private static void flatTreeNode(TreeNode node, Queue<TreeNode> queue) {
		queue.add(node);
		if (node.left != null)
			flatTreeNode(node.left, queue);
		if (node.right != null)
			flatTreeNode(node.right, queue);
	}

	public static void flatten2(TreeNode root) {
		if (root == null)
			return;
		Stack<TreeNode> stack = new Stack<>();
		stack.add(root);
		TreeNode current = root;
		while (!stack.isEmpty()) {
			current = stack.pop();
			if (current.right != null)
				stack.add(current.right);
			if (current.left != null)
				stack.add(current.left);
			current.left=null;
			if(!stack.isEmpty())
				current.right=stack.peek();
		}

	}

	public static void main(String[] args) {
		TreeNode[] nodes = new TreeNode[6];
		for (int i = 0; i < 6; i++) {
			nodes[i] = new TreeNode(i);
		}
		nodes[0].left = nodes[1];
		nodes[0].right = nodes[4];
		nodes[1].left = nodes[2];
		nodes[1].right = nodes[3];
		nodes[4].right = nodes[5];
		flatten2(nodes[0]);
		TreeNode node = nodes[0];
		while (node != null) {
			System.out.println(node + " ");
			node = node.right;
		}

	}
}
