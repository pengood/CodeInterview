package com.offer;

import java.util.Random;

public class TreeToList {
	private static TreeNode previous;

	public static TreeNode listHead() {
		while (previous != null && previous.left != null)
			previous = previous.left;
		return previous;
	}

	public static void toTwoWayLinkedList(TreeNode node) {
		if (node == null)
			return;
		toTwoWayLinkedList(node.left);
		if (previous != null) {
			previous.right = node;
			node.left = previous;
		}
		previous = node;
		toTwoWayLinkedList(node.right);

	}

	static TreeNode lastNode = null;

	public static TreeNode mytoList(TreeNode root) {
		toList(root);
		TreeNode node = lastNode;
		while (node != null && node.left != null)
			node = node.left;
		return node;
	}

	public static void toList(TreeNode root) {
		if (root == null)
			return;
		TreeNode current = root;
		if (current.left != null)
			toList(root.left);
		current.left = lastNode;
		if (lastNode != null)
			lastNode.right = current;
		lastNode = current;
		if (current.right != null)
			toList(current.right);
	}

	public static void printTree(TreeNode root) {
		if (root == null)
			return;
		printTree(root.left);
		System.out.print(root.val + " ");
		printTree(root.right);
	}

	public static void printList(TreeNode node) {
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.right;
		}
	}

	public static void main(String[] args) {
		TreeNode[] nodes = new TreeNode[7];
		Random random = new Random();
		for (int i = 0; i < 35; i = i + 5) {
			nodes[i / 5] = new TreeNode(i + random.nextInt(4));
		}
		nodes[3].left = nodes[1];
		nodes[1].left = nodes[0];
		nodes[1].right = nodes[2];
		nodes[3].right = nodes[5];
		nodes[5].left = nodes[4];
		nodes[5].right = nodes[6];
		printTree(nodes[3]);
		// TreeNode node=mytoList(nodes[3]);
		toTwoWayLinkedList(nodes[3]);
		System.out.println();
		printList(listHead());
		
	}
}
