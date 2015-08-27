package com.nowcoder.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
		
public class PrintTreeFromTopToBottomTest {
	 public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
	        ArrayList<Integer> list=new ArrayList<>();
	        if(root==null)
	        	return list;
	        Queue<TreeNode> queue=new LinkedList<TreeNode>();
	        queue.add(root);
	        while(!queue.isEmpty()){
	        	TreeNode node=queue.poll();
	        	list.add(node.val);
	        	if(node.left!=null)
	        		queue.add(node.left);
	        	if(node.right!=null)
	        		queue.add(node.right);
	        }
	        return list;
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
		PrintTreeFromTopToBottomTest test=new PrintTreeFromTopToBottomTest();
		System.out.println(test.PrintFromTopToBottom(nodes[0]));
	}
}
