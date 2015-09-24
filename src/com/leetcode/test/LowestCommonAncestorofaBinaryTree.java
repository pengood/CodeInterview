package com.leetcode.test;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between 
two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow 
a node to be a descendant of itself).”

        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA 
of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 */
public class LowestCommonAncestorofaBinaryTree {
	 public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		 if(root==null||p==null||q==null)
			 throw new IllegalArgumentException();
		 if(p==q)
			 return p;
		 List<TreeNode> pList=new ArrayList<TreeNode>();
		 List<TreeNode> qList=new ArrayList<TreeNode>();
		 boolean foundp=findPath(root, p, pList);
		 boolean foundq=findPath(root, q, qList);
		 if(!foundp||!foundq)
			 throw new IllegalArgumentException();
	     TreeNode retNode = null;
	     for(int i=0;i<pList.size()&&i<qList.size();i++){
	    	 if(pList.get(i)!=qList.get(i)){
	    		 break;
	    	 }else {
				retNode=pList.get(i);
			}
	     }
	     return retNode;
	    }
	 private boolean findPath(TreeNode node,TreeNode p, List<TreeNode> list){
		 if(node==null){
			 return false;
		 }
		 if(node==p){
			 list.add(node);
			 return true;
		 }
		 list.add(node);
		 boolean found=findPath(node.left, p, list);
		 if(!found)
			 found=findPath(node.right, p, list);
		 if(!found){
			 list.remove(list.size()-1);
		 }
		return found; 
	 }
	 public static void main(String[] args) {
		TreeNode[] nodes=new TreeNode[5];
		for(int i=0;i<5;i++){
			nodes[i] =new TreeNode(i);
		}
		nodes[0].left=nodes[1];
		nodes[0].right=nodes[2];
		nodes[1].left=nodes[3];
		nodes[1].right=nodes[4];
		LowestCommonAncestorofaBinaryTree tree=new LowestCommonAncestorofaBinaryTree();
		TreeNode n=tree.lowestCommonAncestor(nodes[0], nodes[3], nodes[2]);
		System.out.println(n);
	}
}
