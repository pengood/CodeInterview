package com.nowcoder.offer;

/*
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class ConvertTreeToListTest {
	TreeNode lastNodeInList;
	public TreeNode Convert(TreeNode pRootOfTree) {
		if(pRootOfTree==null)
			return null;
		convertToList(pRootOfTree);
		TreeNode head=lastNodeInList;
		while(head!=null&&head.left!=null)
			head=head.left;
		return head;
		
	}
	private void convertToList(TreeNode node){
		if(node==null)
			return;
		TreeNode curNode=node;
		if(curNode.left!=null)
			convertToList(curNode.left);
		curNode.left=lastNodeInList;
		if(lastNodeInList!=null)
			lastNodeInList.right=curNode;
		lastNodeInList=curNode;
		if(curNode.right!=null)
			convertToList(curNode.right);
	}
	public static void main(String[] args) {
		TreeNode node1=new TreeNode(10);
		TreeNode node2=new TreeNode(6);
		TreeNode node3=new TreeNode(14);
		TreeNode node4=new TreeNode(4);
		TreeNode node5=new TreeNode(8);
		TreeNode node6=new TreeNode(12);
		TreeNode node7=new TreeNode(16);
		node1.left=node2;
		node1.right=node3;
		node2.left=node4;
		node2.right=node5;
		node3.left=node6;
		node3.right=node7;
		ConvertTreeToListTest test=new ConvertTreeToListTest();
		TreeNode node=test.Convert(node1);
		while(node!=null){
			System.out.print(node.val+" ");
			node=node.right;
		}
			
	}
}
