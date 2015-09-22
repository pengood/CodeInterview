package com.leetcode.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<Integer>();
        if(root==null)
        	return list;
        Stack<TreeNode> stack=new Stack<>();
        TreeNode node=root;
        while(!stack.isEmpty()||node!=null){
        	while(node!=null){
        		list.add(node.val);
        		stack.push(node);
        		node=node.left;
        	}
        	if(!stack.isEmpty()){
        		node=stack.pop();
        		node=node.right;
        	}
        }
        return list;
    }
    public static void main(String[] args) {
		
	}
}
