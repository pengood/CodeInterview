package com.nowcoder.interview;

/*
 * 对于一棵二叉树，请设计一个算法，创建含有某一深度上所有结点的链表。
 给定二叉树的根结点指针TreeNode* root，以及链表上结点的深度，
 请返回一个链表ListNode，代表该深度上所有结点的值，请按树上从左往右的顺序链接，
 保证深度不超过树的高度，树上结点的值为非负整数且不超过100000。
 */
public class GetTreeLevel {
	public ListNode getTreeLevel(TreeNode root, int dep) {
		if(root==null||dep<1)
			return null;
		ListNode dump=new ListNode(-1);
		getNode(root, dump, 1,dep);
		return dump.next;
	}
	private ListNode getNode(TreeNode node,ListNode lNode,int currentdep,int dep){
		if(node==null)
			return lNode;
		if(currentdep==dep){
			lNode.next=new ListNode(node.val);
			return lNode.next;
		}
		ListNode node1=null,node2=null;
		if(node.left!=null)
		 node1 = getNode(node.left, lNode, currentdep+1, dep);
		if(node.right!=null)
			node2=getNode(node.right, node1, currentdep+1, dep);
		return node2;
	}
	public static void main(String[] args) {
		TreeNode node=TestUtils.createTree();
		TestUtils.printTreePreOrder(node);
		GetTreeLevel level=new GetTreeLevel();
		System.out.println();
		ListNode node2=level.getTreeLevel(node, 3);
		while(node2!=null){
			System.out.print(node2+" ");
			node2=node2.next;
		}
	}
}
