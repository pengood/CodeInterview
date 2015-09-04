package com.nowcoder.interview;

import java.util.Arrays;

/*
 * 有两个从小到大排序以后的数组A和B，其中A的末端有足够的缓冲空容纳B。请编写一个方法，将B合并入A并排序。
	给定两个有序int数组A和B，A中的缓冲空用0填充，同时给定A和B的真实大小int n和int m，请返回合并后的数组。
 */
public class MergeAB {
	public int[] mergeAB(int[] A, int[] B, int n, int m) {
		int len=m+n;
		if(len>A.length)
			throw new IllegalArgumentException();
		int pos=len-1;
		int posA=n-1;
		int posB=m-1;
		while(posA>=0&&posB>=0){
			if(A[posA]>B[posB]){
				A[pos]=A[posA];
				posA--;
			}else {
				A[pos]=B[posB];
				posB--;
			}
			pos--;
		}
		while(posA>=0){
			A[pos]=A[posA];
			pos--;
			posA--;
		}
		while(posB>=0){
			A[pos]=B[posB];
			pos--;
			posB--;
		}
		return A;
    }
	public static void main(String[] args) {
		int[] A={1,3,5,7,9,0,0,0,0,0,0};
		int[] B={2,3,4,6};
		MergeAB mergeAB=new MergeAB();
		int[] re=mergeAB.mergeAB(A, B, 5, 4);
		System.out.println(Arrays.toString(re));
	}
}
