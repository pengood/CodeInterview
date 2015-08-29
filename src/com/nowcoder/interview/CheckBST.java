package com.nowcoder.interview;

import java.util.ArrayList;
import java.util.List;

/*
 * 请实现一个函数，检查一棵二叉树是否为二叉查找树。
 给定树的根结点指针TreeNode* root，请返回一个bool，代表该树是否为二叉查找树。
 */
public class CheckBST {

	public boolean checkBST(TreeNode root) {
		if(root==null)
			return true;
		List<Integer> list=new ArrayList<Integer>();
		check(root, list);
		boolean ret=true;
		for(int i=1;i<list.size();i++){
			if(list.get(i)<list.get(i-1)){
				ret=false;
				break;
			}
		}
		return ret;
	}
	private void check(TreeNode node,List<Integer> list){
		if(node.left!=null)
			check(node.left, list);
		list.add(node.val);
		if(node.right!=null)
			check(node.right, list);
	}
public static void main(String[] args) {
	TreeNode node=TestUtils.createTree();
	CheckBST nBst=new CheckBST();
	System.out.println(nBst.checkBST(node));
	TreeNode node2=TestUtils.createBST();
	System.out.println(nBst.checkBST(node2));
}
}
