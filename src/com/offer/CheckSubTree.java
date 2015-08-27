package com.offer;

public class CheckSubTree {
	public static boolean check(TreeNode root,TreeNode sub){
		if(sub==null)
			return true;
		if(root==null)
			return false;
		return ((root.val==sub.val)&&isSub(root.left, sub.left)&&isSub(root.right, sub.right))
				||check(root.left, sub)||check(root.right, sub);
		
	}
	public static boolean isSub(TreeNode root,TreeNode sub){
		if(sub==null)
			return true;
		if(root==null)
			return false;
		if(root.val==sub.val&&isSub(root.left, sub.left)&&isSub(root.right, sub.right))
			return true;
		return false;
	}
	
	public static void main(String[] args){
		TreeNode node1=new TreeNode(8);
		TreeNode node2=new TreeNode(8);
		TreeNode node3=new TreeNode(7);
		TreeNode node4=new TreeNode(9);
		TreeNode node5=new TreeNode(2);
		TreeNode node6=new TreeNode(4);
		TreeNode node7=new TreeNode(7);
		TreeNode node11=new TreeNode(8);
		TreeNode node12=new TreeNode(9);
		TreeNode node13=new TreeNode(2);
		node1.left=node2;
		node1.right=node3;
		node2.left=node4;
		node2.right=node5;
		node5.left=node6;
		node5.right=node7;
		node11.left=node12;
		node11.right=node13;
		System.out.print(check(node1, node11));
	}
	
}
