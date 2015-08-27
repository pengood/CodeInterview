package com.nowcoder.offer;

/*
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class TreeDepthTest {
	public int TreeDepth(TreeNode root) {
		if(root==null)
			return 0;
		int leftlen=TreeDepth(root.left);
		int rightlen=TreeDepth(root.right);
		if(leftlen<rightlen)
			leftlen=rightlen;
		return leftlen+1;
	}
	public static void main(String[] args) {
		TreeNode node1=new TreeNode(10);
		TreeNode node2=new TreeNode(6);
		TreeNode node3=new TreeNode(14);
		TreeNode node4=new TreeNode(4);
		TreeNode node5=new TreeNode(8);
		TreeNode node6=new TreeNode(12);
		TreeNode node7=new TreeNode(16);
		node1.left=node2;
		node1.right=node3;
		node2.left=node4;
		node2.right=node5;
		node3.left=node6;
		node3.right=node7;
		TreeDepthTest test=new TreeDepthTest();
		System.out.println(test.TreeDepth(node1));
	}
}
