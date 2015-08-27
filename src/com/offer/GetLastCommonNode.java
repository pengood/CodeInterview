package com.offer;

import java.util.ArrayList;
import java.util.List;

public class GetLastCommonNode {
	public static TreeNode getCommonNode(TreeNode root,TreeNode node1,TreeNode node2){
		if(root==null||node1==null||node2==null)
			throw new IllegalArgumentException();
		List<TreeNode> list1=new ArrayList<TreeNode>();
		List<TreeNode> list2=new ArrayList<>();
		TreeNode last=null;
		if(findPath(root, node1, list1)&&findPath(root, node2, list2)){
			int i=0;
			while(i<list1.size()&&i<list2.size()){
				if(list1.get(i)==list2.get(i))
					last=list1.get(i);
				i++;
			}
		}
			return last;
		
	}
	
	private static boolean findPath(TreeNode root,TreeNode node,List<TreeNode> list){
		if(root==node)
			return true;
		list.add(root);
		boolean left=false,right=false,found=false;
		if(root.left!=null)
			left=findPath(root.left, node, list);
		if(root.right!=null)
			right=findPath(root.right, node, list);
		found=left||right;
		if(!found)
			list.remove(list.size()-1);
		return found;
	}
	public static void main(String[] args) {
		TreeNode[] nodes=new TreeNode[6];
		for(int i=0;i<6;i++)
			nodes[i]=new TreeNode(i);
		nodes[0].left=nodes[1];
		nodes[0].right=nodes[4];
		nodes[1].left=nodes[2];
		nodes[1].right=nodes[3];
		nodes[2].left=nodes[5];
		System.out.println(getCommonNode(nodes[0], nodes[3], nodes[5]));
	}
}
