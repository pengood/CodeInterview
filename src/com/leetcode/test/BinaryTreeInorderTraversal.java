package com.leetcode.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,3,2].
 */
public class BinaryTreeInorderTraversal {
public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<Integer>();
        if(root==null)
        	return list;
        Stack<TreeNode> stack=new Stack<>();
        TreeNode node=root;
        while(node!=null||!stack.isEmpty()){
        	while(node!=null){
        		stack.push(node);
        		node=node.left;
        	}
        	if(!stack.isEmpty()){
        		 node=stack.pop();
        		list.add(node.val);
        		node=node.right;
        	}
        	
        }
        return list;
    }
public static void printTreeInorder(TreeNode node){
	if(node==null)
		return;
	printTreeInorder(node.left);
	System.out.print(node+" ");
	printTreeInorder(node.right);
}
public static void main(String[] args) {
	TreeNode[] nodes=new TreeNode[5];
	for(int i=0;i<5;i++){
		nodes[i]=new TreeNode(i);
	}
	nodes[0].left=nodes[1];
	nodes[0].right=nodes[2];
	nodes[2].left=nodes[3];
	nodes[2].right=nodes[4];
	BinaryTreeInorderTraversal traversal=new BinaryTreeInorderTraversal();
	System.out.println(traversal.inorderTraversal(nodes[0]));
	printTreeInorder(nodes[0]);
}
}
