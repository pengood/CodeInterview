package com.nowcoder.interview;

/*
 * 请设计一个算法，寻找二叉树中指定结点的下一个结点（即中序遍历的后继）。
 给定树的根结点指针TreeNode* root和结点的值int p，请返回值为p的结点的后继结点的值。
 保证结点的值大于等于零小于等于100000且没有重复值，若不存在后继返回-1。
 */
public class FindNextTreeNode {
	boolean next;
	boolean found;
	int ret = -1;

	public int findSucc(TreeNode root, int p) {
		if (root == null)
			return -1;
		find(root, p);
		return ret;
	}

	private void find(TreeNode node, int p) {
		if (node == null)
			return;
		if (!found)
			find(node.left, p);
		if (!found && next) {
			ret = node.val;
			found = true;
			return;
		}
		if (node.val == p)
			next = true;
		if (!found)
			find(node.right, p);
	}

	public static void main(String[] args) {
		FindNextTreeNode nextTreeNode = new FindNextTreeNode();
		TreeNode node = TestUtils.createTree();
		TestUtils.printTreeInOrder(node);
		System.out.println();
		System.out.println(nextTreeNode.findSucc(node, 2));
	}
}
