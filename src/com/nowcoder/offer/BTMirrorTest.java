package com.nowcoder.offer;
/*
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class BTMirrorTest {
public void Mirror(TreeNode root) {
        if(root==null)
        	return;
        TreeNode tmpNode=root.left;
        root.left=root.right;
        root.right=tmpNode;
        Mirror(root.left);
        Mirror(root.right);
    }
}
