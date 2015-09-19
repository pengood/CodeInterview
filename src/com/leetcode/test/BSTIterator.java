package com.leetcode.test;

import java.util.ArrayList;
import java.util.List;

/*
 * Implement an iterator over a binary search tree (BST). 
 * Your iterator will be initialized with the root node of a BST.

	Calling next() will return the next smallest number in the BST.

	Note: next() and hasNext() should run in average O(1) time and 
	uses O(h) memory, where h is the height of the tree.
 */
public class BSTIterator {
	List<Integer> list=new ArrayList<Integer>();
	int current=0;
	   public BSTIterator(TreeNode root) {
	        init(root);
	    }
	   
	   private void init(TreeNode node){
		   if(node==null)
			   return;
		   init(node.left);
		   list.add(node.val);
		   init(node.right);
	   }
	    /** @return whether we have a next smallest number */
	    public boolean hasNext() {
	        return current<list.size();
	    }

	    /** @return the next smallest number */
	    public int next() {
	        return list.get(current++);
	    }
	    
}
