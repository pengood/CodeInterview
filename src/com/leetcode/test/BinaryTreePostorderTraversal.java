package com.leetcode.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
	static class Pair {
		TreeNode node;
		boolean visited;

		public Pair(TreeNode n, boolean s) {
			this.node = n;
			this.visited = s;
		}
	}

	public static List<Integer> postorderTraversal(TreeNode root) {
		if (root == null)
			return null;
		List<Integer> list = new ArrayList<Integer>();
		Stack<Pair> stack = new Stack<>();
		stack.add(new Pair(root, false));
		boolean visited = false;
		TreeNode current = null;
		while (!stack.isEmpty()) {
			Pair pair = stack.pop();
			current = pair.node;
			visited = pair.visited;
			if (visited)
				list.add(current.val);
			else {
				stack.add(new Pair(current, true));
				if (current.right != null)
					stack.add(new Pair(current.right, false));
				if (current.left != null)
					stack.add(new Pair(current.left, false));
			}
		}
		return list;
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
		System.out.println(postorderTraversal(nodes[0]));
	}
}
