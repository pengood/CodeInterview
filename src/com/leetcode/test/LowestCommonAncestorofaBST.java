package com.leetcode.test;

public class LowestCommonAncestorofaBST {
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||p==null||q==null)
        	return null;
        if(p.val<root.val&&q.val>root.val||q.val<root.val&&p.val>root.val||p==root||q==root)
        	return root;
        if(p.val<root.val&&q.val<root.val)
        	return lowestCommonAncestor(root.left, p, q);
        if(p.val>root.val&&q.val>root.val)
        	return lowestCommonAncestor(root.right, p, q);
        return null;
    }
}
