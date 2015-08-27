package com.leetcode.test;

import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree {
	public boolean isValidBST(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		order(root, list);
		if(list.size()==1)
			return true;
		for (int i = 1; i < list.size(); i++) {
			if(list.get(i-1)>=list.get(i))
				return false;
		}
		return true;
	}

	private void order(TreeNode node, List<Integer> list) {
		if (node == null)
			return;
		order(node.left, list);
		list.add(node.val);
		order(node.right, list);
	}
	public static void main(String[] args) {
		
	}
}
