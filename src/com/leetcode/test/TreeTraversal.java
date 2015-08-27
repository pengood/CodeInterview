package com.leetcode.test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Pair<T, E> {
	T first;
	E second;

	public Pair(T t, E e) {
		this.first = t;
		this.second = e;
	}
}

public class TreeTraversal {
	/*
	 * 递归前序
	 */
	public static void preOrder(TreeNode root, Queue<Integer> queue) {
		if (root == null)
			return;
		queue.add(root.val);
		preOrder(root.left, queue);
		preOrder(root.right, queue);
	}

	/*
	 * 递归中序
	 */
	public static void inOrder(TreeNode root, Queue<Integer> queue) {
		if (root == null)
			return;
		inOrder(root.left, queue);
		queue.add(root.val);
		inOrder(root.right, queue);
	}

	/*
	 * 递归后序
	 */
	public static void postOrder(TreeNode root, Queue<Integer> queue) {
		if (root == null)
			return;
		postOrder(root.left, queue);
		postOrder(root.right, queue);
		queue.add(root.val);
	}

	/*
	 * 非递归前序
	 */
	public static void preTraversal(TreeNode root, Queue<Integer> queue) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode node = root;
		while (node != null || !stack.isEmpty()) {
			while (node != null) {
				queue.add(node.val);
				stack.push(node);
				node = node.left;
			}
			if (!stack.isEmpty()) {
				node = stack.pop();
				node = node.right;
			}
		}
	}

	/*
	 * 非递归中序
	 */
	public static void inTraversal(TreeNode root, Queue<Integer> queue) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode node = root;
		while (node != null || !stack.isEmpty()) {
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
			if (!stack.isEmpty()) {
				node = stack.pop();
				queue.add(node.val);
				node = node.right;
			}
		}

	}

	/*
	 * 非递归前序2
	 */
	public static void preTraversal2(TreeNode root, Queue<Integer> queue) {
		Stack<Pair<TreeNode, Boolean>> stack = new Stack<>();
		stack.push(new Pair<TreeNode, Boolean>(root, false));
		boolean visited;
		while (!stack.isEmpty()) {
			root = stack.peek().first;
			visited = stack.peek().second;
			stack.pop();
			if (root == null)
				continue;
			if (visited)
				queue.add(root.val);
			else {
				stack.push(new Pair<TreeNode, Boolean>(root.right, false));
				stack.push(new Pair<TreeNode, Boolean>(root.left, false));
				stack.push(new Pair<TreeNode, Boolean>(root, true));
			}
		}
	}

	/*
	 * 非递归中序2
	 */
	public static void inTraversal2(TreeNode root, Queue<Integer> queue) {
		Stack<Pair<TreeNode, Boolean>> stack = new Stack<>();
		stack.push(new Pair<TreeNode, Boolean>(root, false));
		boolean visited;
		while (!stack.isEmpty()) {
			root = stack.peek().first;
			visited = stack.peek().second;
			stack.pop();
			if (root == null)
				continue;
			if (visited)
				queue.add(root.val);
			else {
				stack.push(new Pair<TreeNode, Boolean>(root.right, false));
				stack.push(new Pair<TreeNode, Boolean>(root, true));
				stack.push(new Pair<TreeNode, Boolean>(root.left, false));
			}
		}
	}

	/*
	 * 非递归后序
	 */
	public static void postTraversal2(TreeNode root, Queue<Integer> queue) {
		Stack<Pair<TreeNode, Boolean>> stack = new Stack<>();
		stack.push(new Pair<TreeNode, Boolean>(root, false));
		boolean visited;
		while (!stack.isEmpty()) {
			root = stack.peek().first;
			visited = stack.peek().second;
			stack.pop();
			if (root == null)
				continue;
			if (visited)
				queue.add(root.val);
			else {
				stack.push(new Pair<TreeNode, Boolean>(root, true));
				stack.push(new Pair<TreeNode, Boolean>(root.right, false));
				stack.push(new Pair<TreeNode, Boolean>(root.left, false));
			}
		}
	}

	public static TreeNode invert(TreeNode root) {
		TreeNode node = root;
		if (node == null)
			return null;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			root = stack.pop();
			TreeNode tmp = root.left;
			root.left = root.right;
			root.right = tmp;
			if(root.left!=null)
				stack.push(root.left);
			if(root.right!=null)
				stack.push(root.right);
		}
		return node;
	}

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(8);
		TreeNode node2 = new TreeNode(6);
		TreeNode node3 = new TreeNode(10);
		TreeNode node4 = new TreeNode(5);
		TreeNode node5 = new TreeNode(7);
		TreeNode node6 = new TreeNode(9);
		TreeNode node7 = new TreeNode(11);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		Queue<Integer> Prequeue = new LinkedList<Integer>();
		Queue<Integer> Inqueue = new LinkedList<Integer>();
		Queue<Integer> Postqueue = new LinkedList<Integer>();
		Queue<Integer> Prequeue1 = new LinkedList<Integer>();
		Queue<Integer> Inqueue1 = new LinkedList<Integer>();
		Queue<Integer> Postqueue1 = new LinkedList<Integer>();
		Queue<Integer> Prequeuein = new LinkedList<Integer>();
		preOrder(node1, Prequeue);
		inOrder(node1, Inqueue);
		postOrder(node1, Postqueue);
		preTraversal2(node1, Prequeue1);
		inTraversal2(node1, Inqueue1);
		postTraversal2(node1, Postqueue1);
		System.out.println(Prequeue);
		System.out.println(Inqueue);
		System.out.println(Postqueue);
		System.out.println(Prequeue1);
		System.out.println(Inqueue1);
		System.out.println(Postqueue1);
		System.out.println("---------------------------");
		preOrder(invert(node1), Prequeuein);
		System.out.println(Prequeuein);
	}

}
