package com.nowcoder.interview;

/*
 * 实现一个函数，检查二叉树是否平衡，平衡的定义如下，对于树中的任意一个结点，其两颗子树的高度差不超过1。
 给定指向树根结点的指针TreeNode* root，请返回一个bool，代表这棵树是否平衡。
 */
public class IsBalanceTree {
	public boolean isBalance(TreeNode root) {
		if(root==null)
			return true;
		int left=subTreeHeight(root.left);
		if(left==-1)
			return false;
		int right=subTreeHeight(root.right);
		if(right==-1)
			return false;
		if(Math.abs(left-right)>1)
			return false;
		return true;
	}
	private int subTreeHeight(TreeNode node){
		if(node==null)
			return 0;
		int left=subTreeHeight(node.left);
		if(left==-1)
			return -1;
		int right=subTreeHeight(node.right);
		if(right==-1)
			return -1;
		if(Math.abs(left-right)>1)
			return -1;
		return left>right?(left+1):(right+1);
	}
	public static void main(String[] args) {
		TreeNode node=TestUtils.createTree();
		TestUtils.printTreePreOrder(node);
		IsBalanceTree tree=new IsBalanceTree();
		System.out.println(tree.isBalance(node));
	}
}
