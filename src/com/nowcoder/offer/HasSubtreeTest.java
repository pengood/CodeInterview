package com.nowcoder.offer;

/*
 * 输入两颗二叉树A，B，判断B是不是A的子结构。
 */
public class HasSubtreeTest {
	 public boolean HasSubtree(TreeNode root1,TreeNode root2) {
	        boolean result=false;
	        if(root1!=null&&root2!=null){
	        	if(root1.val==root2.val)
	        		result=doesHasSubTree(root1, root2);
	        	if(!result)
	        		result=HasSubtree(root1.left, root2);
	        	if(!result)
	        		result=HasSubtree(root1.right, root2);
	        }
	        return result;
	    }
	 private boolean doesHasSubTree(TreeNode node1,TreeNode node2){
		if(node2==null)
			return true;
		if(node1==null)
			return false;
		if(node1.val!=node2.val)
			return false;
		return doesHasSubTree(node1.left, node2.left)&&doesHasSubTree(node1.right, node2.right);
		
	 }
	 public static void main(String[] args) {
		TreeNode[] treeNodes=new TreeNode[6];
		for(int i=1;i<6;i++)
			treeNodes[i]=new TreeNode(i);
		treeNodes[1].left=treeNodes[2];
		treeNodes[1].right=treeNodes[3];
		treeNodes[2].left=treeNodes[4];
		treeNodes[2].right=treeNodes[5];
		TreeNode node=new TreeNode(2);
		TreeNode node2=new TreeNode(5);
		node.right=node2;
		HasSubtreeTest test=new HasSubtreeTest();
		System.out.println(test.HasSubtree(treeNodes[1], node));
	}
}
