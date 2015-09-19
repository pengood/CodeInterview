package com.leetcode.test;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a binary tree, return all root-to-leaf paths.

 For example, given the following binary tree:

 1
 /   \
 2     3
 \
 5
 All root-to-leaf paths are:

 ["1->2->5", "1->3"]
 */
public class BinaryTreePaths {
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> list=new ArrayList<String>();
		if(root==null)
			return list;
		List<TreeNode> listNodes=new ArrayList<>();
		helpPath(root, list, listNodes);
		return list;
	}
	private void helpPath(TreeNode node,List<String> list,List<TreeNode> nodes){
		if(node.left==null&&node.right==null){
			StringBuilder builder=new StringBuilder();
			for(TreeNode node2:nodes){
				builder.append(node2.val).append("->");
			}
			builder.append(node.val);
			list.add(builder.toString());
			return;
		}
		nodes.add(node);
		if(node.left!=null)
			helpPath(node.left, list, nodes);
		if(node.right!=null)
			helpPath(node.right, list, nodes);
		nodes.remove(node);	
	}
	public static void main(String[] args) {
		TreeNode[] nodes=new TreeNode[5];
		for(int i=0;i<5;i++){
			nodes[i]=new TreeNode(i);
		}
		nodes[0].left=nodes[1];
		nodes[0].right=nodes[2];
		nodes[1].left=nodes[3];
		nodes[1].right=nodes[4];
		BinaryTreePaths paths=new BinaryTreePaths();
		System.out.println(paths.binaryTreePaths(nodes[0]));
	}
	
}
