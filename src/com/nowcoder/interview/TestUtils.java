package com.nowcoder.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/*
 * 单向链表类
 */
class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "" + val;
	}
}

class TreeNode {
	int val = 0;
	TreeNode left = null;
	TreeNode right = null;

	public TreeNode(int val) {
		this.val = val;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return val + " ";
	}
}

class DirectedGraphNode {
	int label = 0;
	DirectedGraphNode left = null;
	DirectedGraphNode right = null;
	ArrayList<DirectedGraphNode> neighbors = new ArrayList<DirectedGraphNode>();
	public DirectedGraphNode(int label) {
		this.label = label;
	}
	
}

public class TestUtils {
	/*
	 * 构造指定size链表
	 */
	public static ListNode creatListNode(int size) {
		if (size <= 0)
			return null;
		Random random = new Random(47);
		ListNode[] listNodes = new ListNode[size];
		for (int i = 0; i < size; i++) {
			listNodes[i] = new ListNode(random.nextInt(10));
			if (i > 0)
				listNodes[i - 1].next = listNodes[i];
		}
		return listNodes[0];
	}

	/*
	 * 通过数字构造链表
	 */
	public static ListNode createListNode(int[] array) {
		if (array == null || array.length == 0)
			return null;
		ListNode[] listNodes = new ListNode[array.length];
		for (int i = 0; i < listNodes.length; i++) {
			listNodes[i] = new ListNode(array[i]);
			if (i > 0)
				listNodes[i - 1].next = listNodes[i];
		}
		return listNodes[0];
	}

	/*
	 * 构造排序链表
	 */
	public static ListNode cretedSortedListNode(int size) {
		if (size <= 0)
			return null;
		Random random = new Random(47);
		ListNode[] listNodes = new ListNode[size];
		for (int i = 0; i < size; i++) {
			listNodes[i] = new ListNode(i + 5 + random.nextInt(5));
			if (i > 0)
				listNodes[i - 1].next = listNodes[i];
		}
		return listNodes[0];
	}

	public static void printListNode(ListNode node) {
		while (node != null) {
			System.out.print(node + " ");
			node = node.next;
		}
		System.out.println();
	}

	public static int[][] createArray(String string) {
		class pair {
			int x;
			int y;

			public pair(int a, int b) {
				x = a;
				y = b;
			}

			@Override
			public String toString() {
				return x + "," + y;
			}

		}
		List<pair> list = new ArrayList<pair>();
		string = string.substring(1, string.length() - 1);
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) == '[') {
				i++;
				int minus = 1;
				if (string.charAt(i) == '-') {
					minus = -1;
					i++;
				}
				int num1 = 0;
				int j = i;
				for (; j < string.length() && string.charAt(j) != ','; j++) {
					num1 = num1 * 10 + (string.charAt(j) - '0');
				}
				num1 *= minus;
				i = j + 1;
				minus = 1;
				if (string.charAt(i) == '-') {
					minus = -1;
					i++;
				}
				int num2 = 0;
				int k = i;
				for (; k < string.length() && string.charAt(k) != ']'; k++) {
					num2 = num2 * 10 + (string.charAt(k) - '0');
				}
				num2 *= minus;
				list.add(new pair(num1, num2));
				i = k;
			}
		}
		int[][] ret = new int[list.size()][2];
		for (int i = 0; i < list.size(); i++) {
			pair p = list.get(i);
			ret[i][0] = p.x;
			ret[i][1] = p.y;
		}
		return ret;
	}
/*
 * 					0
 * 				1		2
 * 			3		4
 * 				5		
 * 			6
 * 
 */
	public static TreeNode createTree() {
		TreeNode[] treeNodes = new TreeNode[7];
		for (int i = 0; i < 7; i++) {
			treeNodes[i] = new TreeNode(i);
		}
		treeNodes[0].left = treeNodes[1];
		treeNodes[0].right = treeNodes[2];
		treeNodes[1].left = treeNodes[3];
		treeNodes[1].right = treeNodes[4];
		treeNodes[3].right = treeNodes[5];
		treeNodes[5].left = treeNodes[6];
		return treeNodes[0];
	}
public static TreeNode createBST(){
	TreeNode[] nodes=new TreeNode[6];
	for(int i=1;i<6;i++){
		nodes[i]=new TreeNode(i);
	}
	nodes[4].left=nodes[2];
	nodes[4].right=nodes[5];
	nodes[2].left=nodes[1];
	nodes[2].right=nodes[3];
	return nodes[4];
}
	public static void printTreePreOrder(TreeNode node) {
		if (node == null)
			throw new IllegalArgumentException();
		System.out.print(node + " ");
		if (node.left != null)
			printTreePreOrder(node.left);
		if (node.right != null)
			printTreePreOrder(node.right);
	}
	
	public static void printTreeInOrder(TreeNode node){
		if(node==null)
			throw new IllegalArgumentException();
		if(node.left!=null)
			printTreeInOrder(node.left);
		System.out.print(node+" ");
		if(node.right!=null)
			printTreeInOrder(node.right);
	}

	public static void main(String[] args) {
		String string = "[[1,-5],[1,-1],[1,9],[1,9],[2,0],[2,1],[1,-8],[2,1],[1,-71],[1,-92],[1,18],[1,91],[1,61],[2,-1],[1,-35],[1,95],[1,-49],[1,9],[1,78],[2,0],[1,91],[1,-96],[2,-1],[2,0],[2,-1],[2,1],[1,38],[2,0],[1,45],[2,0],[1,-51],[2,1],[2,1],[2,-1],[1,39],[1,59],[1,45],[2,0],[1,-70],[2,0],[1,23],[1,88],[1,83],[1,69],[1,-78],[1,-3],[1,-9],[1,-20],[1,-74],[1,-62],[1,5],[1,55],[1,-36],[1,-21],[1,-94],[1,-27],[1,-69],[2,0],[1,-30],[1,-84],[2,0],[2,0],[2,-1],[1,92],[1,60],[2,1],[2,0],[1,-63],[2,0],[1,-87],[1,66],[2,0],[1,17],[2,0],[2,1],[1,-41],[1,-3],[1,-29],[1,72],[2,1],[1,35],[1,81],[1,-83],[1,-17],[1,36],[1,99],[1,-17],[1,8],[2,0],[1,80],[1,50],[1,80],[2,0],[1,-48],[1,-82],[1,-63],[1,2],[2,1],[1,-43],[1,59],[1,93],[1,55],[1,-93],[2,-1],[1,2],[1,13],[2,0]]";
		int[][] a = createArray(string);
		for (int i = 0; i < a.length; i++) {
			System.out.println(Arrays.toString(a[i]));
		}
	}
}
