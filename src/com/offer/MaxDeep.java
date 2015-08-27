package com.offer;

class Depth{
	int deep;
	public String tString(){
		return ""+deep;
	}
}

public class MaxDeep {
	static int max=0;
	public static void maxdeep(TreeNode root,int d){
		if(root==null)
			return;
		int deep=++d;
		if(deep>max)
			max=deep;
		if(root.left!=null)
			maxdeep(root.left, deep);
		if(root.right!=null)
			maxdeep(root.right, deep);
	}
	
	public static int maxdeep2(TreeNode root){
		if(root==null)
			return 0;
		int left=maxdeep2(root.left);
		int right=maxdeep2(root.right);
		return left>right?(left+1):(right+1);
	}
	public static boolean isBalanced(TreeNode root,Depth depth){
		if(root==null){
			depth.deep=0;
			return true;
		}
		Depth left=new Depth();
		Depth right=new Depth();
		if(isBalanced(root.left, left)&&isBalanced(root.right, right)){
			int dif=left.deep-right.deep;
			if(dif<=1&&dif>=-1){
				depth.deep=1+(left.deep>right.deep?left.deep:right.deep);
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		TreeNode[] nodes=new TreeNode[6];
		for(int i=0;i<6;i++){
			nodes[i]=new TreeNode(i);
		}
		nodes[0].left=nodes[1];
		nodes[0].right=nodes[5];
		nodes[1].left=nodes[2];
		nodes[1].right=nodes[3];
		nodes[3].right=nodes[4];
		nodes[5].left=new TreeNode(7);
		maxdeep(nodes[0], 0);
		System.out.println(max);
		System.out.println(maxdeep2(nodes[0]));
		Depth depth=new Depth();
		System.out.println(isBalanced(null, depth));
	}

}
