package com.nowcoder.offer;

import java.util.Arrays;

/*
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 */
public class SerializeAndDeserializeTree {
	 String Serialize(TreeNode root) {
	        StringBuilder builder=new StringBuilder();
	        if(root==null)
	        	return builder.toString();
	      return helpSerialize(root).toString();
	        
	  }
	 StringBuilder helpSerialize(TreeNode node){
		 StringBuilder builder=new StringBuilder();
		 if(node==null){
			 builder.append('#').append('/');
			 return builder;
		 }
		 builder.append(node.val).append('/');
		 builder.append(helpSerialize(node.left));
		 builder.append(helpSerialize(node.right));
		 return builder;
			 
	 }
	 TreeNode Deserialize(String str) {
		 if(str==null||str.length()==0)
			 return null;
		 String[] strings=str.split("/");
		return helpDeserialize(strings);
	  }
	 int i;
	 TreeNode helpDeserialize(String[] strings){
		 if(strings[i].equals("#"))
			 return null;
		 TreeNode node=new TreeNode(Integer.valueOf(strings[i]));
		 i++;
		 node.left=helpDeserialize(strings);
		 i++;
		 node.right=helpDeserialize(strings);
		 return node;
	 }
	 public static TreeNode createTree(){
		 TreeNode n1=new TreeNode(1);
		 TreeNode n2=new TreeNode(2);
		 TreeNode n3=new TreeNode(3);
		 TreeNode n4=new TreeNode(4);
		 TreeNode n5=new TreeNode(5);
		 TreeNode n6=new TreeNode(6);
		 n1.left=n2;
		 n1.right=n3;
		 n2.left=n4;
		 n2.right=n5;
		 n5.right=n6;
		 return n1;
	 }
	 public static void printTree(TreeNode node){
		 if(node==null)
			 return;
		 System.out.print(node+" ");
		 printTree(node.left);
		 printTree(node.right);
	 }
	 public static void main(String[] args) {
		SerializeAndDeserializeTree tree=new SerializeAndDeserializeTree();
		TreeNode rooTreeNode=createTree();
		String string=tree.Serialize(rooTreeNode);
		
		System.out.println(string);
		String[] c=string.split("/");
		System.out.println(Arrays.toString(c));
		TreeNode node=tree.Deserialize(string);
		System.out.println(node);
		printTree(node);
		System.out.println();
		System.out.println(tree.Serialize(node));
	}
}
