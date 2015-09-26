package com.leetcode.test;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

 For example:
 Given the following binary tree,
 1            <---
 /   \
 2     3         <---
 \     \
 5     4       <---
 You should return [1, 3, 4].
 */
public class BinaryTreeRightSideView {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> list=new ArrayList<Integer>();
		if(root==null)
			return list;
		List<List<TreeNode>> list2=new ArrayList<>();
		trival(root, 0, list2);
		for(List<TreeNode> nodes:list2){
			int v=nodes.get(nodes.size()-1).val;
			list.add(v);
		}
		return list;
	}
	private void trival(TreeNode node,int d,List<List<TreeNode>> list){
		if(node==null)
			return;
		if(list.size()==d){
			List<TreeNode> list2=new ArrayList<>();
			list.add(list2);
		}
		list.get(d).add(node);
		trival(node.left, d+1, list);
		trival(node.right, d+1, list);
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
		BinaryTreeRightSideView view=new BinaryTreeRightSideView();
		System.out.println(view.rightSideView(nodes[0]));
		
	}
}
