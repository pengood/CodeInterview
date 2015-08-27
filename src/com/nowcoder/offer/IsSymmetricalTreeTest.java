package com.nowcoder.offer;

/*
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class IsSymmetricalTreeTest {
	boolean isSymmetrical(TreeNode pRoot) {
		if(pRoot==null||pRoot.left==null&&pRoot.right==null)
			return true;
		if(pRoot.left==null||pRoot.right==null)
			return false;
		if(pRoot.left.val!=pRoot.right.val)
			return false;
		return helpSymmetrical(pRoot.left, pRoot.right);
	}
	
	private boolean helpSymmetrical(TreeNode node1,TreeNode node2){
		if(node1==null&&node2==null)
			return true;
		if(node1==null||node2==null)
			return false;
		if(node1.val!=node2.val)
			return false;
		return helpSymmetrical(node1.left, node2.right)&&helpSymmetrical(node1.right, node2.left);
	}
}
