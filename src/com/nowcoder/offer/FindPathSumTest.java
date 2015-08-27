package com.nowcoder.offer;

import java.util.ArrayList;

/*
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class FindPathSumTest {
	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		if (root == null)
			return list;
		ArrayList<Integer> list2 = new ArrayList<>();
		findpath1(root, list, list2, target);
		return list;
	}

	private void findpath1(TreeNode node, ArrayList<ArrayList<Integer>> list,
			ArrayList<Integer> list2, int target) {
		
		if(node.left==null&&node.right==null){
			if(node.val==target){
				ArrayList<Integer> list3=new ArrayList<>(list2);
				list3.add(node.val);
				list.add(list3);
				return;
			}
			return;
		}
		target-=node.val;
		list2.add(node.val);
		if(node.left!=null)
			findpath1(node.left, list, list2, target);
		if(node.right!=null)
			findpath1(node.right, list, list2, target);
		list2.remove(list2.size()-1);
	}
	public static void main(String[] args) {
		TreeNode[] nodes=new TreeNode[5];
		for(int i=0;i<5;i++){
			nodes[i]=new TreeNode(i);
		}
		nodes[0].left=nodes[1];
		nodes[1].left=nodes[2];
		nodes[1].right=nodes[3];
		nodes[0].right=nodes[4];
		TreeNode node=new TreeNode(1);
		nodes[2].right=node;
		FindPathSumTest test=new FindPathSumTest();
		System.out.println(test.FindPath(nodes[0], 4));
	}
}
