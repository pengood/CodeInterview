package com.nowcoder.offer;

/*
 * 
 Given a binary tree containing digits from0-9only, each root-to-leaf path could represent a number.
 An example is the root-to-leaf path1->2->3which represents the number123.
 Find the total sum of all root-to-leaf numbers.
 For example,
 1
 / \
 2   3

 The root-to-leaf path1->2represents the number12.
 The root-to-leaf path1->3represents the number13.
 Return the sum = 12 + 13 =25.
 */
public class SumRootToLeafNumbersTest {
	int sum;
	public int sumNumbers(TreeNode root) {
		if(root==null)
			return 0;
		StringBuilder builder=new StringBuilder();
		helpSum(root, builder);
		return sum;
	}
	private void helpSum(TreeNode node,StringBuilder builder){
		if(node.left==null&&node.right==null){
			builder.append(node.val);
			sum+=Integer.valueOf(builder.toString());
			builder.deleteCharAt(builder.length()-1);
			return;
		}
		builder.append(node.val);
		if(node.left!=null)
			helpSum(node.left, builder);
		if(node.right!=null)
			helpSum(node.right, builder);
		builder.deleteCharAt(builder.length()-1);
	}
	public static void main(String[] args) {
		TreeNode[] nodes=new TreeNode[5];
		for(int i=0;i<nodes.length;i++){
			nodes[i]=new TreeNode(i);
		}
		nodes[0].right=nodes[1];
//		nodes[0].right=nodes[4];
//		nodes[1].left=nodes[2];
//		nodes[1].right=nodes[3];
		SumRootToLeafNumbersTest test=new SumRootToLeafNumbersTest();
		System.out.println(test.sumNumbers(nodes[0]));
	}
}
