package com.offer;

import java.util.LinkedList;

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int i) {
		// TODO Auto-generated constructor stub
		this.val=i;
	}
	public String toString(){
		return "node:"+val;
	}
}

public class ConstructTree {
	public static TreeNode construct(int[] pre,int[] in){
		return construct2(pre,0,pre.length-1, in,0,in.length-1);
	}
	public static TreeNode construct1(int[] preorder,int[] inorder){
		if(preorder.length==0)
			return null;
		if(preorder.length==1&&inorder.length==1)
			return new TreeNode(preorder[0]);
		int rootval=preorder[0];
		TreeNode rootNode=new TreeNode(rootval);
		int j=0;
		for(;j<inorder.length;j++){
			if(inorder[j]==rootval)
				break;
		}
		int len=preorder.length;
		int[] pre1=new int[j];
		int[] in1=new int[j];
		int[] pre2=new int[len-j-1];
		int[] in2=new int[len-j-1];
		for(int a=0;a<j;a++){
			pre1[a]=preorder[a+1];
			in1[a]=inorder[a];
		}
		for(int b=j+1,c=0;b<len;b++,c++){
			pre2[c]=preorder[b];
			in2[c]=inorder[b];
		}
		rootNode.left=construct(pre1, in1);
		rootNode.right=construct(pre2,in2);
		return rootNode;
	}
	
	public static TreeNode construct2(int[] pre,int prebegin,int preEnd,int[] in,int inbegin,int inEnd){
		if(prebegin==preEnd){
			assert inbegin==inEnd;
			return new TreeNode(pre[prebegin]);
		}
		int rootval=pre[prebegin];
		TreeNode root=new TreeNode(rootval);
		int j=inbegin,n=0;
		while(in[j]!=rootval)
			{
			j++;
			n++;
			}
		if(n>0){
			root.left=construct2(pre, prebegin+1, prebegin+n, in, inbegin, j-1);
		}
		if(n<preEnd-prebegin){
			root.right=construct2(pre, preEnd-n, preEnd, in, j+1, inEnd);
		}
		
		return root;
	}
	
	public static void printTreePre(TreeNode root){
		if(root==null)
			return;
		System.out.print(root.val+" ");
		printTreePre(root.left);
		printTreePre(root.right);
	}
	public static void printTreeIn(TreeNode root){
		if(root==null)
			return;
		printTreeIn(root.left);
		System.out.print(root.val+" ");
		printTreeIn(root.right);
	}
	private static void printTreeByOrder1(LinkedList<TreeNode> list){
		if(list.isEmpty())
			return;
		TreeNode node=list.pollFirst();
		System.out.print(node.val+" ");
		if(node.left!=null)
			list.addLast(node.left);
		if(node.right!=null)
			list.addLast(node.right);
		printTreeByOrder1(list);
	}
	public static void printTreeByOrder(TreeNode root){
		LinkedList<TreeNode> linkedList=new LinkedList<>();
		linkedList.addLast(root);
		printTreeByOrder1( linkedList);
	}
	public static void main(String[] args){
		int[] pre={1,2,4,7,3,5,6,8};
		int[] in={4,7,2,1,5,3,8,6};
		TreeNode rooTreeNode=construct(pre, in);
		printTreePre(rooTreeNode);
		System.out.println();
		printTreeIn(rooTreeNode);
		System.out.println();
		printTreeByOrder(rooTreeNode);
	}

}
