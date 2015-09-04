package com.nowcoder.interview;

import java.util.Arrays;

/*
 * 现在我们要读入一串数，同时要求在读入每个数的时候算出它的秩，即在当前数组中小于等于它的数的个数(不包括它自身)，
 * 请设计一个高效的数据结构和算法来实现这个功能。
	给定一个int数组A，同时给定它的大小n，请返回一个int数组，元素为每次加入的数的秩。保证数组大小小于等于5000。
	测试样例：
	[1,2,3,4,5,6,7],7
	返回：[0,1,2,3,4,5,6]
 */
class RankNode{
	RankNode Left;
	RankNode Right;
	int val;
	int subCount;
	public RankNode(int x,int count) {
		// TODO Auto-generated constructor stub
		this.val=x;
		this.subCount=count;
	}
	
}
public class GetRankOfNumber {
	public int[] getRankOfNumber(int[] A, int n) {
		int[] ret=new int[n];
		RankNode root=null;
		for(int i=0;i<n;i++){
			ret[i]=getSubCount(root, A[i]);
			root=insert(root, A[i]);
		}
		return ret;
    }
	private RankNode insert(RankNode root, int x){
		if(root==null){
			return new RankNode(x, 1);
		}
		 return helpInsert(root, x);	
	}
	private RankNode helpInsert(RankNode node,int x){
		if(node==null)
			return new RankNode(x, 1);
		if(node.val>=x)
			node.Left=helpInsert(node.Left, x);
		else 
			node.Right=helpInsert(node.Right, x);
		node.subCount=getNodeCount(node.Left)+getNodeCount(node.Right)+1;
		return node;
	}
	private int getNodeCount(RankNode node){
		if(node==null)
			return 0;
		return node.subCount;
	}
	private int getSubCount(RankNode node,int x){
		if(node==null)
			return 0;
		if(node.val==x)
			return node.subCount;
		if(node.val>x)
			return getSubCount(node.Left, x);
		else {
			return getNodeCount(node.Left)+1+getSubCount(node.Right, x);
		}
	}
	public static void main(String[] args) {
		GetRankOfNumber number=new GetRankOfNumber();
		int[] a={1,1,1,4,5,6,7};
		int[] result=number.getRankOfNumber(a, 6);
		System.out.println(Arrays.toString(result));
	}
}
