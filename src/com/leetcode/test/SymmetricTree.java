package com.leetcode.test;

import java.util.LinkedList;
import java.util.Queue;


public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		if(root==null||root.left==null&&root.right==null)
			return true;
		if(root.left!=null&&root.right!=null){
			if(root.left.val!=root.right.val)
				return false;
		}
		root.right=reserve(root.right);
		return equal(root.left, root.right);
	}
	private TreeNode reserve(TreeNode node){
		if(node==null)
			return null;
		TreeNode tmpNode=node.left;
		node.left=node.right;
		node.right=tmpNode;
		if(node.left!=null)
			node.left=reserve(node.left);
		if(node.right!=null)
			node.right=reserve(node.right);
		return node;
	}
	private boolean equal(TreeNode left,TreeNode right){
		if(left==null&&right==null)
			return true;
		if(left==null&&right!=null||left!=null&&right==null)
			return false;
		if(left.val!=right.val)
			return false;
		return equal(left.left, right.left)&&equal(left.right, right.right);
	}
	private boolean isMiior(TreeNode left,TreeNode right){
		if(left==null&&right==null)
			return true;
		if(left==null&&right!=null||left!=null&&right==null)
			return false;
		if(left.val!=right.val)
			return false;
		return isMiior(left.left, right.right)&&isMiior(left.right, right.left);
	}
	public boolean isSymmetric1(TreeNode root){
		if(root==null)
			return true;
		Queue<TreeNode> lefTreeNodes=new LinkedList<>();
		Queue<TreeNode> rightNodes=new LinkedList<>();
		lefTreeNodes.add(root.left);
		rightNodes.add(root.right);
		while(!lefTreeNodes.isEmpty()){
			TreeNode lefttmpNode=lefTreeNodes.poll();
			TreeNode righttmp=rightNodes.poll();
			if(lefttmpNode==null&&righttmp==null)
				continue;
			if(lefttmpNode==null||righttmp==null)
				return false;
			if(lefttmpNode.val!=righttmp.val)
				return false;
			lefTreeNodes.add(lefttmpNode.left);
			lefTreeNodes.add(lefttmpNode.right);
			rightNodes.add(righttmp.right);
			rightNodes.add(righttmp.left);
		}
		if(!rightNodes.isEmpty())
			return false;
		return true;
	}
}
