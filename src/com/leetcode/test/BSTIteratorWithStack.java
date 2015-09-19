package com.leetcode.test;

import java.util.Stack;

/*
 * 中序遍历的思路。
	用栈来保存从根到最左侧叶子节点的路径，栈最上面的结点是最小的结点，
	每次取next,都是取栈最上面的结点，然后把剩余结点到最左侧叶子节点的路径放入栈中。
 */
public class BSTIteratorWithStack {
		Stack<TreeNode> stack=new Stack<>();
	   public BSTIteratorWithStack(TreeNode root) {
	        while(root!=null){
	        	stack.push(root);
	        	root=root.left;
	        }
	    }

	    /** @return whether we have a next smallest number */
	    public boolean hasNext() {
	        return !stack.isEmpty();
	    }

	    /** @return the next smallest number */
	    public int next() {
	        TreeNode node=stack.pop();
	        int ret=node.val;
	        node=node.right;
	        while(node!=null){
	        	stack.push(node);
	        	node=node.left;
	        }
	        return ret;
	    }
}
