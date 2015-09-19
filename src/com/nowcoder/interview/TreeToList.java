package com.nowcoder.interview;
/*
 * 有一个类似结点的数据结构TreeNode，包含了val属性和指向其它结点的指针。
 * 其可以用来表示二叉查找树(其中left指针表示左儿子，right指针表示右儿子)。
 * 请编写一个方法，将二叉查找树转换为一个链表，其中二叉查找树的数据结构用TreeNode实现，链表的数据结构用ListNode实现。
	给定二叉查找树的根结点指针root，请返回转换成的链表的头指针
 */
public class TreeToList {
	ListNode lastInit;
	ListNode head;
	public ListNode treeToList(TreeNode root) {
		if(root==null)
			throw new IllegalArgumentException();
		convert(root);
		return head;
    }
	
	private void convert(TreeNode node){
		if(node==null)
			return;
		if(node.left!=null)
			convert(node.left);
		ListNode current=new ListNode(node.val);
		if(lastInit==null)
			head=current;
		if(lastInit!=null)
			lastInit.next=current;
		lastInit=current;
		if(node.right!=null)
			convert(node.right);
		
	}
	public static void main(String[] args) {
		TreeToList list=new TreeToList();
		TreeNode node=TestUtils.createTree();
		TestUtils.printTreeInOrder(node);
		System.out.println();
		ListNode node2=list.treeToList(node);
		while(node2!=null){
			System.out.print(node2+" ");
			node2=node2.next;
		}
	}
}
