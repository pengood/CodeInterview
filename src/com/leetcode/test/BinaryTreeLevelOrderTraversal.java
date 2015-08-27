package com.leetcode.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
	static class Pair{
		TreeNode node;
		int level;
		public Pair(TreeNode no,int i){
			this.node=no;
			this.level=i;
		}
		public String toString(){
			return level+":"+node.val;
		}
	}
	public static List<List<Integer>> levelOrder(TreeNode root) {
		if(root==null)
			throw new IllegalArgumentException();
		List<List<Integer>> list=new ArrayList<List<Integer>>();
		Queue<Pair> queue=new LinkedList();
		queue.add(new Pair(root, 0));
		int n=0;
		while(!queue.isEmpty()){
			List<Integer> list2=new ArrayList<>();
			for(int i=0;i<(1<<n)&&!queue.isEmpty()&&queue.peek().level==n;i++){
				Pair pair=queue.poll();
				list2.add(pair.node.val);
				if(pair.node.left!=null)
					queue.add(new Pair(pair.node.left, n+1));
				if(pair.node.right!=null)
					queue.add(new Pair(pair.node.right, n+1));
			}
			n++;
			list.add(list2);
		}
		return list;
	}
	public static List<List<Integer>> levelOrder2(TreeNode root){
		if(root==null)
			return new ArrayList<>();
		List<List<Integer>> list=new ArrayList<List<Integer>>();
		Queue<TreeNode> queue1=new LinkedList();
		Queue<TreeNode> queue2=new LinkedList();
		queue1.add(root);
		while(!queue1.isEmpty()){
			List<Integer> list2=new ArrayList<>();
			while(!queue1.isEmpty()){
				TreeNode node=queue1.poll();
				list2.add(node.val);
				if(node.left!=null)
					queue2.add(node.left);
				if(node.right!=null)
					queue2.add(node.right);
			}
			list.add(list2);
			Queue<TreeNode> tmpNodes=queue1;
			queue1=queue2;
			queue2=tmpNodes;
		}
			return list;
	}
	public static void main(String[] args) {
		TreeNode[] nodes=new TreeNode[5];
		for(int i=0;i<5;i++){
			nodes[i]=new TreeNode(i);
		}
		nodes[0].left=nodes[1];
		nodes[0].right=nodes[2];
		nodes[2].left=nodes[3];
		nodes[2].right=nodes[4];
		System.out.println(levelOrder2(null));
	}
}
