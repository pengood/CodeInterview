package com.nowcoder.offer;

import java.util.ArrayList;
import java.util.Stack;

/*
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class ZigZagPrintTreeTest {
	public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> list=new ArrayList<>();
		if(pRoot==null)
			return list;
		Stack<TreeNode>[] stacks=new Stack[2];
		stacks[0]=new Stack<>();
		stacks[1]=new Stack<>();
		int level=0;
		int current=0;
		stacks[current].add(pRoot);
		while(!stacks[0].isEmpty()||!stacks[1].isEmpty()){
			TreeNode node=stacks[current].pop();
			print(node, level, list);
			if(current==1){
				if(node.right!=null)
					stacks[1-current].add(node.right);
				if(node.left!=null)
					stacks[1-current].add(node.left);
			}else {
				if(node.left!=null)
					stacks[1-current].add(node.left);
				if(node.right!=null)
					stacks[1-current].add(node.right);
			}
			if(stacks[current].isEmpty()){
				current=1-current;
				level++;
			}
		}
		
		return list;
	}
	private void print(TreeNode node,int i,ArrayList<ArrayList<Integer>> list){
		if(list.size()<=i){
			ArrayList<Integer> list2=new ArrayList<>();
			list.add(list2);
		}
		list.get(i).add(node.val);
	}
	public static void main(String[] args) {
		TreeNode[] treeNodes=new TreeNode[5];
		for(int i=0;i<5;i++){
			treeNodes[i]=new TreeNode(i);
		}
		treeNodes[0].left=treeNodes[1];
		treeNodes[0].right=treeNodes[2];
		treeNodes[1].left=treeNodes[3];
		treeNodes[1].right=treeNodes[4];
		ZigZagPrintTreeTest test=new ZigZagPrintTreeTest();
		System.out.println(test.Print(treeNodes[0]));
	}
}
