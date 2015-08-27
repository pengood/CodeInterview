package com.nowcoder.offer;

/*
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class IsBalancedTreeTest {
	boolean balanced=true;
	public boolean IsBalanced_Solution(TreeNode root) {
		if(root==null)
			return true;
		int left=deepth(root.left);
		if(!balanced){
			return false;
		}
		int right=deepth(root.right);
		if(!balanced){
			return false;
		}
		if(left-right>1||right-left>1){
			return false;
		}
		return true;
	}
	
	private int deepth(TreeNode node){
		if(node==null)
			return 0;
		int leftlen=deepth(node.left);
		if(!balanced)
			return 0;
		int rightlen=deepth(node.right);
		if(!balanced)
			return 0;
		if(leftlen-rightlen>1||rightlen-leftlen>1){
			balanced=false;
			return 0;
		}
		return leftlen>rightlen?leftlen+1:rightlen+1;
		
	}

}
