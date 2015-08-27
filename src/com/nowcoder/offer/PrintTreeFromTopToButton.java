package com.nowcoder.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */

public class PrintTreeFromTopToButton {
	ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> list=new ArrayList<>();
		if(pRoot==null)
			return list;
		Queue<TreeNode> queue=new LinkedList<TreeNode>();
		int level=1;
		int nextlevel=0;
		int i=0;
		queue.add(pRoot);
		while(!queue.isEmpty()){
			TreeNode node=queue.poll();
			print(node, i, list);
			if(node.left!=null){
				queue.add(node.left);
				nextlevel++;
			}
			if(node.right!=null){
				queue.add(node.right);
				nextlevel++;
			}
			level--;
			if(level==0){
				level=nextlevel;
				nextlevel=0;
				i++;
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
			PrintTreeFromTopToButton test=new PrintTreeFromTopToButton();
			System.out.println(test.Print(treeNodes[0]));
		
	}
}
