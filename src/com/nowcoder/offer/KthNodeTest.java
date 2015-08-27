package com.nowcoder.offer;

/*
 * 给定一颗二叉搜索树，请找出其中的第k大的结点。
 * 例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
 */
public class KthNodeTest {
	int i;
	boolean found;
	TreeNode ret;
	TreeNode KthNode(TreeNode pRoot, int k) {
		if(pRoot==null||k<=0)
			return null;
		inorder(pRoot, k);
		return ret;
	}
	private void inorder(TreeNode node,int k){
		
		if(!found&&node.left!=null)
			inorder(node.left, k);
		i++;
		if(i==k){
			ret=node;
			found=true;
			return;
		}
			
		if(!found&&node.right!=null)
			inorder(node.right, k);
	}
public static void main(String[] args) {
	TreeNode[] treeNodes=new TreeNode[5];
	for(int i=0;i<5;i++){
		treeNodes[i]=new TreeNode(i+1);
	}
	treeNodes[2].left=treeNodes[0];
	treeNodes[2].right=treeNodes[4];
	treeNodes[1].right=treeNodes[1];
	treeNodes[4].left=treeNodes[3];
	KthNodeTest test=new KthNodeTest();
	System.out.println(test.KthNode(treeNodes[2], 1));
	
}

}
